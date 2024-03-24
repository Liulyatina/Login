<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Сообщения</title>
</head>
<body>
<form action="${basePath}/api/message" method="POST">
    <label for="to">Кому</label>
    <input type="text" id="to" name="to"/>

    <label for="text">Сообщение</label>
    <input type="text" id="text" name="text"/>

    <input type="submit"/>
</form>
</body>
</html>