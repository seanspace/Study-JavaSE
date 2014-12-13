package com.bin.thread;

public class YieldThreadTest extends Thread {
	public YieldThreadTest(String name){
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new YieldThreadTest("线程1") ;
		Thread t2 = new YieldThreadTest("线程2") ;
		
		t2.join();// 会等t2线程完成之后才会继续执行;
		Thread.interrupted() ;// 强行中断进程;
		
	}

	@Override
	public void run() {
		for (int i = 0 ; i < 100 ; i++){
			System.out.println(getName() + ":" + i);
			if (i == 0){
				//yield() ;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	

	
}
