package dev.gustavdias.gestaodetarefasapi.beans;

import com.sun.faces.config.ConfigureListener;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.faces.webapp.FacesServlet;


public class ServeletBean {

    @Bean
    public ServletRegistrationBean<FacesServlet> facesServletRegistration() {
        var registration = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
        registration.setLoadOnStartup(1);
        registration.addUrlMappings("*.jr");
        return registration;
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> {
            servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
            servletContext.setInitParameter("primefaces.THEME", "flick");
        };
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<>(new ConfigureListener());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
