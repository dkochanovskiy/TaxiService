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
    <title>Users</title>
</head>
<body>
${name}<br>
<form action="LoginServlet" method="post">
    Login:<input type="text" name="login"/>
    Password:<input type="password" name="password">
    <input type="submit" value="log in">
</form>
</body>
</html>