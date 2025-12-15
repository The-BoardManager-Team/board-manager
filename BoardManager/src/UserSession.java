
// 로그인한 사용자 정보 관리하는 싱글톤 클래스 
public class UserSession {

    private static String loginUserId = null;
    private static String userName = null;
    private static String userRole = null;
    
    public static boolean isLoggedIn() {
        return loginUserId != null;
    }

    // 로그인
    public static void setCurrentUser(String userId, String name, String role) {
        loginUserId = userId;
        userName = name;
        userRole = role;
    }

    public static String getUserId() {
        return loginUserId;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getRole() {
        return userRole;
    }

    // 로그아웃
    public static void clear() {
        loginUserId = null;
        userName = null;
        userRole = null;
    }
}
