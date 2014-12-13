package com.bin.generic;

import org.junit.Test;

public enum Season {
	Spring("春天","11111") ;
	
	final String SEASON_NAME ;
	final String SEASON_DESC ;
	
	private Season(String seasonName,String season_desc){
		this.SEASON_NAME = seasonName ;
		this.SEASON_DESC = season_desc ;
	}
	
	@Test
	public void testEnum(){
//		Enum.valueOf(enumType, ) ;
		Season.values() ;
	}
}
