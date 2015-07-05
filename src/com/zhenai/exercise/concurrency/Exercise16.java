package com.zhenai.exercise.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Same Lock
 * @author zhongming.yuan
 * @date 2014-3-5
 */
public class Exercise16 {
	
	private Object o1 = new Object();
	
	private Lock lock = new ReentrantLock();
	
	public void f() {
		lock.lock();
	 	try {
	 		while(true) {
				System.out.println("f()" + o1);
				Thread.yield();
			}
	 	} finally {
	 		lock.unlock();
	 	}
		
	}
	
	public void g() {
		lock.lock();
	 	try {
	 		while(true) {
				System.out.println("g()" + o1);
				Thread.yield();
			}
	 	} finally {
	 		lock.unlock();
	 	}
	}
	
	public void h() {
		lock.lock();
	 	try {
	 		while(true) {
				System.out.println("h()" + o1);
				Thread.yield();
			}
	 	} finally {
	 		lock.unlock();
	 	}
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final Exercise16 e = new Exercise16();
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
