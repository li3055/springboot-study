package org.global;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseBody
	@ExceptionHandler(value=Exception.class)
	public String globalException(){
		System.out.println("-------------liquan -----------------exception");
		return "liquna  good 404";
	}
}
