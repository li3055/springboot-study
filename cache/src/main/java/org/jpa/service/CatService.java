package org.jpa.service;

import javax.annotation.Resource;

import org.jpa.bean.Cat;
import org.jpa.dao.CatDao;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service

public class CatService {

	@Resource
	private CatDao catDao;

	public void save(Cat cat) {
		catDao.save(cat);

	}

	@CacheEvict(value = "cat", allEntries = true)
	public void delete(Integer id) {
		System.out.println("DemoInfoServiceImpl.delete().从缓存中删除.");
		// catDao.delete(id);
	}

	@CachePut(value = "cat")
	public Cat update(Cat cat) {
		System.out.println("DemoInfoServiceImpl.delete().从缓存中删除.");
		return catDao.save(cat);
	}

	@Cacheable(value = "cat" )
	public Cat findOne(Integer id) {
		System.err.println("DemoInfoServiceImpl.findById()=========从数据库中进行获取的....id=" + id);
		return catDao.findOne(id);
	}

	public Iterable<Cat> findAll() {
		return catDao.findAll();
	}

}
