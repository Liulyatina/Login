package by.it_academy.jd2.controller.http.api;

import by.it_academy.jd2.controller.utils.SessionUtils;
import by.it_academy.jd2.core.dto.MessageDTO;
import by.it_academy.jd2.service.api.IMessageService;
import by.it_academy.jd2.service.dto.SendMessageDTO;
import by.it_academy.jd2.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/api/message")
public class MessageServlet extends HttpServlet {

    public static final String TO_PARAMETER_NAME = "to";
    public static final String TEXT_PARAMETER_NAME = "text";

    private final IMessageService messageService = ServiceFactory.getMessageService();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        List<MessageDTO> messages = this.messageService.list(SessionUtils.loadUser(req.getSession()));

        PrintWriter writer = resp.getWriter();

        if(messages != null){
            for (MessageDTO message : messages) {
                writer.write("<p>Дата отправки: " + message.getDateTime() + "</p>");
                writer.write("<p>От кого: " + message.getFrom() + "</p>");
                writer.write("<p>Текст: " + message.getText() + "</p>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        SendMessageDTO dto = SendMessageDTO.builder()
                .to(req.getParameter(TO_PARAMETER_NAME))
                .text(req.getParameter(TEXT_PARAMETER_NAME))
                .build();

        this.messageService.create(SessionUtils.loadUser(req.getSession()), dto);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }
}
