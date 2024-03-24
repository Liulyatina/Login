<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: romamihalevic
  Date: 24.03.24
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Статистика</title>
</head>
<body>
<h1 align="center">Статистика</h1>

<c:choose>
    <c:when test="${empty statistics}">
        <h2>Статистка пуста</h2>
    </c:when>
    <c:otherwise>
        <table border="2" align="centre">
            <tr>
                <td>Количество активных пользователей</td>
                <td>${statistics.activeUsers}</td>
            </tr>
            <tr>
                <td>Количество пользователей</td>
                <td>${statistics.users}</td>
            </tr>
            <tr>
                <td>Количество собщений</td>
                <td>${statistics.messages}</td>
            </tr>
        </table>
    </c:otherwise>
</c:choose>
</body>
</html>
