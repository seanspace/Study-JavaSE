package com.bin.demo;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * 1.HashSet是set的最典型实现;
 * 2.HashSet不能有相同的与元素;equals()方法;
 * 3.根据hashCode()来存放元素;不能保证顺序;
 *
 */
public class SetTest {
	
	@Test
	public void testTreeSet1(){
		String a = "" ;
		String b = "" ;
		char a1 = 'a' ;
	}
	
	@Test
	public void testTreeSetWithComparator()	{
		Comparator comparator = new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Person && o2 instanceof Person){
					Person p1 = (Person) o1 ;
					Person p2 = (Person) o2 ;
				}
				return 0;
			}
			
		} ;
		
		TreeSet set = new TreeSet(comparator) ;
	}
	
	@Test
	public void test3(){
		HashSet set = new HashSet() ;
		Person p1 = new Person("aa", 12);
		Person p2 = new Person("bb", 12);
		Person p3 = new Person("cc", 12);
		
		set.add(p1) ;
		set.add(p2) ;
		System.out.println(set);
		
		TreeSet set1 = new TreeSet();
	}
	
	LinkedHashSet set = new LinkedHashSet() ;
	
	@Test
	public void testTreeSet(){
		TreeSet set1 = new TreeSet();
		set1.add(new Person("AA",12)) ;
		set1.add(new Person("BB",13)) ;
		set1.add(new Person("CC",13)) ;
		set1.add(new Person("DD",13)) ;
		set1.add(new Person("EE",13)) ;
		
		printSet(set1);
	}

	private void printSet(TreeSet set1) {
		Iterator it = set1.iterator() ;
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	@Test
	public void testAdd(){
		Person p1 = new Person("AA",12) ;
		Person p2 = new Person("AA",12) ;
		
		System.out.println(p2);
		System.out.println(p1);
		
		Set set = new HashSet() ;
		
	}
	
}










