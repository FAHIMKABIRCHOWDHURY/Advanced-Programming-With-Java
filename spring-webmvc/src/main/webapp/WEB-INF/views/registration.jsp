<%--
  Created by IntelliJ IDEA.
  User: MIRMDKAWSUR
  Date: 10/13/2022
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

    <form method="post" action="register/v2">
       <label for="firstName">First name:</label>
        <input type="text" name="firstName" id="firstName"/>
        <br>
        <label for="lastName">Last name:</label>
        <input type="text" name="lastName" id="lastName"/>
        <br>
        <label for="email">Email:</label>
        <input type="text" name="email" id="email"/>
        <br>
        <label for="pass">Password:</label>
        <input type="password" id="pass" name="pass">
        <br>
        <input type="submit" value="Register">
    </form>

</body>
</html>
