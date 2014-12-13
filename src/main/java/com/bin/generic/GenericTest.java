package com.bin.generic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GenericTest {
	
	@Test
	public void helloGeneric(){
		List<Person> persons2 = new ArrayList<Person>() ;
		
		persons2.add(new Person("AA",12)) ;
		persons2.add(new Person("bb",34)) ;
		Person person1 = persons2.get(1) ;
		System.out.println(person1);
		
		System.out.println();
		List persons = new ArrayList() ;
		
		persons.add(new Person("AA",12)) ;
		persons.add(new Person("BB",13)) ;
		persons.add("aa") ;
		
		for (int i = 0 ; i < persons.size() ; i++){
			Object obj = persons.get(i) ;
			Person person = (Person) obj ;
			System.out.println(person.getName());
		}
		
		GenericClass a = new GenericClass() ;
		String b = (String) a.get() ;
		
		String a1 = (String) a.getProperty(1) ;
		
	}

}
