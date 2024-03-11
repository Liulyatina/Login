package by.it_academy.registration.controller;

import java.io.IOException;

import by.it_academy.registration.dao.dto.UserDto;
import by.it_academy.registration.service.api.IUserService;
import by.it_academy.registration.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/api/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        // Получаем данные из POST-запроса
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        // Получаем экземпляр UserService из фабрики
        IUserService userService = ServiceFactory.getUserService();

        // Проверяем, существует ли пользователь с таким логином и паролем
        boolean userExists = userService.getUserByLogin(login, password);
        if (!userExists) {
            response.getWriter().write("Неверный логин или пароль");
            return;
        }

        // Если логин и пароль верные, сохраняем информацию о входе в текущей сессии
        HttpSession session = request.getSession();
        session.setAttribute("loggedInUser", login);

        // Возвращаем успешный статус
        response.getWriter().write("Успешный вход в систему");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получаем текущую сессию
        HttpSession session = request.getSession();

        // Получаем информацию о пользователе из сессии
        String loggedInUser = (String) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            // Пользователь не вошел в систему
            response.getWriter().write("Пользователь не вошел в систему");
        } else {
            // Пользователь вошел в систему
            response.getWriter().write("Пользователь " + loggedInUser + " вошел в систему");
        }
    }
}
