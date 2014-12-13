package com.bin.collection;

/**
 * 内部排序
 */
public class Person implements Comparable{
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

	@Override
	public int compareTo(Object o) {
		if (o instanceof Person){
			Person person = (Person) o; 
			return person.name.compareTo(this.name) ;
		} else {
			throw new ClassCastException("不能转换为Person类型") ;
		}
	}

	

}
