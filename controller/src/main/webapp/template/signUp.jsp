<%--
  Created by IntelliJ IDEA.
  User: romamihalevic
  Date: 17.03.24
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Форма регистрации</title>
</head>
<body>
<h1>Регистрация</h1>
<form action="${basePath}/api/user" method="post">
    <label for="login">Login:</label><br>
    <input type="text" id="login" name="login"><br>
    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password"><br>
    <label for="name">Full Name:</label><br>
    <input type="text" id="name" name="name"><br>
    <label for="birthday">Birth Date:</label><br>
    <input type="text" id="birthday" name="birthday"><br><br>
    <input type="submit" value="Register">
</form>
</body>
</html>
