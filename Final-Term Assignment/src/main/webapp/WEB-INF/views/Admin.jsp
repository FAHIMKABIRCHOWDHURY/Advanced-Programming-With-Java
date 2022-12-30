<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/28/2022
  Time: 11:12 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users , History & History</title>
</head>
<body>

<h1>Create user Form</h1>

<form:form action="submitUser" modelAttribute="user">

<br><br>
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
<h1>Update user Form</h1>

<form:form action="updateUser" modelAttribute="user">
    <label for="id">User Id:</label>
    <form:input path="id" id="id"/>
    <form:errors path="id"/>

    <br><br>
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

<h1>Delete User Form</h1>

<form:form action="deleteUser" modelAttribute="user">
<label for="id">User Id:</label>
    <form:input path="id" id="id"/>
    <form:errors path="id"/>

<br><br>

<input type="submit">

</form:form>
<h1>See all User Form</h1>
<form:form action="seeUsers" modelAttribute="User">
<input type="submit">
</form:form>
<h1>Create History Form</h1>

<form:form action="submitHistory" modelAttribute="History">


    <label for="userId">User Id:</label>
    <form:input path="userId" id="userId"/>
    <form:errors path="userId"/>

    <br><br>

    <label for="Tax">Tax:</label>
    <form:input path="Tax" id="email"/>
    <form:errors path="Tax"/>

    <br><br>

    <label for="Totax">Total Tax Amount:</label>
    <form:input path="Totax" id="Totax"/>
    <form:errors path="Totax"/>

    <br><br>

    <input type="submit">

</form:form>

h1>Update History Form</h1>

<form:form action="updateHistory" modelAttribute="History">

    <label for="Id">Id:</label>
    <form:input path="Id" id="userId"/>
    <form:errors path="Id"/>

    <br><br>
    <label for="userId">User Id:</label>
    <form:input path="userId" id="userId"/>
    <form:errors path="userId"/>

    <br><br>

    <label for="Tax">Tax:</label>
    <form:input path="Tax" id="email"/>
    <form:errors path="Tax"/>

    <br><br>

    <label for="Totax">Total Tax Amount:</label>
    <form:input path="Totax" id="Totax"/>
    <form:errors path="Totax"/>

    <br><br>

    <input type="submit">

</form:form>
<h1>Delete History Form</h1>

<form:form action="deleteHistory" modelAttribute="History">
    <label for="id">History Id:</label>
    <form:input path="id" id="id"/>
    <form:errors path="id"/>

    <br><br>

    <input type="submit">



</form:form>

<h1>See all History Form</h1>
<form:form action="seeHistories" modelAttribute="History">
<input type="submit">
</form:form>

<h1>Create Category Form</h1>

<form:form action="submitCategory" modelAttribute="Category">


    <label for="CategoryName">Category Name:</label>
    <form:input path="CategoryName" id="CategoryName"/>
    <form:errors path="CategoryName"/>

    <br><br>

    <label for="percentage">percentage:</label>
    <form:input path="percentage" id="percentage"/>
    <form:errors path="percentage"/>

    <input type="submit">

</form:form>

h1>Update Category Form</h1>

<form:form action="updateCategory" modelAttribute="Category">

    <label for="Id">Category Id:</label>
    <form:input path="Id" id="Id"/>
    <form:errors path="Id"/>

    <br><br>
    <label for="CategoryName">Category Name:</label>
    <form:input path="CategoryName" id="CategoryName"/>
    <form:errors path="CategoryName"/>

    <br><br>

    <label for="percentage">percentage:</label>
    <form:input path="percentage" id="percentage"/>
    <form:errors path="percentage"/>



    <input type="submit">

</form:form>
<h1>Delete Category Form</h1>

<form:form action="deleteCategory" modelAttribute="Category">
    <label for="id">Category Id:</label>
    <form:input path="id" id="id"/>
    <form:errors path="id"/>

    <br><br>
    <input type="submit">

    <h1>See all Category Form</h1>
    <form:form action="seeCategories" modelAttribute="Category">
        <input type="submit">


</form:form>
    </body>
    </html>