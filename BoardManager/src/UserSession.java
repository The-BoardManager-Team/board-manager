public class UserSession {

    private static String loginUserId = null;
    private static String currentUser = null;
    private static String currentRole = null;

    
    public static boolean isLoggedIn() {
        return loginUserId != null;
    }
    
    // 현재 로그인한 유저 이름 반환
    public static void setCurrentUser(String userId, String userName, String role) {
        loginUserId = userId;
        currentUser = userName;
        currentRole = role;
    }
    
    // 현재 로그인한 유저 ID 반환
    public static String getUserId() { return loginUserId; }
    // 현재 로그인한 유저 이름 반환
    public static String getUsername(){ return loginUserId; }
    // 현재 로그인한 유저 역할 반환
    public static String getRole() { return currentRole; }

    // 로그아웃 (모든 정보 초기화)
    public static void clear() {
        loginUserId = null;
        currentUser = null;
        currentRole = null;
    }
}
