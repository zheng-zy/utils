package com.zzy.model;
/**
 * Json.java 说明:json测试model类
 * @author zhengzy
 * @date   2015年9月25日
 */
public class Person {
	private int id;
	private String name;
	private Phone phone;
	
	public Person() {
	}
	public Person(int id, String name, Phone phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	
}
