<%@ page import="com.addressBook.servlets.User" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Address Book</title>
    <script src="<%=request.getContextPath()%>/js/script.js" type="text/javascript"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/home.css" type="text/css"/>
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

        <% User user = (User) session.getAttribute("user");
           for (String bookName : user.addressBookNames) { %>
            <div class="address-book">
               <form action="OpenAddressBook">
                   <button type="submit" value=<%= bookName %> name="bookName" class="book"> </button>
               </form>
               <div class="image-tag-name"><%= bookName.toUpperCase() %></div>
           </div>
         <% } %>

        <div class="address-book">
            <div class="add-book-options" onclick="showCreateBookForm()"></div>
            <div class="image-tag-name">Create New Book</div>
        </div>
    </main>
    <footer>

    </footer>
    <div id="create-book">
        <form id="new-book-data" action="CreateNewBook">
            <input type="button" value="&times;" class="close-icon" onclick="hidePopupPage(event)">
            <span>create book</span>
            <input type="text" placeholder="Enter book name" name="newBookName"  class="input-field" required></br>
            <input type="submit" class="submit-button" value="create">
        </form>
     </div>

</body>
</html>
