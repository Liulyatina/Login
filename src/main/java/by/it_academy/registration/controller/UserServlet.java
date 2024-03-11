package by.it_academy.registration.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import by.it_academy.registration.dao.dto.UserDto;
import by.it_academy.registration.service.UserService;
import by.it_academy.registration.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/api/user")
public class UserServlet extends HttpServlet {

    // Коллекция для хранения пользователей (вместо базы данных)
    private final Map<String, UserDto> userMap = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        // Получаем данные из POST-запроса
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        LocalDate birthDate = null;

        try {
            birthDate = LocalDate.parse(request.getParameter("birthDate"));
        } catch (Exception e) {
            response.getWriter().write("Ошибка: Неверный формат даты рождения");
            return;
        }

        // Получаем экземпляр UserService из ServiceFactory
        UserService userService = ServiceFactory.getUserService();

        try {
            // Регистрируем пользователя
            UserDto user = userService.save(login, password, fullName, birthDate);

            // Если регистрация прошла успешно, сохраняем информацию о пользователе в сессии
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", user);

            // Возвращаем успешный статус и информацию о успешной регистрации
            response.getWriter().write("Пользователь успешно зарегистрирован");
        } catch (IllegalArgumentException ex) {
            // В случае ошибки выводим соответствующее сообщение
            response.getWriter().write("Ошибка: " + ex.getMessage());
        }
    }
}
