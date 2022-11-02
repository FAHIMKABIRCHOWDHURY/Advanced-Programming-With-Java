
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Math</title>
</head>
<body>

<form method="post" action="/Math">
    <label for="firstvalue">First Value:</label>
    <input type="number" name="fv" id="firstvalue"/>
    <br
    ><br>
    <label for="operator">operator:</label>
    <input type="text" name="operator" id="operator"/><br><br>
    <label for="sv">Second Value:</label>
    <input type="number" name="secondvalue" id="sv"/><br><br>

    <input type="submit" value="Calculate">

    <p>Result : <% out.println(request.getAttribute("result")); %>
</form>

</body>
</html>