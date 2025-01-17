package cokr.oneweeks.club.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cokr.oneweeks.club.entity.dto.AttachDto;
import cokr.oneweeks.club.service.S3Service;
import lombok.extern.log4j.Log4j2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/v1/file")
@Log4j2
public class FileController {

  @Autowired
  private S3Service service;

  @Value("${aws.s3.bucket-name}")
  private String bucketName;

  @Value("${aws.s3.region}")
  private String region;

  @PostMapping("/upload")
  public ResponseEntity<?> uploadFile(@RequestParam("file") List<MultipartFile> files) {
    List<AttachDto> list = new ArrayList<>();
    for(MultipartFile file : files){
      try {
        // Extract file details
        String origin = file.getOriginalFilename();
        String path = path();
        String uuid = UUID.randomUUID().toString();

        
        String ext = "";
        if (origin == null) {
          continue;
        }

        int idx = origin.lastIndexOf(".");
        if (idx > 0) {
          ext = origin.substring(idx+1);
        }
        
        String fileName = uuid + "." + ext;
        String key = "uploads/" + path + "/" + fileName; //
        String mimeType = file. getContentType();
        byte[] content = file.getBytes();

      // Upload file to S3
      //String s3Path = s3Service.uploadFile(key, content, mimeType);

      // Prepare response data
      // Map<String, Object> responseData = new HashMap<>();
      // responseData.put("fileName", fileName);
      // responseData.put("fileSize", file.getSize());
      // responseData.put("fileType", mimeType);
      // // responseData.put("s3Path", s3Path);
      // responseData.put("s3Key", key);
      // responseData.put("uploadTime", ZonedDateTime.now().toString());

      // s3 upload
      service.uploadFile(key, content, mimeType);
      
      AttachDto dto = AttachDto.builder()
        .uuid(uuid)
        .origin(origin)
        .image(mimeType != null && mimeType.startsWith("image/"))
        .path(path)
        .size(file.getSize())
        .mime(mimeType)
        .fileName(fileName)
        .ext(mimeType)
        .url(String.format("https://%s.s3.amazonaws.com/%s", bucketName, region, key))
        .build();

        list.add(dto);

      } catch (Exception e) {
        log.error(e.getMessage());
      }
    }
    log.info(list);
    return ResponseEntity.ok().body(list);
    }

    private String path() {
      return new SimpleDateFormat("/yyyy/MM/dd").format(new Date());
    }
}
  