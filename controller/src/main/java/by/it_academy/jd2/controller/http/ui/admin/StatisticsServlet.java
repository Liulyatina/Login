package by.it_academy.jd2.controller.http.ui.admin;

import by.it_academy.jd2.controller.utils.SessionUtils;
import by.it_academy.jd2.core.dto.StatDTO;
import by.it_academy.jd2.core.dto.UserDTO;
import by.it_academy.jd2.service.api.IStatService;
import by.it_academy.jd2.service.dto.LoginDTO;
import by.it_academy.jd2.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/ui/admin/statistics")
public class StatisticsServlet extends HttpServlet {
    private final IStatService statisticsService = ServiceFactory.getStatService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();

        UserDTO user = SessionUtils.loadUser(session);

        StatDTO statisticsDTO=statisticsService.get();
        req.setAttribute("statistics",statisticsDTO);

        req.getRequestDispatcher("/template/statistics.jsp").forward(req,resp);
    }
}
