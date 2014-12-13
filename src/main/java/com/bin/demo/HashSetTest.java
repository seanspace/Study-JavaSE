package com.bin.demo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.junit.Test;

public class HashSetTest {
	@Test
	public void testHashSet(){
		Collection collection = new HashSet() ;
		
		Person p = new Person("AA",12) ;
		collection.add(p) ;
		
		Iterator it = collection.iterator() ;
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
