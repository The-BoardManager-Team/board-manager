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
    //private static final String PASSWORD = "ritepa64";
    private static final String PASSWORD = "Inha1958";

    /**
     * 데이터베이스 연결 생성
     * UI 화면에서 직접 쿼리 실행 시 사용
     *
     * @return Connection 객체
     * @throws SQLException 연결 실패 시
     */
    public Connection getConnection() throws SQLException {
        try {
            // JDBC 드라이버 로드
            Class.forName(DRIVER); // 메모리에 올라갈 DB 드라이버 명시 

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL 드라이버를 찾을 수 없습니다.", e);
        }
    }

    /**
     * 로그인 검증
     * SQL Injection 방지를 위해 PreparedStatement 사용
     *
     * @param id 사용자 ID
     * @param pw 비밀번호
     * @return 로그인 성공 여부
     */
    public boolean checkLogin(String id, String pw) {
        String sql = "SELECT * FROM users WHERE username=? AND password=?";

        // try-with-resources: 자동으로 리소스 해제
        // 괄호 안에 생성된 conn, pstmt는 try 끝날 시 자동 닫힘 
        // PreparedStatement: SQL 실행 담당 객체. 미리 준비된 SQL문.
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // DB에게 실행 도구 생성 요청 

            // set으로 물음표 채움. 숫자일 시 setInt
            pstmt.setString(1, id); // 첫 번째 물음표, 넣을 변수
            pstmt.setString(2, pw);

            // ResultSet: DB 쿼리문 결과 표를 담는 객체 
            try (ResultSet rs = pstmt.executeQuery()) { // executeQuery: SELECT 쿼리 실행.
                // next: 커서 다음 줄로. 커서를 내려서 데이터가 있다면 true. 로그인 성공.
                return rs.next(); 
            }

        } catch (SQLException e) {
            System.err.println("로그인 검증 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 사용자 정보를 조회하여 UserSession에 저장
     * 로그인 성공 후 호출하여 세션 초기화
     *
     * @param id 사용자 ID
     * @return 조회 성공 여부
     */
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
