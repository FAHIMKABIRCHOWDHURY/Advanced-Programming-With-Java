
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>

<h1>Confirmation</h1>

<c:out value="${user.name}" />
<br><br>
<c:out value="${user.email}" />
<br><br>
<c:out value="${user.pass}" />
<hr>

<p>Welcome, ${user.name} ${user.email} ${user.pass}</p>

</body>
</html>
