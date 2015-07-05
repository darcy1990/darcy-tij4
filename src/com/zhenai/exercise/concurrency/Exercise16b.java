package com.zhenai.exercise.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Different Lock
 * @author zhongming.yuan
 * @date 2014-3-5
 */
public class Exercise16b {
	
	private Object o1 = new Object();
	
	private Object o2 = new Object();
	
	private Object o3 = new Object();
	
	private Lock lock1 = new ReentrantLock();
	
	private Lock lock2 = new ReentrantLock();
	
	private Lock lock3 = new ReentrantLock();
	
	public void f() {
		lock1.lock();
	 	try {
	 		while(true) {
				System.out.println("f()" + o1);
				Thread.yield();
			}
	 	} finally {
	 		lock1.unlock();
	 	}
		
	}
	
	public void g() {
		lock2.lock();
	 	try {
	 		while(true) {
				System.out.println("g()" + o2);
				Thread.yield();
			}
	 	} finally {
	 		lock2.unlock();
	 	}
	}
	
	public void h() {
		lock3.lock();
	 	try {
	 		while(true) {
				System.out.println("h()" + o3);
				Thread.yield();
			}
	 	} finally {
	 		lock3.unlock();
	 	}
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final Exercise16b e = new Exercise16b();
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
