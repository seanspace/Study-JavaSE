package com.bin.lesson7;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class OuterClass {
	
	private String outerName ;
	private int i = 1 ;
	/*
	 * 在类的内部定义的类:内部类
	 * 内部类只用在此外部类;
	 * 内部类可以访问外不类的属性;
	 * 对于非静态内部类,必须有外部类的实例才能创建内部类对象;
	 * 静态内部类,可以直接创建内部类;
	 * 
	 * 如果使用外部类名.内部类名,则不需要import内部类;
	 */
	class InnerClass{
		private int i = 2 ;
		private String innerName ;
		
		public void test(){
			int i = 3 ;
			/*
			 * 访问相同名的变量方法;
			 */
			System.out.println(i);
			System.out.println(this.i);
			System.out.println(OuterClass.this.i);
			
			// 内部类可以访问外部类;
			System.out.println("outerName:" + outerName);
			System.out.println("innerName:" + innerName);
		}
	}
	
	void testInerClass(){
		/*
		 * 匿名内部类
		 */
		Map map = new Map(){

			@Override
			public int size() {
				return 0;
			}

			@Override
			public boolean isEmpty() {
				return false;
			}

			@Override
			public boolean containsKey(Object key) {
				return false;
			}

			@Override
			public boolean containsValue(Object value) {
				return false;
			}

			@Override
			public Object get(Object key) {
				return null;
			}

			@Override
			public Object put(Object key, Object value) {
				return null;
			}

			@Override
			public Object remove(Object key) {
				return null;
			}

			@Override
			public void putAll(Map m) {
				
			}

			@Override
			public void clear() {
				
			}

			@Override
			public Set keySet() {
				return null;
			}

			@Override
			public Collection values() {
				return null;
			}

			@Override
			public Set entrySet() {
				return null;
			}
			
		} ;
	}


	/**
	 * 静态内部类
	 * 不能访问外部类的非静态成员;
	 */
	static class StaticInnerClass{
		private String staticInnerName = "dfa" ;
		public void test(){
			
		}
	}
}
