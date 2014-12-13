package com.bin.objectriended;

public class Student {
	private int age ;
	private String name ;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Student(String n,int a){
		age = 18 ;
		name = n ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
