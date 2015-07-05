package com.zhenai.exercise.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrency.IntGenerator;

public class Exercise11 implements Runnable {
	
	private IntGenerator gen;
	
	public Exercise11(IntGenerator gen) {
		this.gen = gen;
	}
	
	public void run() {
		while (!gen.isCanceled()) {
			int val = gen.next();
			if (val % 3 != 0) {
				gen.cancel();
				System.out.println(val + " is not divisible by 3 !");
			}
		}
	}

	/**
	 * @param args
	 */
	public static void test(IntGenerator gen) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 10;i++) {
			exec.execute(new Exercise11(gen));
		}
		exec.shutdown();
	}

}
