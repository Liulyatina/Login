<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Сообщения</title>
</head>
<body>
<form action="${basePath}/api/login" method="POST">
<label for="login">Логин:</label>
<input type="text" id="login" name="login"><br>

<label for="password">Пароль:</label>
<input type="password" id="password" name="password"/><br>


<input type="submit" value="Войти"/>
</form>
</body>
</html>