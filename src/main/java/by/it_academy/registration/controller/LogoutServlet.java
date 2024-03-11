package by.it_academy.registration.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/api/logout")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получаем текущую сессию
        HttpSession session = request.getSession(false);

        // Если сессия существует, удаляем атрибут "loggedInUser"
        if (session != null) {
            session.removeAttribute("loggedInUser");
        }

        // Возвращаем успешный статус
        response.getWriter().write("Успешный выход из системы");
    }
}