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
public class MessageServlet extends HttpServlet {

    private final IMessageService messageService = ServiceFactory.getMessageService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");

        PrintWriter writer = response.getWriter();

        HttpSession session = request.getSession();
        UserDTO currentUser = (UserDTO) session.getAttribute("user");

        List<MessageDTO> messages = messageService.getMessageForUser(currentUser.getLogin());

        writer.write("<br>Сообщения для пользователя: " + currentUser.getLogin() + "<br>");
        for (MessageDTO message : messages) {
            writer.write("<br>Дата/время отправки: " + message.getDateTime() + "<br>");
            writer.write("От кого: " + message.getFrom() + "<br>");
            writer.write("Текст: " + message.getText() + "<br>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String recipient = request.getParameter("recipient");
        String text = request.getParameter("text");

        HttpSession session = request.getSession();
        UserDTO currentUser = (UserDTO) session.getAttribute("user");

        MessageDTO message = new MessageDTO();
        message.setDateTime(LocalDateTime.now());
        message.setFrom(currentUser.getLogin());
        message.setTo(recipient);
        message.setText(text);

        messageService.sendMessage(message);

        response.setStatus(HttpServletResponse.SC_CREATED);
    }
}