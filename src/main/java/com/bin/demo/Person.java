package com.bin.demo;

public class Person implements Comparable{
	
	private String name ;
	private int arg ;
	
	public Person(String name,int arg){
		this.name = name ;
		this.arg = arg ;
	}
	
	/**
	 * wo未来日记的浮生六记
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getArg() {
		return arg;
	}
	public void setArg(int arg) {
		this.arg = arg;
	}

	/**
	 * 为什么在hashCode方法中有质数的存在:
	 * 
	 * Person p1:name 的hashCode 值为1000,age hashCode 值为22
	 * Person p2:name 的hashCode 值为22,age hashCode 值为1000
	 * 如果直接相加的话,两个不同的对象就相同;
	 * 
	 * 如果equals()相等,那么hashCode必须相等;
	 * 
	 * HashSet正是通过equals()方法比较,如果equal()相等,hashCode不相等的话,会存在不同的位置,也就是说会重复存储;
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + arg;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (arg != other.arg)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", arg=" + arg + "]";
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
	
	
	
}
