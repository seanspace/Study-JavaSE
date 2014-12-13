package com.bin.thread;

public class PriorityThreadTest extends Thread{
	PriorityThreadTest(String name){
		super(name);
	}
	
	public static void main(String[] args) {
		Thread th1 = new PriorityThreadTest("线程1") ;
		Thread th2 = new PriorityThreadTest("线程2") ;
		
		System.out.println(th1) ;
		System.out.println(th2) ;
		
		th1.setPriority(MIN_PRIORITY);
		th2.setPriority(MAX_PRIORITY);
		
		th1.start();
		th2.start();
		
		
		
	}

	@Override
	public void run() {
		super.run();
	}
	
	
	
	

}
