package my.jdbc;

import javax.xml.transform.Result;
import java.sql.*;

public class DBWorker {
    private Connection conn = null;
    private Statement st;
//    String url = "jdbc:mysql://s3.thehost.ua/itea2?" +
//            "user=helen&password=123456";
    private String url = "jdbc:mysql://localhost/dbitea?" +
                "user=mysql&password=mysql";
    private final static String GET_USERS = "select * from users";
    private final static String INSERT_USER = "insert into users " +
            "(login, password, name, age, gender, address, comment) " +
            "values " +
            "(?,?,?,?,?,?,?)" ;

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

    public String getUsers() {
        StringBuilder buf = new StringBuilder();
        buf.append("<table border='1'>");
        try {
            ResultSet rs = st.executeQuery(GET_USERS);
            buf.append("<tr><td>Login</td><td>");
            buf.append("Name").append("</td><td>");
            buf.append("Age").append("</td><td>");
            buf.append("Gender").append("</td><td>");
            buf.append("Address").append("</td><td>");
            buf.append("Comment");
            buf.append("</td></tr>");
            while(rs.next()) {
                buf.append("<tr><td>")
                        .append(rs.getString(2)).append("</td><td>");
                buf.append(rs.getString(4)).append("</td><td>");
                buf.append(rs.getInt(5)).append("</td><td>");
                buf.append(rs.getString(6)).append("</td><td>");
                buf.append(rs.getString(7)).append("</td><td>");
                buf.append(rs.getString(8));
                buf.append("</td></tr>");
            }
            buf.append("</table>");
            System.out.println(buf.toString());
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }

    public boolean checkUserByLogin(String login) {
        final String sql = String.format("select * from users where login = '%s'",login);
        try {
            st.executeQuery(sql);
            ResultSet rs = st.getResultSet();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String registerUser(
            String login,
            String password,
            String name,
            String age,
            String gender,
            String address,
            String comment
    ) {
        try {
            PreparedStatement ps = conn.prepareStatement(INSERT_USER);
            ps.setString(1,login);
            ps.setString(2,password);
            ps.setString(3,name);
            ps.setInt(4,Integer.parseInt(age));
            ps.setString(5,gender);
            ps.setString(6,address);
            ps.setString(7,comment);
            ps.execute();

            return "true";
        } catch (SQLException e) {
            e.printStackTrace();
            return "<font color = 'red'>SQLException : " + e.getMessage() + " SQLState : " + e.getSQLState() +"</font>";
        }
    }

    public void close() {
        try {
            if (st != null) st.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
