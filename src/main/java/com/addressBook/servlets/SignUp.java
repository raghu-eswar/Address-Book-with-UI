package com.addressBook.servlets;

import com.addressBook.filesSystem.FileManager;
import com.addressBook.filesSystem.FileManagerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("password");
        UsersInfo usersInfo = new UsersInfo("./src/main/resources/userInfo.json");
        usersInfo.usersList.add(new User(userName,userPassword));
        FileManager fileManager = new FileManagerFactory().getFileManager();
        fileManager.writeIntoFile("./src/main/resources/userInfo.json", usersInfo);
        resp.sendRedirect("/AddressBook");
    }
}
