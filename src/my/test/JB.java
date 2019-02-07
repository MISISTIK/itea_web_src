package my.test;

import java.sql.*;
import java.util.ResourceBundle;

public class JB {

    private static Connection conn = null;
    private static  PreparedStatement ps;
    private static String url = "jdbc:mysql://%s/%s?user=%s&password=%s";
    static ResourceBundle  config;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            config = ResourceBundle.getBundle(ResourceBundle.getBundle("config").getString("config"));
            String host = config.getString("host");
            String db = config.getString("db");
            String user = config.getString("user");
            String psw = config.getString("psw");
            url = String.format(url, host, db, user, psw);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Connection....");
        try {
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);

            conn.commit();
        } catch (SQLException e) {
            System.out.println("Failure...");
            System.out.println("SQLException " + e.getMessage());
            System.out.println("SQLState " + e.getSQLState());
            System.out.println("VendorError..." + e.getErrorCode());
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                if (conn != null) { conn.close(); }
                if (ps != null) { ps.close(); }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Connection obtained");
    }

}
