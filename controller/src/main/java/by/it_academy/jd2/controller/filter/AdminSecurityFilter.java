package by.it_academy.jd2.controller.filter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/ui/admin/*", "/api/admin/*"})
public class AdminSecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if ((session != null) && (session.getAttribute("user") != null)) {
//            Boolean isAdmin = (Boolean) session.getAttribute("admin");
//            if (isAdmin != null && isAdmin) {
                filterChain.doFilter(servletRequest, servletResponse);
//            } else {
//                res.sendRedirect(contextPath + "/");
//            }
        } else {
            res.sendRedirect (contextPath + "'/");
        }
    }
}