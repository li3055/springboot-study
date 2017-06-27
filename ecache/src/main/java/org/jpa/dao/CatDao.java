package org.jpa.dao;

import org.jpa.bean.Cat;
import org.springframework.data.repository.CrudRepository;

public interface  CatDao  extends CrudRepository<Cat,Integer>{

	
}
