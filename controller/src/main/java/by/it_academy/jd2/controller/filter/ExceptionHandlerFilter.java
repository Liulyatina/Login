package by.it_academy.jd2.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;


@WebFilter("/*")
public class ExceptionHandlerFilter implements Filter {

    private final static Logger logger = LogManager.getLogger();
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        try{
            chain.doFilter(request, response);
        } catch (IllegalArgumentException e){
            logger.log(Level.WARN, "Пользователь сделал что-то не так", e);
            PrintWriter writer = response.getWriter();
            writer.write(e.getMessage());

            if(response instanceof HttpServletResponse){
                HttpServletResponse castResponse = (HttpServletResponse) response;

                castResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        } catch (Exception e){
            logger.log(Level.ERROR, "В системе ошибка", e);
            PrintWriter writer = response.getWriter();
            writer.write("Ошибка на стороне сервера");

            if(response instanceof HttpServletResponse){
                HttpServletResponse castResponse = (HttpServletResponse) response;

                castResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }

    }
}