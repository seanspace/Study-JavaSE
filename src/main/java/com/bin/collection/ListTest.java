package com.bin.collection;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListTest {
	@Test
	public void testArrayList(){
		List list = new ArrayList() ;
		
		list.add(new Person("aa",12)) ;
		list.add(new Person("bb",11)) ;
		
		list.iterator() ;
	}

}
