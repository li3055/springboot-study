package org.jpa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jpa.bean.Cat;
import org.jpa.service.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CatController {
	@Resource
	private CatService catService;

	@RequestMapping("/index")
	public Map<String, Object> index() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "李权" + "sdafasfas");
		return map;

	}

	@RequestMapping("/save")
	public void save() {
		Cat cat = new Cat();
		cat.setAge(18);
		cat.setCatName("莫小贝");
		cat.setMastName("liquan");
		catService.save(cat);

	}

	@RequestMapping("/delete")
	public void delete() {
		catService.delete(1);
	}

	@RequestMapping("/query")
	public Iterable<Cat> query() {
		return catService.findAll();
	}
	@RequestMapping("/success")
	public String success() {
		return "/success";
	}

	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, String username,String password) throws Exception {
		System.out.println("HomeController.login()");
		String msg = "";
		try{
		 SecurityUtils.getSubject().login(new UsernamePasswordToken(username, password));  
		}catch (AuthenticationException e) {  
			msg ="message用户名或密码错误";  
			return "/login";
        }  
		// 登录失败从request中获取shiro处理的异常信息。
		// shiroLoginFailure:就是shiro异常类的全类名.
		String exception = (String) request.getAttribute("shiroLoginFailure");
/*
		System.out.println("exception=" + exception); 
		
		if (exception != null) {
			if (UnknownAccountException.class.getName().equals(exception)) {
				System.out.println("UnknownAccountException -- > 账号不存在：");
				msg = "UnknownAccountException -- > 账号不存在：";
			} else if (IncorrectCredentialsException.class.getName().equals(exception)) {
				System.out.println("IncorrectCredentialsException -- > 密码不正确：");
				msg = "IncorrectCredentialsException -- > 密码不正确：";
			} else if ("kaptchaValidateFailed".equals(exception)) {
				System.out.println("kaptchaValidateFailed -- > 验证码错误");
				msg = "kaptchaValidateFailed -- > 验证码错误";
			} else {
				msg = "else >> " + exception;
				System.out.println("else -- >" + exception);
			}
		}*/
		 
		// 此方法不处理登录成功,由shiro进行处理.
		return "/index";
	}

	@RequestMapping("/userAdd")
	@RequiresPermissions("userInfo:add") // 权限管理;
	public String userInfoAdd() {
		return "userInfoAdd";
	}
}
