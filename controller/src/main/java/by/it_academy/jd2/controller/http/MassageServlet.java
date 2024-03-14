package by.it_academy.jd2.controller.http;

import by.it_academy.jd2.core.dto.UserDTO;
import by.it_academy.jd2.service.api.IMessageService;
import by.it_academy.jd2.service.dto.MessageDTO;
import by.it_academy.jd2.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/api/message")
public class MassageServlet extends HttpServlet {
    public static final String RECIPIENT= "recipient";
    public static final String TEXT= "text";

    public final IMessageService messageService = ServiceFactory.getMessageService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");

        PrintWriter writer = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Пользователь не аутентифицирован");
            return;
        }

        UserDTO userDTO = (UserDTO) session.getAttribute("user");

        List<MessageDTO> messages = messageService.getMessageForUser(String.valueOf(userDTO));

        writer.write("Сообщения для пользователя: " + userDTO);
        for (MessageDTO message : messages) {
            writer.write("Дата/время отправки: " + message.getDateTime());
            writer.write("От кого: " + message.getFrom());
            writer.write("Текст: " + message.getText());

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String recipient = request.getParameter(RECIPIENT);
        String text = request.getParameter(TEXT);

        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");

        MessageDTO message = new MessageDTO();
        message.setDateTime(LocalDateTime.now());
        message.setFrom(String.valueOf(userDTO));
        message.setTo(recipient);
        message.setText(text);

        response.setStatus(HttpServletResponse.SC_CREATED);

    }
}
