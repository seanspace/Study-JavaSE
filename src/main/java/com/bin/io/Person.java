package com.bin.io;

import java.io.Serializable;

public class Person implements Serializable{
	
	/*
	 * 版本ID;当修改后,需要修改版本号;用于读取对象时,对比硬盘上的对象的版本和程序
	 * 版本号;
	 * 要使本类的对象序列化,所有引用类型属性都必须能够序列化;
	 * 基本数据类型都实现了可序列化;
	 */
	private static final long serialVersionUID = 1L;//版本ID;
	private String name ;
	private int age ;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
