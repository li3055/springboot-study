package org.global;

import java.util.Date;

public class UserBean {
	private String name;

	private int age;

	private String sex;

	private Date insertDate;


	public UserBean(String name, int age, String sex, Date insertDate) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.insertDate = insertDate;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}


}
