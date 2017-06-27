package org.jpa.service;

import javax.annotation.Resource;

import org.jpa.bean.Cat;
import org.jpa.dao.CatDao;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service

public class CatService  implements ICatService{

    //这里的单引号不能少，否则会报错，被识别是一个对象;
    public static final String CACHE_KEY = "'cat'";
    public static final String DEMO_CACHE_NAME = "cat";
	@Resource
	private CatDao catDao;

	public Cat save(Cat cat) {
	return 	catDao.save(cat);

	}

	@CacheEvict(value = DEMO_CACHE_NAME, key="'cat_'+#id")
	public void delete(Integer id) {
		System.out.println("DemoInfoServiceImpl.delete().从缓存中删除.");
	// catDao.delete(id);
	}
	
	@CachePut(value=DEMO_CACHE_NAME ,key="'cat_'+#id")
	public Cat update(Integer id){
	    Cat updated = new Cat();
		 updated.setCatName("李四-update1");
	        updated.setMastName("123456");
	        updated.setId(id);
		return catDao.save(updated);
	}

	@Cacheable(value = DEMO_CACHE_NAME , key ="'cat_'+#id")
	public Cat findOne(Integer id) {
		System.err.println("DemoInfoServiceImpl.findById()=========从数据库中进行获取的....id=" + id);
		return catDao.findOne(id);
	}

	public Iterable<Cat> findAll() {
		return catDao.findAll();
	}

}
