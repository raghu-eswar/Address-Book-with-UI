<%@ page import="com.addressBook.jsonData.PersonDTO" %>
<%@ page import="com.addressBook.jsonData.AddressDTO" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <link rel="style<!DOCTYPE html>
    <html lang="en">
    <head> -->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Address Book</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/book.css" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="<%=request.getContextPath()%>/js/script.js" type="text/javascript"></script>
    </head>
    <body>
        <header>
            <div>
                <p class="p-header">WELCOME TO ADDRESS BOOK</p>
            </div>
            <div>
                <button id="log-out-button" onclick="logOut()"><p class="p-header">log out</p></button>
            </div>
        </header>
        <main>
            <div id="book-content">
                <div id="book-name">
                    <span><%= (String) session.getAttribute("addressBookName") %></span>
                    <a href="DeleteBook"><span class="fa fa-trash"></span></a>
                </div>
                <div id="search">
                    <div>
                    <form action="">
                      <input type="text" placeholder="Search.." id="search-field">
                      <button type="submit" id="search-button"><i class="fa fa-search"></i></button>

                      <button type="submit" id="search-button"><i class="fa fa-plus" onclick="event.preventDefault();showAddPersonForm()"></i></button>
                    </form>
                    </div>
                </div>
                <div style=" height: 370px;overflow-y: auto;overflow-x: hidden;">
                    <% List<PersonDTO> personDTOS = (List<PersonDTO>) session.getAttribute("addressBook");
                        if (personDTOS != null && personDTOS.size() != 0)
                        for (PersonDTO person : personDTOS) { %>
                            <form action="ShowPersonInfo">
                                <button class="person" value=<%= person.phoneNumber %> name="phoneNo"><div class="person"><span><%= person.firstName %></span><span><%= person.phoneNumber %></span></div></button>
                            </form>
                      <%}%>
                </div>
            </div>
            <div id="person-info">
            <%
            PersonDTO personOpened = (PersonDTO) session.getAttribute("personOpened");
                if (personOpened != null) { %>
                     <div id="person-options">

                            <a href="" > <div class="fa fa-edit"></div></a>
                            <a href="DeleteRecord" > <div class="fa fa-trash" ></div></a>

                     </div>
                     <div id="person-image"></div>
                    <div id="person-data">
                        <table>
                            <tr><td>FIRST NAME</td><td>:</td><td><%= personOpened.firstName %></td></tr>
                            <tr><td>LAST NAME</td><td>:</td><td><%= personOpened.lastName %></td></tr>
                            <tr><td>PHONE NO.</td><td>:</td><td><%= personOpened.phoneNumber %></td></tr>
                            <tr><td>CITY</td><td>:</td><td><%= personOpened.address.city %></td></tr>
                            <tr><td>STATE</td><td>:</td><td><%= personOpened.address.state %></td></tr>
                            <tr><td>ZIP</td><td>:</td><td><%= personOpened.address.zip %></td></tr>
                        </table>
                    </div>
               <% } %>
            </div>
        </main>

         <div id="add-person">
            <form id="new-person-data" action="AddNewRecord">
                <input type="button" value="&times;" class="close-icon" onclick="hidePopupPage(event)">
                <span>Add new data</span>
                <input type="text" placeholder="Enter first name" name="firstName"  class="input-field" required></br>
                <input type="text" placeholder="Enter lsat name" name="lastName"  class="input-field" required></br>
                <input type="text" placeholder="Enter phonNo" name="phoneNo"  class="input-field" required></br>
                <input type="text" placeholder="Enter city name" name="city"  class="input-field" required></br>
                <input type="text" placeholder="Enter state name" name="state"  class="input-field" required></br>
                <input type="text" placeholder="Enter zip code" name="zip"  class="input-field" required></br>
                <input type="submit" class="submit-button" value="add">
            </form>
         </div>

    <footer>

    </footer>
    </body>
    </html>
</head>
<body>

</body>
</html>