package org.propertiesconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Hello world!
 *
 */
@SpringBootApplication 
@EnableConfigurationProperties({RedisProperties.class})  
public class App 
{
    public static void main( String[] args )
    {
       SpringApplication.run(App.class, args);
    }
}