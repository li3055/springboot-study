package org.hotloader;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpotController {

 

	@RequestMapping("/spotUserInfo")
	public UserBean userInfo() {
		return new UserBean("李权1", 18, null,new Date());
	}
	 
}
