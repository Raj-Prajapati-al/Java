package com.ServletContextAndWebApplicatioListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener 
{
    @Override
    public void contextInitialized(ServletContextEvent sce) 
    {
        System.out.println("Application started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) 
    {
        System.out.println("Application stopped");
    }
}
