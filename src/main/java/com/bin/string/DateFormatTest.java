package com.bin.string;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 * DateFormat:是一个抽象类;
 * 1).创建它的子类的对象.
 * 2).有的抽象类中提供了静态方法来获取类的示例;
 */
public class DateFormatTest {
	@Test
	public void testDate(){
		Date date = new Date() ;
		System.out.println(date);
	}
	
	@Test
	public void TestDateFormat(){
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, 
				DateFormat.LONG) ;
		
		Date date = new Date() ;
		String dateStr = dateFormat.format(date) ;
		System.out.println(dateStr);
	}
	
	@Test
	public void testSimpleDateFormat() throws ParseException{
		DateFormat dateFormat = 
				new SimpleDateFormat("yyyy-MM-dd hh:mm:ss") ;
		Date date = new Date() ;
		System.out.println(dateFormat.format(date));
		
		String dateStr = "1990-12-12 12:12:12" ;
		Date date2 = dateFormat.parse(dateStr) ;
		System.out.println(date2);
		
	}

}
