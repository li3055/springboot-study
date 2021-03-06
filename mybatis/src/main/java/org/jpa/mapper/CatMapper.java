package org.jpa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.jpa.bean.Cat;

public interface CatMapper {

	@Insert("insert into cat(age, cat_name,mast_name ) values(#{age},#{catName},#{mastName} )")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") 
	public void save(Cat cat);

	@Select("delete   from cat where id=#{id}")
	public void delete(Integer id) ;

	@Select("select * from cat where cat_name=#{catName}")
	public List<Cat> findAll(Cat cat);

	@Select("select id,cat_name,mast_name from cat where id=#{id}")
	public Cat findOne(Cat cat);
	
	public Cat findByMaster(Cat catQuery);
}
