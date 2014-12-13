package com.bin.string;

import org.junit.Test;

/**
 * 字符串一经创建,就不可再改变了;
 *
 */
public class StringTest {
	
	/**
	 * 1.String 对象是不可变的;
	 * 2.replace替换串中所有符合条件的字符,并生成新的String对象返回;
	 * 3.
	 */
	@Test
	public void test(){
		
		String str = "www.atguigu.comc" ;// 一直没有发生变化;
		// 所有对应的字符都被替换;
		String result = str.replace('c', 'm') ;
		// 返回新的字符串;String是被final修饰,对象不能再改变;
		
		System.out.println(str);
		System.out.println(result);
		
		
	}
	
	
	@Test
	public void testPassRef(){
		Person person = new Person("ABC",12) ;
		System.out.println(person);
		
		changePerson(person) ;
		System.out.println(person);
		
		String str = "abcd" ;
		changeString(str) ;
		System.out.println(str);
	}
	
	public void changePerson(Person person){
		person.setName("atguigu");
		
	}
	public void changeString(String str){
		str.replace('a', 'b') ;
	}
	
	@Test
	public void testTrim(){
		String str = "   ab   cd   " ;
		System.out.println("--" + str + "----");
		
		String str2 = str.trim() ;
		System.out.println("--" + str + "----");
		System.out.println("--" + str2 + "----");
		
	}
	
	@Test
	public void testSubString(){
		String str = "abc/index.jsp" ;
		
		StringBuilder sb = new StringBuilder() ;
		sb.append("不善于言表") ;
	}
	@Test
	public void testCharAt(){
		String str = "" ;
		str.charAt('/') ;
	}
	
	@Test
	public void testIndexOf(){
		
	}
	
}
	
