package org.jpa.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cat  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4333191088623427766L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String catName;

	private String mastName;

	private int age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getMastName() {
		return mastName;
	}

	public void setMastName(String mastName) {
		this.mastName = mastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Cat [id=" + id + ", catName=" + catName + ", mastName=" + mastName + ", age=" + age + "]";
	}

	
}
