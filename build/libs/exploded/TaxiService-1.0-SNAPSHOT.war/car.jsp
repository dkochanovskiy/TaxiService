<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sa
  Date: 24.02.17
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cars</title>
    <link href="${pageContext.request.contextPath}/resources/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
Cars<br>
<table border="1">
    <tr>
        <td>Марка</td>
        <td>Модель</td>
        <td>Номер</td>
        <td>Цвет</td>
    </tr>
    <c:forEach items="${carsList}" var="cars">
        <tr>
            <td>${cars.brand}</td>
            <td>${cars.model}</td>
            <td>${cars.number}</td>
            <td>${cars.color}</td>
        </tr>
    </c:forEach>
</table>
<form action="/login" method="post">
    <input type="submit" value="Log out"/>
</form>
</body>
</html>
