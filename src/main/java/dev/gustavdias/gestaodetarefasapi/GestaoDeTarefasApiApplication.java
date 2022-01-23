package dev.gustavdias.gestaodetarefasapi;

import com.sun.faces.config.ConfigureListener;
import dev.gustavdias.gestaodetarefasapi.beans.ServeletBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.faces.webapp.FacesServlet;

@SpringBootApplication
public class GestaoDeTarefasApiApplication extends ServeletBean {

	public static void main(String[] args) {
		SpringApplication.run(GestaoDeTarefasApiApplication.class, args);
	}

}
