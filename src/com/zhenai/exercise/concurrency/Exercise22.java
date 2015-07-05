package com.zhenai.exercise.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exercise22 {
	
	boolean flag = false;
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Exercise22 e = new Exercise22();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(e.new Runnable1());
		exec.execute(e.new Runnable2());
		TimeUnit.SECONDS.sleep(5); 
		exec.shutdownNow();
	}
	
	class Runnable1 implements Runnable {

		@Override
		public void run() {
			try {
				TimeUnit.MILLISECONDS.sleep(200);
				if (!flag) {
					flag = true;
				}
				System.out.println(" flag is true now");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	class Runnable2 implements Runnable {

		@Override
		public void run() {
			while (true) { // busy waiting
				if (flag) {
					flag = false;
					System.out.println(" flag is false now");
				}
			}
		}
		
	}

}
