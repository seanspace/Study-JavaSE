package com.bin.reflection;

public class Person {
	String name ;
	int age ;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person(){
		
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
	
	private String method2(){
		System.out.println("Person method2");
		return null ;
	}
	
	
}
