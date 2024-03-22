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
    <input name="login" type="text"/>
    <input name="password" type="password"/>
    <input type="submit"/>
</form>
</body>
</html>