package by.it_academy.jd2.controller.http.api;

import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.service.dto.RegistrationUserDTO;
import by.it_academy.jd2.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@WebServlet("/api/user")
public class UserServlet extends HttpServlet {

    public static final String LOGIN_PARAMETER_NAME = "login";
    public static final String PASSWORD_PARAMETER_NAME = "password";
    public static final String NAME_PARAMETER_NAME = "name";
    public static final String BIRTHDAY_PARAMETER_NAME = "birthday";
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public final IUserService userService = ServiceFactory.getUserService();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN_PARAMETER_NAME);
        String password = req.getParameter(PASSWORD_PARAMETER_NAME);
        String name = req.getParameter(NAME_PARAMETER_NAME);
        String birthdayRaw = req.getParameter(BIRTHDAY_PARAMETER_NAME);

        LocalDate birthday;

        PrintWriter writer = resp.getWriter();

        try {
            birthday = LocalDate.parse(birthdayRaw, formatter);
        } catch (DateTimeParseException e){
            throw new IllegalArgumentException("Ошибка при чтении даты. Введите дату в формате дд.мм.уууу");
        }

        RegistrationUserDTO user = new RegistrationUserDTO(login, password, name, birthday);

        try {
            this.userService.create(user);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        } catch (IllegalArgumentException e) {
            writer.write("Ошибка валидации: " + e.getMessage());
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}