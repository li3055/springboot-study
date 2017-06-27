package org.jpa.service;

import org.jpa.bean.Cat;
import org.springframework.cache.annotation.Cacheable;

public interface ICatService {
	public Cat save(Cat cat);

	public void delete(Integer id);

	public Cat findOne(Integer id);

	public Iterable<Cat> findAll();

	public Cat update(Integer id);
}
