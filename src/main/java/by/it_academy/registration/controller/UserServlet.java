package by.it_academy.registration.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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
    private final Map<String, User> userMap = new HashMap<>();

    @Override
    public void init() throws ServletException {
        // При инициализации создаем пользователя-администратора
        String adminLogin = "admin";
        String adminPassword = "admin123";
        String adminFullName = "Admin Adminov";
        LocalDate adminBirthDate = LocalDate.of(1990, 1, 1);
        String adminRole = "администратор";

        User adminUser = new User(adminLogin, adminPassword, adminFullName, adminBirthDate, LocalDate.now(), adminRole);

        UserService userService = ServiceFactory.getUserService();

        // Добавляем пользователя-администратора
        userService.addUser(adminUser);
    }

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
            User user = userService.registerUser(login, password, fullName, birthDate);

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
