package my.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.write("POST method invoced");
    }

    private String s = "<body>\n" +
            "<form id=\"loginForm\" action=\"/myservlet\" method=\"post\">\n" +
            "\n" +
            "    <div class=\"field\">\n" +
            "        <label>Enter your login:</label>\n" +
            "        <div class=\"input\"><input type=\"text\" name=\"login\" value='' id=\"login\" /></div>\n" +
            "    </div>\n" +
            "\n" +
            "    <div class=\"field\">\n" +
            "        <a href=\"#\" id=\"forgot\">Forgot your password?</a>\n" +
            "        <label>Enter your password:</label>\n" +
            "        <div class=\"input\"><input type=\"password\" name=\"password\" value=\"\" id=\"pass\" /></div>\n" +
            "    </div>\n" +
            "\n" +
            "    <div class=\"submit\">\n" +
            "        <button type=\"submit\">Enter</button>\n" +
            "        <label id=\"remember\"><input name=\"remember_me\" type=\"checkbox\" value=\"\"/> Remember me</label>\n" +
            "    </div>\n" +
            "\n" +
            "</form>\n" +
            "</body>";
}
