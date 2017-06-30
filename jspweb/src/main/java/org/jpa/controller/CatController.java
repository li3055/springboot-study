package org.jpa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.jpa.bean.Cat;
import org.jpa.service.CatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {
	@Resource
	private CatService catService;
	
	@RequestMapping("/index")
	public Map<String,Object> index() {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", "李权"+"sdafasfas");
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
	public void delete( ) {
		catService.delete(1);
	}

	@RequestMapping("/query")
	public Iterable<Cat> query() {
		return catService.findAll();
	}
}
