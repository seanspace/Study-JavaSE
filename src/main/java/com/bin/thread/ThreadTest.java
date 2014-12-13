package com.bin.thread;

import org.junit.Test;

/**
 * 关于线程:
 * 1.在java中,Thread类代表一个线程.
 * 2.Runnable接口,thread类;
 *
 */
public class ThreadTest {
	@Test
	public void testThread(){
		// 创建线程对象
		Thread thread = new FirstThread() ;
		
		// 调用线程对象的start()方法启动线程;
		thread.start();
		
		String threadName = Thread.currentThread().getName() ;
		for (int i = 0 ; i < 100 ; i++){
			System.out.println(threadName + ":" + i);
		}
		
		
	}

}

class FirstThread extends Thread{
	/**
	 * 线程体在run()方法中
	 */
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName() ;
		for (int i = 0 ; i < 100 ; i++){
			System.out.println(threadName + ":" + i);
		}
	}
	
	
}
