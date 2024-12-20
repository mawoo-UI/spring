package cokr.oneweeks.member_post.vo;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.UUID;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
// import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;

// @Data //상호 호출을 막아야해서 Data사용안함/사용하더라도 따로따로 사용/상호호출,스택오브플로우/프로토 타입으로 해야함
//싱글톤일경우 파일 하나만 호출됨
//상속 포함,합성/

@Getter
@Setter
@ToString
// @EqualsAndHashCode(of = "uuid") //uuid만 가지고
//오브젝트가 갖고있는 class/해쉬코드가 같은지//of:직렬화 제외시킴,한개만 제외시/exclude:여러개 제외시
@Builder
@Alias("attach")
@AllArgsConstructor
@Log4j2
@NoArgsConstructor
public class Attach {
	private String uuid;
	private String origin;
	private String path; //날짜별 폴더
	private boolean image;
	private long pno;
	
	// @Value("${upload.path}")
	private static String UPLOAD_PATH = "c:/upload";

	// [] {} : "",
	public Attach(MultipartFile file) {
		this.origin = file.getOriginalFilename();
		int dotIdx = origin.lastIndexOf(".");
		String ext = "";
		if(dotIdx != -1) {
			ext = origin.substring(dotIdx);
		}
		uuid = UUID.randomUUID().toString();
		String realName = uuid = uuid + ext;
		path = getTodayStr();
		File parentPath = new File(UPLOAD_PATH, path);
		if(!parentPath.exists()) {
			parentPath.mkdirs();
		}
		try {
			File f = new File(parentPath, realName);
			file.transferTo(f);


			//마임타입 체크
			String mime = Files.probeContentType(f.toPath());
			image = mime != null && mime.startsWith("image");

			//thumbnailtor
			if(image) {
				File thumb = new File(parentPath, "t_" + realName);
				Thumbnailator.createThumbnail(f, thumb, 100, 100);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public File toFile() {
		return new File(new File(UPLOAD_PATH, path), uuid);
	}
	
	public String getTodayStr() {
        return new SimpleDateFormat("yyyy/MM/dd").format(System.currentTimeMillis());
    }

	public static Attach fromFile(File file) {
		//uuid보장 //파일시스템을 빌더하면된다.(?)
		return Attach.builder().uuid(file.getName()).build();

	}
	@Override
	public boolean equals(Object obj) {
		return obj != null && obj instanceof Attach && uuid.equals(((Attach)obj).uuid);
	}

	@Override
	public int hashCode() {

		return uuid.hashCode();
	}

}
