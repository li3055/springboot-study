package org.jpa.service;

import javax.annotation.Resource;

import org.jpa.bean.Cat;
import org.jpa.dao.CatDao;
import org.springframework.stereotype.Service;

@Service
public class CatService {

	@Resource
	private CatDao catDao;

	public void save(Cat cat) {
		catDao.save(cat);

	}

	public void delete(Integer id) {
		catDao.delete(id);
	}

	public Iterable<Cat> findAll() {
		return catDao.findAll();
	}

}
