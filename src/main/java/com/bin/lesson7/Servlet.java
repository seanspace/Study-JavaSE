package com.bin.lesson7;

public class Servlet {
	
	/**
	 * static 是一个关键字;由于修饰的成员(属性,方法,内部内) ;
	 * 访问权限允许的情况下,static修饰的成员可以同过类名,方法来访问;
	 * static 修饰的成员称为类成员;被所有对象共享;
	 * 在static方法内部只能访问类的static属性,不能访问类的非static成员;
	 * static方法中不能有this,super关键字;
	 * 静态初始化:类加载(载入内存)时执行,而且只执行一次;执行为先执行;
	 * 
	 * 非静态代码块和成员初始化语句谁在前谁先执行,他们都先于构造方法执行;
	 */
	
	static void test(){
		
	}
	
	static void method(){
		
	}
	
	public static void main(String[] args){
		Servlet.test();
	}
	
	
}
