package by.it_academy.jd2.controller.http.ui;

import by.it_academy.jd2.service.api.IMessageService;
import by.it_academy.jd2.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ui/signIn")
public class LoginServlet extends HttpServlet {

    private final IMessageService messageService = ServiceFactory.getMessageService();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException,
            IOException {

        String contextPath = req.getContextPath();
        String basePath = "";
        if (!contextPath.isBlank()) {
            basePath += contextPath;
        }

        req.setAttribute("basePath", basePath);

        req.getRequestDispatcher("/template/signIn.jsp").forward(req, resp);
    }
}