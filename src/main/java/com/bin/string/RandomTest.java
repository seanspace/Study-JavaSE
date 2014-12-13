package com.bin.string;

import java.util.Random;

import org.junit.Test;

public class RandomTest {
	@Test
	public void testRandom(){
		Random random = new Random() ;
		
		System.out.println(random.nextInt());
		System.out.println(random.nextInt(10));
	}
	
	@Test
	public void testMath(){
		System.out.println(Math.PI);
		
	}

}
