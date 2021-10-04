package com.shohrab.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="user_details")
public class User extends BaseModel{
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "age")
	private int age;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User( String userName, String gender, int age) {
		super();
		this.userName = userName;
		this.gender = gender;
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "User [name=" + userName + ", age=" + age + ", gender=" + gender + "]";
	}
	
}
