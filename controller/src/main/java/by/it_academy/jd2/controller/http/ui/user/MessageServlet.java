package by.it_academy.jd2.controller.http.ui.user;


import by.it_academy.jd2.controller.utils.SessionUtils;
import by.it_academy.jd2.core.dto.MessageDTO;
import by.it_academy.jd2.service.api.IMessageService;
import by.it_academy.jd2.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/ui/user/message")
public class MessageServlet extends HttpServlet {

    private final IMessageService messageService = ServiceFactory.getMessageService();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException,
            IOException {

        List<MessageDTO> messages = this.messageService.list(SessionUtils.loadUser(req.getSession()));


        String contextPath = req.getContextPath();
        String basePath = "";
        if(!contextPath.isBlank()){
            basePath += contextPath;
        }

        req.setAttribute("basePath", basePath);

        req.setAttribute("mess", messages);

        req.getRequestDispatcher("/template/message.jsp").forward(req, resp);
    }
}