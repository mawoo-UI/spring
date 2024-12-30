package cookie;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class InsertMemberData {

    // 데이터베이스 연결 정보
    private static final String DB_URL = "jdbc:mariadb://np.oneweeks.co.kr:3306/cookie";
    private static final String DB_USER = "pink_cookie";
    private static final String DB_PASSWORD = "1234";

    // 샘플 데이터 생성
    public static void main(String[] args) {
        int numberOfRecords = 500;

        // 중복된 ID 생성을 방지하기 위한 Set
        Set<String> existingIds = new HashSet<>();

        // 한글 음절 범위: U+AC00 (44032) ~ U+D7A3 (55203)
        int minHangul = 44032;
        int maxHangul = 55203;

        // 랜덤 생성기
        Random random = new Random();

        // 데이터베이스 연결 및 데이터 삽입
        String insertSQL = "INSERT INTO tbl_member (id, pw, name, email, tel, birth, addr, detail_addr, black_list, admin, email_check, marketing_agree, nick) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            conn.setAutoCommit(false); // 트랜잭션 시작

            for (int i = 1; i <= numberOfRecords; i++) {
                String newId;
                // 고유한 6글자 영문 대문자 ID 생성
                do {
                    newId = generateRandomUppercaseId(6, random);
                } while (existingIds.contains(newId));

                existingIds.add(newId);

                String pw = "1234";
                String name = "이름" + i;
                String email = newId + "@gmail.com";
                String tel = generateRandomTel(random);
                Date birth = generateRandomBirthDate(random);
                String addr = "서울시 구" + (random.nextInt(100) + 1) + "동";
                String detailAddr = "상세주소 " + (random.nextInt(1000) + 1);
                int blackList = 0;
                int admin = 0;
                int emailCheck = 1;
                int marketingAgree = 1;
                String nick = NickCreator.koreanNicknames[i];

                // PreparedStatement에 값 설정
                pstmt.setString(1, newId);
                pstmt.setString(2, pw);
                pstmt.setString(3, name);
                pstmt.setString(4, email);
                pstmt.setString(5, tel);
                pstmt.setDate(6, birth);
                pstmt.setString(7, addr);
                pstmt.setString(8, detailAddr);
                pstmt.setInt(9, blackList);
                pstmt.setInt(10, admin);
                pstmt.setInt(11, emailCheck);
                pstmt.setInt(12, marketingAgree);
                pstmt.setString(13, nick);

                pstmt.addBatch();

                // 배치 사이즈에 도달하면 일괄 실행
                if (i % 100 == 0) {
                    pstmt.executeBatch();
                    conn.commit();
                }
            }

            // 남은 배치 실행
            pstmt.executeBatch();
            conn.commit();

            System.out.println(numberOfRecords + "개의 샘플 데이터가 tbl_member에 성공적으로 삽입되었습니다.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 랜덤 6글자 영문 대문자 ID 생성
    private static String generateRandomUppercaseId(int length, Random random) {
        StringBuilder sb = new StringBuilder(length);
        for(int i = 0; i < length; i++) {
            char c = (char) ('a' + random.nextInt(26));
            sb.append(c);
        }
        return sb.toString();
    }

    // 랜덤 전화번호 생성 (010-XXXX-XXXX)
    private static String generateRandomTel(Random random) {
        int part1 = 1000 + random.nextInt(9000);
        int part2 = 1000 + random.nextInt(9000);
        return "010-" + String.format("%04d", part1) + "-" + String.format("%04d", part2);
    }

    // 랜덤 생년월일 생성 (1970-01-01 ~ 2000-12-28)
    private static Date generateRandomBirthDate(Random random) {
        int year = 1970 + random.nextInt(31); // 1970 ~ 2000
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(28); // 각 월의 최대 일수를 고려하여 28일로 고정
        return Date.valueOf(year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day));
    }

    // 랜덤 한글 닉네임 생성 (지금은 2음절)
    private static String generateRandomHangulNickname(int syllableCount, int minHangul, int maxHangul, Random random) {
        StringBuilder sb = new StringBuilder(syllableCount);
        for(int i = 0; i < syllableCount; i++) {
            char syllable = (char) (minHangul + random.nextInt(maxHangul - minHangul + 1));
            sb.append(syllable);
        }
        return sb.toString();
    }
}