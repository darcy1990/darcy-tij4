package com.zhenai.exercise.concurrency;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Exercise10 {
	
	static ExecutorService exec = Executors.newCachedThreadPool();
	
	public static Future<Integer> runTask(int n) {		
		Future<Integer> f = exec.submit(new TaskWithResult2(n));
		return f;
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Future<Integer>> result = new ArrayList<Future<Integer>>();
		for(int i = 0; i < 5; i++) {
			result.add(runTask(i));
		}
		TimeUnit.MILLISECONDS.sleep(20); // call of method runTask cost time, if not sleep, method main shall run over before tasks.
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
		System.out.println("loop over !");
	}

}
