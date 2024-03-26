package by.it_academy.jd2.controller.listener;

import by.it_academy.jd2.service.api.IStatService;
import by.it_academy.jd2.service.factory.ServiceFactory;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class UserSessionListener implements HttpSessionListener {

    private final IStatService statisticsService=ServiceFactory.getStatService();

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        if(se.getSession().isNew()){
            statisticsService.incrementActiveUser();
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        statisticsService.decrementActiveUser();
    }
}