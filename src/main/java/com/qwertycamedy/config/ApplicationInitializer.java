package com.qwertycamedy.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer {
    private static final String DISPATCHER = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        context.register(WebConfig.class);

        ServletRegistration.Dynamic servlet = servletContext.addServlet(
                DISPATCHER,
                new DispatcherServlet(context));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}
