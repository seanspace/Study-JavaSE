package com.bin.thread;

/**
 * 多个变量共同用一个变量;
 *
 */
public class PrintNumber {
	
	int i = 0 ;
	public static void main(String[] args) {
		PrintNumber printNumber = new PrintNumber() ;
		NumberThread thread1 = new NumberThread("线程-1",printNumber) ;
		NumberThread thread2 = new NumberThread("线程-2",printNumber) ;
		thread1.start() ;
		thread2.start() ;
	}
	

}

class NumberThread extends Thread{
	
	private PrintNumber a ;

	public NumberThread(String threadName,PrintNumber a){
		super(threadName) ;
	}
	@Override
	public void run() {
		for (; a.i < 100 ; a.i++){
			System.out.println(getName() + ":" + a.i);
		}
	}
	
}
