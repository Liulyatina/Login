package by.it_academy.jd2.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;


import java.io.IOException;


@WebFilter("/*")
public class ExceptionHandlerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

//        try{
//            chain.doFilter(request, response);
//        } catch (IllegalArgumentException e){
//            PrintWriter writer = response.getWriter();
//            writer.write(e.getMessage());
//        }

    }
}
