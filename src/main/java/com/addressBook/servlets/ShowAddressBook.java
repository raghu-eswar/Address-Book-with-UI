package com.addressBook.servlets;

import com.addressBook.jsonData.AddressBookController;
import com.addressBook.jsonData.AddressBookException;
import com.addressBook.jsonData.PersonDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/jsp/ShowAddressBook")
public class ShowAddressBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookName = req.getParameter("bookName");
        HttpSession session = req.getSession();
        AddressBookController bookController = new AddressBookController();
        try {
            bookController.loadAddressBook(bookName);
        } catch (AddressBookException e) {    }
        List<PersonDTO> personDTOS = bookController.displayBook(bookName);
        session.setAttribute("addressBookName", bookName);
        session.setAttribute("addressBook", personDTOS);
        ServletContext servletContext = this.getServletContext();
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/jsp/home.jsp");
        dispatcher.forward(req,resp);
    }
}

