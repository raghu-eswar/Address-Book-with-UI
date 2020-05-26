<%@ page import="com.addressBook.servlets.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.addressBook.jsonData.PersonDTO" %>
<%@ page import="com.addressBook.jsonData.AddressDTO" %>
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
        <div></div>
    </header>
    <main>

        <form id="create-book" action="CreateNewBook">
            <input type="text" placeholder="enter book name" name="newBookName" required>
            <input type="submit" id="create-book-button" value="create new book" >
        </form>

        <form id="books" action="ShowAddressBook">
        <% User user = (User) session.getAttribute("user");
           for (String bookName : user.addressBookNames) { %>
               <input type="submit" name="bookName" value=<%=bookName%>>
         <% } %>

        </form>
        <div style="float: left;height: 500px; overflow-y: auto;overflow-x: hidden;">
        <%if (session.getAttribute("addressBookName") != null ) {%>
           <div><form id="opend-book">
             <div>
             <div><img src="<%=request.getContextPath()%>/css/images/person-icon-person-icon-clipart-image-from-our-icon-clipart-category--9.png" alt="no image"></div>
                 <div>
                     <div><div>First name</div><div>:</div><div><input type="text" class="writable" name="firstName"  placeholder="First Name"></div></div>
                     <div><div>Last name</div><div>:</div><div><input type="text" class="writable" name="lastName" placeholder="Lst Name"></div></div>
                     <div><div>Phone no.</div><div>:</div><div><input type="text" class="writable" name="phoneNo" placeholder="Phone number"></div></div>
                 </div>
                 <div>
                     <div><div>city</div><div>:</div><div><input type="text" class="writable" name="city" placeholder="City"></div></div>
                     <div><div>state</div><div>:</div><div><input type="text" class="writable" name="state" placeholder="State"></div></div>
                     <div><div>zip</div><div>:</div><div><input type="text" class="writable" name="zip"  placeholder="Zip"></div></div>
                 </div>
                 <div>
                     <button id="edit-button" onclick="form.action='AddNewRecord'">Add</button>
                 </div>
             </div>
           </form></div>
       <%}%>
        <%  List<PersonDTO> addressBook = (List<PersonDTO>) session.getAttribute("addressBook");
          if (addressBook != null && addressBook.size() != 0) {
            for (PersonDTO person : addressBook) { %>
                <div><form id="opend-book">
                    <div>
                       <div><img src="<%=request.getContextPath()%>/css/images/person-icon-person-icon-clipart-image-from-our-icon-clipart-category--9.png" alt="no image"></div>
                        <div>
                            <div><div>First name</div><div>:</div><div><input class="readonly" type="text" name="firstName" value=<%=person.firstName%>></div></div>
                            <div><div>Last name</div><div>:</div><div><input class="readonly" type="text" name="lastName" value=<%=person.lastName%>></div></div>
                            <div><div>Phone no.</div><div>:</div><div><input class="readonly" type="text" name="phoneNo" value=<%=person.phoneNumber%>></div></div>
                        </div>
                        <div>
                            <div><div>city</div><div>:</div><div><input class="readonly" type="text" name="city" value=<%=person.address.city%>></div></div>
                            <div><div>state</div><div>:</div><div><input class="readonly" type="text" name="state" value=<%=person.address.state%>></div></div>
                            <div><div>zip</div><div>:</div><div><input class="readonly" type="text" name="zip" value=<%=person.address.zip%>></div></div>
                        </div>
                        <div>
                            <button id="edit-button" onclick="enableToEdit(event); event.preventDefault(); ">edit</button>
                            <button id="save-button" class="disabled-button" onclick="form.action='EditPersonInfo'">save</button>
                            <button id="delete-button" onclick="form.action='DeleteRecord'">delete</button>
                        </div>
                    </div>
                </form></div>
          <%}
          }%>
       </div>
    </main>
    <footer>

    </footer>
</body>
</html>
