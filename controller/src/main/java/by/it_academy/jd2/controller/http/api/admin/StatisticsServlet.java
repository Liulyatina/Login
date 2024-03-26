package by.it_academy.jd2.controller.http.api.admin;

import by.it_academy.jd2.core.dto.StatDTO;
import by.it_academy.jd2.service.api.IStatService;
import by.it_academy.jd2.service.factory.ServiceFactory;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/admin/statistics")
public class StatisticsServlet extends HttpServlet {
    private final IStatService statService = ServiceFactory.getStatService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        StatDTO statDTO = statService.get();

        PrintWriter writer = response.getWriter();

        if (statDTO == null) {
            writer.write("<p>Статистика пуста</p>");
        }

        writer.write("<p>Статистика</p>");
        if (statDTO != null) {
            writer.write("<p>Количество активных пользователей: " + statDTO.getActiveUsers() + "</p>");
            writer.write("<p>Количество пользователй: " + statDTO.getUsers() + "</p>");
            writer.write("<p>Количесвто отправленных сообщений: " + statDTO.getMessages() + "</p>");

        }
    }
}