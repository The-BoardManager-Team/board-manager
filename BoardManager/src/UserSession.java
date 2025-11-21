/**
 * 로그인한 사용자의 세션 정보를 관리하는 싱글톤 클래스
 * 애플리케이션 전역에서 현재 로그인한 사용자 정보에 접근 가능
 */
public class UserSession {
    // 로그인한 사용자 ID
    private static String loginUserId = null;

    // 로그인한 사용자 이름
    private static String userName = null;

    // 로그인한 사용자 역할 (관리자, 부장, 평회원)
    private static String userRole = null;

    /**
     * 로그인 여부 확인
     *
     * @return 로그인 상태면 true, 아니면 false
     */
    public static boolean isLoggedIn() {
        return loginUserId != null;
    }

    /**
     * 사용자 세션 설정 (로그인 성공 시 호출)
     *
     * @param userId 사용자 ID
     * @param name 사용자 이름
     * @param role 사용자 역할 (관리자/부장/평회원)
     */
    public static void setCurrentUser(String userId, String name, String role) {
        loginUserId = userId;
        userName = name;
        userRole = role;
    }

    /**
     * 현재 로그인한 사용자 ID 반환
     *
     * @return 사용자 ID (로그인 안 되어 있으면 null)
     */
    public static String getUserId() {
        return loginUserId;
    }

    /**
     * 현재 로그인한 사용자 이름 반환
     *
     * @return 사용자 이름 (로그인 안 되어 있으면 null)
     */
    public static String getUserName() {
        return userName;
    }

    /**
     * 현재 로그인한 사용자 역할 반환
     *
     * @return 사용자 역할 (관리자/부장/평회원, 로그인 안 되어 있으면 null)
     */
    public static String getRole() {
        return userRole;
    }

    /**
     * 세션 초기화 (로그아웃)
     * 모든 사용자 정보를 null로 설정
     */
    public static void clear() {
        loginUserId = null;
        userName = null;
        userRole = null;
    }
}
