package com.bin.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;

import org.junit.Test;

public class CollectionsTest {
	
	@Test
	public void testCollections(){
		/*
		 * 如何得到线程安全的对象呢
		 * 得到线程安全的对象;
		 */
		
		List list = new ArrayList() ;
		List list2 = Collections.synchronizedList(list) ;
		
		/*
		 * 排序
		 */
		List list3 = new ArrayList() ;
		list3.add(new Person1("AA",12)) ;
		list3.add(new Person1("ZZ",11)) ;
		
		for (Object obj:list3){
			System.out.println(obj);
		}
		/*Collections.sort(list,new Comparator(){

			public int compare(Object o1, Object o2) {
				if (o1 instanceof Person1 &&
						o2 instanceof Person1){
					return 11 ;
				}
				return 0;
			}
			
		});*/
		
		/*
		 * 获取最小的,集合元素需要是想comparable接口;或传一个comparator的对象;
		 */
		Object obj = Collections.min(list3) ;
		
	}
	
	@Test
	public void testEnumeration(){
		Enumeration enumeration = new StringTokenizer("a,b,c,d,e") ;
		
		while(enumeration.hasMoreElements()){
			Object obj = enumeration.nextElement() ;
		}
	}

}
