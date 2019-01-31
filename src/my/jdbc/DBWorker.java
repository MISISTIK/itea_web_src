package my.jdbc;

import javax.xml.transform.Result;
import java.sql.*;

public class DBWorker {
    Connection conn = null;
    Statement st;
    String url = "jdbc:mysql://s3.thehost.ua/itea2?" +
            "user=helen&password=123456";
    final static String GET_ANIMALS = "select * from ss";

    public DBWorker() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Connection....");
        try {
            conn = DriverManager.getConnection(url);
            st = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Failure...");
            System.out.println("SQLException " + e.getMessage());
            System.out.println("SQLState " + e.getSQLState());
            System.out.println("VendorError..." + e.getErrorCode());
        }
        System.out.println("Connection obtained");
    }

    public String getRows() {
        StringBuilder buf = new StringBuilder();
        buf.append("<table>");
        try {
            ResultSet rs= st.executeQuery(GET_ANIMALS);

            while(rs.next()) {
                buf.append("<tr><td>" + rs.getString(1)).append("</td><td>");
                buf.append(rs.getString(2)).append("</td><td>");
                buf.append(rs.getString(3)).append("</td></tr>");
            }
            buf.append("</table>");
            System.out.println(buf.toString());
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }

    public void close () {
        try {
            if (st != null) st.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
