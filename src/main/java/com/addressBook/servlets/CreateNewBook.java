package com.addressBook.servlets;

import com.addressBook.jsonData.AddressBookController;
import com.addressBook.jsonData.AddressBookException;
import com.addressBook.filesSystem.FileManagerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/jsp/CreateNewBook")
public class CreateNewBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newBookName = req.getParameter("newBookName");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        UsersInfo usersInfo = new UsersInfo("./src/main/resources/userInfo.json");
        for (User user1 : usersInfo.usersList) {
            if (user1.password.equals(user.password) && user1.userName.equals(user.userName)) {
                user1.addressBookNames.add(newBookName);
                break;
            }
        }
        try {
            if (new AddressBookController().createNewBook(newBookName)) {
                new FileManagerFactory().getFileManager().writeIntoFile("./src/main/resources/userInfo.json", usersInfo);
                user.addressBookNames.add(newBookName);
                session.setAttribute("user", user);
            }

        } catch (AddressBookException ignored) {   }
        ServletContext servletContext = this.getServletContext();
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/jsp/home.jsp");
        dispatcher.forward(req,resp);

    }
}
