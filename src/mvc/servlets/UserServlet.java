package mvc.servlets;

import mvc.controller.UserController;
import mvc.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        UserController userController = new UserController();
        User user = new UserController().getUser();
        RequestDispatcher rd = req.getRequestDispatcher("userView.jsp");
        req.setAttribute("user",user);
        rd.forward(req,resp);
    }
}
