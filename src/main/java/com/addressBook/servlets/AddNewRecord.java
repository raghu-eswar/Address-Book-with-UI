package com.addressBook.servlets;

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

@WebServlet("/jsp/AddNewRecord")
public class AddNewRecord extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phoneNo = req.getParameter("phoneNo");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        String zip = req.getParameter("zip");
        System.out.println(firstName+"    "+lastName+"   "+phoneNo);
        HttpSession session = req.getSession();
        String bookName = (String) session.getAttribute("addressBookName");
        AddressBookController bookController = new AddressBookController();
        try {
            bookController.loadAddressBook(bookName);
            bookController.addNewData(bookName,firstName, lastName, phoneNo, city, state,zip);
        } catch (AddressBookException ignored) {  ignored.printStackTrace();  }
        bookController.save(bookName);
        session.setAttribute("addressBook", bookController.displayBook(bookName));
        ServletContext servletContext = this.getServletContext();
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/jsp/home.jsp");
        dispatcher.forward(req,resp);
    }
}
