package com.bin.thread;

public class PrintLetters implements Runnable{
	private char c = 'a' ;
	
	public boolean print(){
		synchronized(this){
			if (c <= 'z'){
				System.out.println(Thread.currentThread().getName() + ":" + c);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				c++ ;
				return true ;
			}
		}
		return false;
	}

	@Override
	public void run() {
		boolean flag = print() ;
		while(flag){
			flag = print() ;
		}
	}
	
	public static void main(String[] args) {
		PrintLetters letter = new PrintLetters() ;
		
		Thread th1 = new Thread(letter) ;
		Thread th2 = new Thread(letter) ;
		
		th1.setName("线程1");
		th2.setName("线程2");
		
		th1.start();
		th2.start();
		
	}

}
