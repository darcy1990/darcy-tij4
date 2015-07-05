package com.zhenai.exercise.concurrency;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exercise5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<Integer>> result = new ArrayList<Future<Integer>>();
		for(int i = 0; i < 10; i++) {
			result.add(exec.submit(new TaskWithResult2(i)));
		}
		for(Future<Integer> fi : result) {
			if(fi.isDone()) {
				try {
					System.out.println(fi.get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					exec.shutdown();
				}
			}
		}
	}

}

class TaskWithResult2 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		return fib(n);
	}
	
	int n;
	
	public TaskWithResult2 (int n) {
		this.n = n;
	}
	
	private int fib(int n) {
	    if(n < 2) return 1;
	    return fib(n-2) + fib(n-1);
	}
}
