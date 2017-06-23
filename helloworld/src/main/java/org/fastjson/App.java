package org.fastjson;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * Hello world!
 *
 */
@SpringBootApplication 
public class App extends WebMvcConfigurerAdapter
{
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		FastJsonHttpMessageConverter convert = new FastJsonHttpMessageConverter();
		FastJsonConfig jsonConfig = new FastJsonConfig();
		jsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		convert.setFastJsonConfig(jsonConfig);
		converters.add(convert);
	}
	
	/** 方式二： 或者这么干
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverter(){
		FastJsonHttpMessageConverter convert = new FastJsonHttpMessageConverter();
		FastJsonConfig jsonConfig = new FastJsonConfig();
		jsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		convert.setFastJsonConfig(jsonConfig);
		HttpMessageConverter<?> c = convert;
		return new HttpMessageConverters(c);
	}
	 **/
	
    public static void main( String[] args )
    {
       SpringApplication.run(App.class, args);
    }
    
    
}
