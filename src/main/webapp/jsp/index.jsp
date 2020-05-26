<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Address Book</title>
    <script src="<%=request.getContextPath()%>/js/script.js" type="text/javascript"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/index.css" type="text/css" />
</head>
<body>
<%
    session.removeAttribute("addressBookName");
    session.removeAttribute("addressBook");
    session.removeAttribute("user");
%>
    <header>
        <div>
            <p class="p-header">WELCOME TO ADDRESS BOOK</p>
        </div>
        <div>
            <button id="sign-up-button" onclick="showSignUpForm()"><p class="p-header">sign up</p></button>
        </div>
    </header>
    <main>
        <div id="login-feld">
            <form action="Login" method="post">
                <input type="text" placeholder="user name" name="userName" class="input-field"></br>
                <input type="password" placeholder="password" name="password" class="input-field"></br>
                <input type="submit" value="submit" class="submit-button">
            </form>
        </div>
    </main>
    <div id="sign-up-page">
        <form id="sign-up-field" action="SignUp" method="post">
            <input type="button" value="&times;" class="close-icon" onclick="hideSignUpPage()">
            <span>Sign Up</span>
            <input type="text" placeholder="Enter username" name="userName"  class="input-field" required></br>
            <input type="password" placeholder="Enter Password" name="password"  class="input-field" required> </br>
            <input type="submit" class="submit-button" value="Sign Up">
        </form>
      </div>
</body>
</html>