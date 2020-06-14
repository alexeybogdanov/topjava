<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <title>Meals</title>
    <link href="<c:url value="/css/main.css" />" rel="stylesheet">
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>


<form method="POST" action='meals?action=edit' name="frmAddUser">
     <input
        type="hidden" name="mealId"
        value="<c:out value="${editMeal.id}" />" /> <br />

    Description : <input
        type="text" name="description"
        value="<c:out value="${editMeal.description}" />" /> <br />
    Calories : <input
        type="text" name="calories"
        value="<c:out value="${editMeal.calories}" />" /> <br />
    DOB : <input
        type="text" name="dateTime"
        value="${editMeal.dateTime}" /> <br />
<input type="submit" value="Submit" />
</form>

</body>
</html>