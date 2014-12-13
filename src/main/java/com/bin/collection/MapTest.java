package com.bin.collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MapTest {
	
	@Test
	public void testMap(){
		// 1.put(key,value) ;
		/*
		 * void clear();清空
		 * cntainsKey():equals比较,是否包含Key
		 * containsValue(Object value):是否包含value ;
		 * Set<Map.Entry<k,v>> entrySet() ;得到键值对对应的Entry的Set,需借助泛型;
		 * put(key,value)
		 * remove(key)
		 * size()
		 * putAll()
		 * removeAll(Map<k,v>) 
		 */
		Map map = new HashMap() ;
		map.put("AA", new Person1("AA",12)) ;
		
		System.out.println(map.size());
		System.out.println(map.values()) ;
		System.out.println(map.keySet());
		
		System.out.println(map.isEmpty());
		
		Comparator comparator = new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				return 0;
			}
		};
	}

}
