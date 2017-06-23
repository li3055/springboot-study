package org.fastjson;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello spring boot world";
	}

	@RequestMapping("/userInfo")
	public UserBean userInfo() {
		return new UserBean("李权", 18, null,new Date());
	}
}
