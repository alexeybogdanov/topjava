<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <title>Meals</title>
    <style><%@include file="/WEB-INF/css/main.css"%></style>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<%--<c:set var="mealsTo" scope="application" value="${mealsTo}"/>--%>

<table>
<c:forEach items="${mealsTo}" var="item">
    <tr class="${item.excess ? 'red' : 'green'}">
        <td><c:out value="${item.dateTime}" /></td>
        <td><c:out value="${item.description}" /></td>
        <td><c:out value="${item.calories}" /></td>
        <td><a href="meals?action=edit&mealId=<c:out value="${item.id}"/>">Edit</a></td>
        <td><a href="meals?action=delete&mealId=<c:out value="${item.id}"/>">Delete</a></td>

    </tr>
</c:forEach>
</table>
<p><a href="meals?action=insert">Add meal</a></p>
</body>
</html>
