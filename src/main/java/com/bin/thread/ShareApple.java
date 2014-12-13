package com.bin.thread;

public class ShareApple implements Runnable{
	
	private int appleCount = 5 ;
	
	boolean getApple() throws InterruptedException{
		// 加锁,本对象就是被共享;
		synchronized (this){
			if (appleCount > 0){
				appleCount-- ;
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + 
						"拿走了一个苹果.还剩下" + appleCount + " 个苹果.");
				return true ;
			}
			return false ;
		}
		
	}

	@Override
	public void run() {
		boolean flag;
		try {
			flag = getApple();
			while (flag){
				flag = getApple() ;
			}
			System.out.println(Thread.currentThread().getName() + "说:取完了");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		ShareApple shareApple = new ShareApple() ;// 共享的对象,需要加锁;
		
		Thread th1 = new Thread(shareApple) ;
		th1.setName("小强");
		th1.start();
		Thread th2 = new Thread(shareApple) ;
		th2.setName("小明");
		th2.start();
	}

}
