package com.addressBook.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("password");
        UsersInfo usersInfo = new UsersInfo("./src/main/resources/userInfo.json");
        final User[] user = {null};
        usersInfo.usersList.forEach(user1 -> {
            if (user1.userName.equals(userName) && user1.password.equals(userPassword))
                user[0] = user1;
        });
        if(user[0] == null){
            resp.getWriter().println("<html><body onload=\"alert('Hello World')\"></body></html>");
            resp.sendRedirect("/AddressBook");
        }
        HttpSession session = req.getSession();
        session.setAttribute("user", user[0]);
        resp.sendRedirect("jsp/home.jsp");
    }
}
