package by.it_academy.jd2.controller.listener;

import by.it_academy.jd2.controller.utils.SessionUtils;
import by.it_academy.jd2.core.dto.StatDTO;
import by.it_academy.jd2.service.api.IStatService;
import by.it_academy.jd2.service.factory.ServiceFactory;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class UserSessionListener implements HttpSessionListener {

    private final IStatService statService = ServiceFactory.getStatService();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session=se.getSession();
        if (SessionUtils.loadUser(session)!=null){
            statService.incrementActiveUser();
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session=se.getSession();
        if (SessionUtils.loadUser(session)!=null) {
            statService.decrementActiveUser();
        }
    }
}
