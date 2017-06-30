package org.jpa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.jpa.bean.Cat;
import org.jpa.service.CatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

@RestController
public class CatController {
	@Resource
	private CatService catService;

	@RequestMapping("/save")
	public String save() {
		Cat cat = new Cat();
		cat.setAge(18);
		cat.setCatName("莫小贝630");
		cat.setMastName("liquan");
		catService.save(cat);
		return cat.toString();

	}

	@RequestMapping("/findByMaster")
	public Cat findByMaster(String mastName,String age) {
		Cat cat = new Cat();
		if(age.length()>0){
			cat.setAge(Integer.parseInt(age));
		}
		if(mastName.length()>0){
			cat.setMastName(mastName);
		}
		return catService.findByMaster(cat);
	}

	@RequestMapping("/delete")
	public void delete(Integer id) {
		catService.delete(id);
	}

	@RequestMapping("/findAll")
	public List<Cat> findAll(String name) {
		Cat cat = new Cat();
		cat.setCatName(name);
		PageHelper.startPage(1, 4);
		return catService.findAll(cat);
	}

	@RequestMapping("/findAll2")
	public List<Cat> findAll2(String name) {
		Cat cat = new Cat();
		cat.setCatName(name);
		PageHelper.startPage(2, 2);
		return catService.findAll(cat);
	}

	@RequestMapping("/findOne")
	public Cat findOne(Integer id) {
		Cat cat = new Cat();
		cat.setId(id);
		return catService.findOne(cat);
	}
}
