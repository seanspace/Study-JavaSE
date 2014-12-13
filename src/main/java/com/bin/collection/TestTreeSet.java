package com.bin.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

public class TestTreeSet {
	/*
	 * 默认情况下TreeSet要求集合中的元素必须实现Comparable接口.
	 * comparable接口只有一个方法;
	 * 
	 * 
	 */
	@Test
	public void testTreeSet1(){
		TreeSet set = new TreeSet() ;
		
		set.add(new Person("AA",12)) ;
		set.add(new Person("BB",13)) ;
		set.add(new Person("CC",14)) ;
		
		Iterator it = set.iterator() ;
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

	/**
	 * 使用比较器实现;
	 */
	@Test
	public void testTreeSetWithComparator(){
		Comparator comparator = new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Person1 && o2 instanceof Person1){
					Person1 p1 = (Person1) o1 ;
					Person1 p2 = (Person1) o2 ;
					return p1.getAge() - p2.getAge() ;
				}
				throw new ClassCastException("") ;
			}
		} ;
		TreeSet set = new TreeSet(comparator) ;
		set.add(new Person1("AA",12)) ;
		set.add(new Person1("AA",13)) ;
		
		System.out.println(set);
	}
	
	@Test
	public void testTreeSetWith(){
		
	}
	
}
