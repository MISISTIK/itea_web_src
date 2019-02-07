package my.servlets;

import my.beans.Dog;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("myVar", "SomeVar");
        Dog dog = new Dog();
        List<String> list = new ArrayList<>();
        list.add("item 1");
        list.add("item 2");
        list.add("item 3");
        dog.setName("Sobaka");
        req.setAttribute("dog", dog);
        req.setAttribute("list", list);
        req.setAttribute("myVar", "SomeVar");
        RequestDispatcher rd = req.getRequestDispatcher("some.jsp");
        rd.forward(req, resp);
    }
}
