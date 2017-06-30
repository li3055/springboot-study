package org.jpa;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

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
    
    @Bean 
    public MultipartConfigElement multipartConfigElement() { 

         MultipartConfigFactory factory = new MultipartConfigFactory();

         //// 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;

         factory.setMaxFileSize("128KB"); //KB,MB

         /// 设置总上传数据总大小

         factory.setMaxRequestSize("256KB"); 

         //Sets the directory location wherefiles will be stored.

         factory.setLocation("d:\\doc");

         return factory.createMultipartConfig(); 

     } 
}