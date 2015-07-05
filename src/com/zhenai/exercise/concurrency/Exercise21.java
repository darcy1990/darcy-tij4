package com.zhenai.exercise.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Matthew Yuan
 *
 */
public class Exercise21 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		Runnable1 runnable1 = new Runnable1();
		exec.execute(runnable1);
		exec.execute(new Runnable2(runnable1));
		TimeUnit.SECONDS.sleep(5); 
		exec.shutdownNow();
	}
	
}

class Runnable1 implements Runnable {

	@Override
	public void run() {
		try {
			synchronized (this) {
				wait();
			}
			System.out.println("hello, world");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class Runnable2 implements Runnable {
	
	Runnable1 runnable1;

	public Runnable2(Runnable1 runnable1) {
		super();
		this.runnable1 = runnable1;
	}

	@Override
	public void run() {
		try {
			TimeUnit.MILLISECONDS.sleep(200);
			synchronized (runnable1) {
				runnable1.notifyAll(); // not notifyAll()£¬you must write explicitly
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
