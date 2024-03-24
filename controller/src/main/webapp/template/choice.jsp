<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Главная страница</title>
</head>
<body>
<h1 align="center">Меню</h1>
<form action="${pageContext.request.contextPath}/ui/signUp" METHOD="get">
    <button type="submit">Регистрация</button>
</form>
<form action="${pageContext.request.contextPath}/ui/signIn" METHOD="get">
    <button type="submit">Вход</button>
</form>
<form action="${pageContext.request.contextPath}/ui/user/chat" METHOD="get">
    <button type="submit">Ваши сообщения</button>
</form>
<form action="${pageContext.request.contextPath}/ui/admin/statistics" METHOD="get">
    <button type="submit">Статистика</button>
</form>
<form action="${pageContext.request.contextPath}/ui/user/message" METHOD="get">
    <button type="submit">Отправить сообщение</button>
</form>
</body>
</html>