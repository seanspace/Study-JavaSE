package com.bin.generic;

/**
 * 类级别的泛型;
 */
public class GenericClass<T> {
	public T get(){
		return null;
	}
	
	
	/**
	 * 方法级别的泛型;
	 */
	public <E> E getProperty(int id){
		E result = null ;
		
		return result ;
	}
}
