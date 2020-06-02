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

@WebServlet("/jsp/ShowPersonInfo")
public class ShowPersonInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String phoneNo = req.getParameter("phoneNo");
        HttpSession session = req.getSession();
        AddressBookController controller = new AddressBookController();
        String addressBookName = (String) session.getAttribute("addressBookName");
        try {
            controller.loadAddressBook(addressBookName);
        } catch (AddressBookException ignored) {     }
        PersonDTO personDetails = controller.getPersonDetails(addressBookName, phoneNo);
        session.setAttribute("personOpened", personDetails);
        ServletContext servletContext = this.getServletContext();
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/jsp/book.jsp");
        dispatcher.forward(req,resp);

    }
}
