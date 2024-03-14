package by.it_academy.jd2.controller.http;

import by.it_academy.jd2.core.dto.UserDTO;
import by.it_academy.jd2.service.api.IAuthService;
import by.it_academy.jd2.service.dto.LoginDTO;
import by.it_academy.jd2.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/login")
public class LoginServlet extends HttpServlet {

    public static final String LOGIN_PARAMETER_NAME = "login";
    public static final String PASSWORD_PARAMETER_NAME = "password";

    public final IAuthService authService = ServiceFactory.getAuthService();


    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter(LOGIN_PARAMETER_NAME);
        String password = req.getParameter(PASSWORD_PARAMETER_NAME);

        LoginDTO dto = new LoginDTO(login, password);

        PrintWriter writer = resp.getWriter();

        try{
            UserDTO userDTO = this.authService.login(dto);

            HttpSession session = req.getSession();

            session.setAttribute("user", userDTO);
        } catch (IllegalArgumentException e){
            writer.write(e.getMessage());
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
    }
}
