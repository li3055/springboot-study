package org.jpa;

import java.lang.reflect.Method;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.interceptor.KeyGenerator;

/**
 * Hello world!
 *
 */
@SpringBootApplication 
public class App 
{
    public static void main( String[] args )
    {
       SpringApplication.run(App.class, args);
    }
    
}