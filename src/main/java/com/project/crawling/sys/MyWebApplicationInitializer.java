package com.project.crawling.sys;

import org.springframework.lang.NonNull;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(@NonNull ServletContext servletContext) {

        // Spring Basic ContextLoaderListener 설정
        XmlWebApplicationContext basicContext = new XmlWebApplicationContext();
        basicContext.setConfigLocation("classpath*:spring/context-application.xml");
        basicContext.refresh();
        basicContext.start();

        servletContext.addListener(new ContextLoaderListener(basicContext));

        // Spring CharacterEncodingFilter 설정
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, true, "/*");

        // Spring RequestContextListener 설정
        servletContext.addListener(new RequestContextListener());

    }
}
