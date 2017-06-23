package org.global;

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
		int i= 1/0	;
		return new UserBean("李权1"+i, 18, null,new Date());
	}
}
