package com.addressBook.servlets;

import com.addressBook.filesSystem.FileManager;
import com.addressBook.filesSystem.FileManagerFactory;
import com.addressBook.jsonData.AddressBookController;
import com.addressBook.jsonData.AddressBookException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/jsp/DeleteBook")
public class DeleteBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String addressBookName = (String) session.getAttribute("addressBookName");
        AddressBookController controller = new AddressBookController();
        try {
            controller.loadAddressBook(addressBookName);
        } catch (AddressBookException ignored) { }
        controller.delete(addressBookName);
        UsersInfo usersInfo = new UsersInfo("./src/main/resources/userInfo.json");
        User user = (User) session.getAttribute("user");
        usersInfo.usersList.stream().forEach(user1 -> {
            if (user.userName.equals(user1.userName))
                user1.addressBookNames.remove(addressBookName);
        });
        user.addressBookNames.remove(addressBookName);
        FileManager fileManager = new FileManagerFactory().getFileManager();
        fileManager.writeIntoFile("./src/main/resources/userInfo.json", usersInfo);
        session.setAttribute("user", user);
        ServletContext servletContext = this.getServletContext();
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/jsp/home.jsp");
        dispatcher.forward(req,resp);
    }
}
