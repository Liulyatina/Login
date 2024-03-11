package by.it_academy.registration.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import by.it_academy.registration.dao.dto.UserDto;
import by.it_academy.registration.service.UserService;
import by.it_academy.registration.service.api.IUserService;
import by.it_academy.registration.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/api/user")
public class UserServlet extends HttpServlet {

    private final static String LOGIN_PARAM_NAME="login";
    private final static String PASSWORD_PARAM_NAME="password";
    private final static String NAMES_PARAM_NAME="fullName";
    private final static String BIRTH_PARAM_NAME="birthDate";

    private final IUserService userService=ServiceFactory.getUserService();

    // Коллекция для хранения пользователей (вместо базы данных)
    private final Map<String, UserDto> userMap = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        // Получаем данные из POST-запроса
        String login = request.getParameter(LOGIN_PARAM_NAME);
        String password = request.getParameter(PASSWORD_PARAM_NAME);
        String fullName = request.getParameter(NAMES_PARAM_NAME);
        LocalDate birthDate = null;

        try {
            birthDate = LocalDate.parse(request.getParameter(BIRTH_PARAM_NAME));
        } catch (Exception e) {
            response.getWriter().write("Ошибка: Неверный формат даты рождения");
            return;
        }

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
