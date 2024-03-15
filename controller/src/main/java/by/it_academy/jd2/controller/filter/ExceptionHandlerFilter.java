package by.it_academy.jd2.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/*")
public class ExceptionHandlerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        try{
            chain.doFilter(request, response);
        } catch (IllegalArgumentException e){
            PrintWriter writer = response.getWriter();
            writer.write(e.getMessage());

            if(response instanceof HttpServletResponse){
                HttpServletResponse castResponse = (HttpServletResponse) response;

                castResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        } catch (Exception e){
            PrintWriter writer = response.getWriter();
            writer.write("Ошибка на стороне сервера");

            if(response instanceof HttpServletResponse){
                HttpServletResponse castResponse = (HttpServletResponse) response;

                castResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }

    }
}