package by.it_academy.jd2.controller.listener;

import by.it_academy.jd2.service.api.IStatService;
import by.it_academy.jd2.service.factory.ServiceFactory;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener
public class UserSessionAttributeListener implements HttpSessionAttributeListener {

    private final IStatService statisticsService = ServiceFactory.getStatService();


    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if (event.getName().equals("user")) {
            statisticsService.incrementActiveUser();
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if (event.getName().equals("user")) {
            statisticsService.decrementActiveUser();
        }
    }
}
