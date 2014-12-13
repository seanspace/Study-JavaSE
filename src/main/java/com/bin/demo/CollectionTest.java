package com.bin.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;
/**
 * 1.添加元素的;
 * 2.获取元素的;查找指定的元素;
 * 3.移除元素;
 * 4.工具方法;
 * 
 * @author Y510P
 *
 */
public class CollectionTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testToolMethod() {
		Collection collection = new ArrayList() ;
		collection.add("abc") ;
		collection.add("def") ;
		collection.add(new Person("Tom",12)) ;
		collection.add(new Person("Mike",32)) ;
		collection.add(new Person("Jerry",13)) ;
		
		// 是否包含元素;
		System.out.println(collection.contains("abc"));
		
		// collection
		collection.toArray() ;
		
		String[] a = new String[5] ;
		collection.toArray(a) ;
		
	}
	
	/**
	 * 1.clear();清空集合
	 * 2.remove(obj);通过equals()方法移除 ;
	 * 3.removeAll(collection coll) ;移除有的;
	 * 4.retainAll(Collection coll) ;保留有的;
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testRemove(){
		Collection collection = new ArrayList() ;
		collection.add("abc") ;
		collection.add("def") ;
		collection.add(new Person("Tom",12)) ;
		collection.add(new Person("Mike",32)) ;
		collection.add(new Person("Jerry",13)) ;
		
//		collection.clear();
//		System.out.println(collection.size()) ;
		
//		collection.remove("") ;
		
		Collection collection2 = new ArrayList() ;
		collection2.add("abc") ;
		collection2.add("abc") ;
		collection2.add(new Person("Tom",12)) ;
		
		collection.removeAll(collection2) ;
		
		System.out.println(collection.size());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testIterator() {
		Collection collection = new ArrayList() ;
		collection.add("abc") ;
		collection.add(new Person("Tom",12)) ;
		collection.add(new Person("Mike",32)) ;
		collection.add(new Person("Jerry",13)) ;
		
		for (Object obj:collection){
			System.out.println(obj);
		}
		
		Iterator it = collection.iterator() ;
		while(it.hasNext()){
			Object obj = it.next() ;
			System.out.println(obj);
		}
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testAddAll(){
		Collection collection2 = new ArrayList() ;
		collection2.add("32") ;
		
		Collection collection = new ArrayList() ;
		
		collection.add("abc") ;
		collection.add(new Person("Tom",12)) ;
		collection.add(new Person("Mike",32)) ;
		collection.add(new Person("Jerry",13)) ;
		
		System.out.println(collection.size());
		
		collection2.addAll(collection) ;
		System.out.println(collection2.size());
		
	}
	
	/**
	 * 添加一个元素到
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testAdd() {
		Collection collection = new ArrayList() ;
		System.out.println(collection.size());
		
		collection.add("abc") ;
		collection.add(new Person("Tom",12)) ;
		collection.add(new Person("Mike",32)) ;
		collection.add(new Person("Jerry",13)) ;
		
		System.out.println(collection.size());
		
		
	}

}
