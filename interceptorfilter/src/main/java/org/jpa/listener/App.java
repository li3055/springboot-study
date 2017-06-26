package org.jpa.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ServletComponentScan(value="org.listener")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	 
}