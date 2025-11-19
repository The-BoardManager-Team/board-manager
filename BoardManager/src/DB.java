import java.sql.*;
import java.io.*;

public class DB{
    String strDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String strURL = "jdbc:sqlserver://localhost:1433;DatabaseName=BoardManager;";
    String strEncrypt = "encrypt=true;trustServerCertificate=true;";
    String strUser = "sa";
    String strPWD = "inha1958";
    
    Connection DB_con;
    PreparedStatement DB_stmt;
    ResultSet DB_rs;
    
    public void dbOpen() throws IOException{
        HG_ErrorMessage();
        try {
            Class.forName(strDriver);
            strURL += strEncrypt;
            
            DB_con = DriverManager.getConnection(strURL, strUser, strPWD);
            
        } catch(Exception e){
            System.out.println("SQLException : " + e.getMessage());
            System.out.println("SQLException : " + e.toString());
            e.printStackTrace();
        }
    }
    public void dbClose() throws IOException{
        try{
            if (DB_rs != null) DB_rs.close();
            if (DB_stmt != null) DB_stmt.close();
            if (DB_con != null) DB_con.close();
        } catch(SQLException e){
            System.out.println("SQLException : " + e.getMessage());
        }
    }
    
    public boolean checkLogin(String id, String pw) {
        boolean result = false;
        
        try {
            dbOpen();

            String sql = "SELECT * FROM Member WHERE ID=? AND PW=?";
            DB_stmt = DB_con.prepareStatement(sql);
            DB_stmt.setString(1, id);
            DB_stmt.setString(2, pw);

            DB_rs = DB_stmt.executeQuery();

            if (DB_rs.next()) {
                result = true; // 로그인 성공
            }

        } catch (Exception e) {
            e.printStackTrace();
        } try {
            dbClose();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public UserDTO getUserInfo(String id) {
        UserDTO user = null;

        try {
            dbOpen();

            String sql = "SELECT ID, Name, Role FROM Member WHERE ID=?";
            DB_stmt = DB_con.prepareStatement(sql);
            DB_stmt.setString(1, id);

            ResultSet rs = DB_stmt.executeQuery();

            if (rs.next()) {
                user = new UserDTO();
                user.setId(rs.getString("ID"));
                user.setName(rs.getString("Name"));
                user.setRole(rs.getString("Role"));
            }

            dbClose();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { dbClose(); } catch (Exception ignored) {}
        }

        return user;
    }

    
    public void HG_ErrorMessage() throws UnsupportedEncodingException{
        try{
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch(java.io.UnsupportedEncodingException ex){
            ex.printStackTrace();
        }
    }
}

