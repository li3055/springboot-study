package org.jpa.service;

import java.util.List;

import javax.annotation.Resource;

import org.jpa.bean.Cat;
import org.jpa.mapper.CatMapper;
import org.springframework.stereotype.Service;

@Service

public class CatService {

	@Resource
	private CatMapper catMapper;

 	public void save(Cat cat) {
		catMapper.save(cat);
	}
 	public Cat findByMaster(Cat catQuery) {
 		return 	catMapper.findByMaster(catQuery);
 	}

	public void delete(Integer id) {
		catMapper.delete(id);
	} 

	public List<Cat> findAll(Cat cat) {
		return catMapper.findAll(cat);
	}

	public Cat findOne(Cat cat) {
		Cat cat1 = catMapper.findOne(cat);
		return  cat1;
	}

}
