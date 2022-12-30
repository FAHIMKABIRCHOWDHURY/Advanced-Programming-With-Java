<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>tax-calculator</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-container w3-center">
<h3>TAX CALCULATOR</h3>

<form method="post" action="TaxCalculate" modelAttribute="">
    <form action="/action_page.php">
        <label for="Type">Gender:</label>
        <br>
        <select name="Type" id="Type">
            <option value="General">General</option>
            <option value="Female">Female</option>
            <option value="Specially-abled">Specially-abled</option>
            <option value="Freedom-Fighter">Freedom-Fighter</option>
        </select>
        <br>
        <label for="Age">Age:</label>
        <br>
        <select name="Age" id="Age">
            <option value="Below-65">Below 65</option>
            <option value="Above-65">Above 65</option>
        </select>
        <br>
        <label for="userId">User Id :</label>
        <input type="number" id="userId" name="userId">
        <br>
        <br>
        <label for="Min">Minimum tax :</label>
        <br>
        <input type="number" id="Min" name="Min">
        <br>
        <label for="NumberOfMonth">Number of months :</label>
        <br>
        <input type="number" id="NumberOfMonth" name="NumberOfMonth">
        <br>
        <br>
        <label for="NumberOfFestivals">Number of festivals :</label>
        <br>
        <input type="number" id="NumberOfFestivals" name="NumberOfFestivals">
        <br>
        <label for="AllowableTotalInvestment">Allowable total investment:</label>
        <br>
        <input type="number" id="AllowableTotalInvestment" name="AllowableTotalInvestment">
        <br>
        <label for="BasicSalary">Basic Salary:</label>
        <br>
        <input type="number" id="BasicSalary" name="BasicSalary">
        <br>
        <label for="Bonus">Bonus:</label>
        <br>
        <input type="number" id="Bonus" name="Bonus">
        <br>
        <label for="LivingAllowence">Living Allowence:</label>
        <br>
        <input type="number" id="LivingAllowence" name="LivingAllowence">
        <br>
        <label for="ConveyanceAllowence">Conveyance Allowence:</label>
        <br>
        <input type="number" id="ConveyanceAllowence" name="ConveyanceAllowence">
        <br>
        <label for="OT">Over time:</label>
        <br>
        <input type="number" id="OT" name="OT">
        <br>
        <br><br>
        <style>
            *{
                margin: 0;
                padding: 0;
            }
            body
            {
                background: gainsboro;
            }
            h2
            {
                text-align: center;
            }
        </style>
        <input type="submit" value="Submit">

    </form>

</div>
</body>
</html>