package com.bin.lesson7;


public class TestInnerClass {
	public static void main(String[] args) {
		OuterClass oc = new OuterClass() ;
		OuterClass.InnerClass ic = oc.new InnerClass() ;
		ic.test();
		
		OuterClass.StaticInnerClass sic = new OuterClass.StaticInnerClass() ;
		
		/* final方法不能重写;
		HashMap map = new HashMap<>() ;
		Entry entry = map.new Entry() {

			@Override
			public Object getKey() {
				return null;
			}

			@Override
			public Object getValue() {
				return null;
			}

			@Override
			public Object setValue(Object value) {
				return null;
			}


		} ;
		*/
	} 
}
