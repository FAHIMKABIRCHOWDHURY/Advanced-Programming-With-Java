
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h1>Login Form</h1>

<form:form action="submitUser" modelAttribute="user">
    <label for="name">Name:</label>
    <form:input path="name" id="name"/>
    <form:errors path="name"/>

    <br><br>

    <label for="email">Email:</label>
    <form:input path="email" id="email"/>
    <form:errors path="email"/>

    <br><br>

    <label for="pass">Password:</label>
    <form:input path="pass" id="pass"/>
    <form:errors path="pass"/>

    <br><br>

    <input type="submit">

</form:form>


</body>
</html>