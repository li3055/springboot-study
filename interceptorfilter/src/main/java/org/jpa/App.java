package org.jpa;

import org.jpa.servlet.MyServlet1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ServletComponentScan
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	 
}