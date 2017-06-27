package org.jpa.controller;

import javax.annotation.Resource;

import org.jpa.bean.Cat;
import org.jpa.service.ICatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {
	@Resource
	private ICatService catService;
	
	 @RequestMapping("/test")
	    public String test(){
	      
	       //存入两条数据.
	      /*  Cat demoInfo = new Cat();
	        demoInfo.setCatName("张三");
	        demoInfo.setAge(16);
	        demoInfo.setMastName("lidayuan");
	        Cat demoInfo2 = catService.save(demoInfo);
	      
	        //不走缓存.
	        System.out.println("----------1--"+catService.findOne(demoInfo2.getId()));
	        //走缓存.
	        System.out.println(catService.findOne(demoInfo2.getId())); 
	       
	       
		     demoInfo = new Cat();
	        demoInfo.setCatName("李四");
	        demoInfo.setMastName("123456");
	        Cat demoInfo3 = catService.save(demoInfo);
	       
	        //不走缓存.
	        System.out.println(catService.findOne(demoInfo3.getId()));*/
	        //走缓存.
	        System.out.println(catService.findOne(18));
	       
	        System.out.println("============修改数据=====================");
	        //修改数据.
	        Cat updated = new Cat();
	        updated.setCatName("李四-update1");
	        updated.setMastName("123456");
	        updated.setId(18);
	        try {
	           System.out.println(catService.update(updated.getId()));
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	       
	        //不走缓存.
	        System.out.println(catService.findOne(updated.getId()));
	       
	       return "ok";
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
	public void delete(Integer id) {
		catService.delete(id);
	}

	@RequestMapping("/find")
	public Cat find(Integer id) {
		return catService.findOne(id);
	}

	@RequestMapping("/query")
	public Iterable<Cat> query() {
		return catService.findAll();
	}
}
