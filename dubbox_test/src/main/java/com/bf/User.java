package com.bf;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;


@SuppressWarnings("serial")
public class User implements Serializable{

	private String name;
	private int age;
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
	public static void main(String[] args) {
		User user = new User();
		user.setAge(1);
		user.setName("ada");
		System.out.println(JSON.toJSONString(user));
	}
}
