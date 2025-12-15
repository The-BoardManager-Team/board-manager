import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DBConnection {
    // 데이터베이스 연결 정보
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/boardmanager?characterEncoding=UTF-8&serverTimezone=UTC";

    // 각자 환경에 맞게 비밀번호 변경 필요
    private static final String USER = "root";
    private static final String PASSWORD = "ritepa64"; // 김용진 전용! 
    // private static final String PASSWORD = "Inha1958";

   // DB Connection 메서드 
    public Connection getConnection() throws SQLException {
        try {
            // JDBC 드라이버 로드
            Class.forName(DRIVER); // 메모리에 올라갈 DB 드라이버 명시 

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL 드라이버를 찾을 수 없습니다.", e);
        }
    }

    // 로그인 검증
    public boolean checkLogin(String id, String pw) {
        String sql = "SELECT * FROM users WHERE username=? AND password=?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // DB에게 실행 도구 생성 요청 

            pstmt.setString(1, id); 
            pstmt.setString(2, pw);

            try (ResultSet rs = pstmt.executeQuery()) { 
                // next: 커서 다음 줄로. 커서를 내려서 데이터가 있다면 true. 로그인 성공.
                return rs.next(); 
            }

        } catch (SQLException e) {
            System.err.println("로그인 검증 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // 사용자 정보 호출 
    public boolean loadUserSession(String id) {
        String sql = "SELECT username, name, role FROM users WHERE username=?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // UserSession에 직접 저장
                    UserSession.setCurrentUser(
                        rs.getString("username"),
                        rs.getString("name"),
                        rs.getString("role")
                    );
                    return true;
                }
            }

        } catch (SQLException e) {
            System.err.println("사용자 정보 조회 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }
}
