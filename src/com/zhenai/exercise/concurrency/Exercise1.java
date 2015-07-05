package com.zhenai.exercise.concurrency;

public class Exercise1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			new Thread(new Runner()).start();
		}
	}

}

class Runner implements Runnable {

	public Runner() {
		System.out.println("constructing......");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("runing......");
		Thread.yield();
		System.out.println("runing......");
		Thread.yield();
		System.out.println("runing......");
		Thread.yield();
		System.out.println("ending......");
	}

}
