package by.subota.max.controller.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //Provide your code here


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Provide your code here

    }
}