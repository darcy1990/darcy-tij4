package com.zhenai.exercise.concurrency;

import java.util.concurrent.TimeUnit;

public class Exercise15 {
	
	private Object o1 = new Object();
	
	public void f() {
		synchronized (o1) {
			while(true) {
				System.out.println("f()");
				Thread.yield();
			}
		}
	}
	
	public void g() {
		synchronized (o1) {
			while(true) {
				System.out.println("g()");
				Thread.yield();
			}
		}
	}
	
	public void h() {
		synchronized (o1) {
			while(true) {
				System.out.println("h()");
				Thread.yield();
			}
		}
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final Exercise15 e = new Exercise15();
		new Thread() {
			public void run() {
				e.f();
			}
		}.start();
		new Thread() {
			public void run() {
				e.g();
			}
		}.start();
		new Thread() {
			public void run() {
				e.h();
			}
		}.start();
		
		TimeUnit.SECONDS.sleep(60);
		System.exit(0);
	}

}
