package com.zhenai.exercise.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Interrupt a thread
 * @author zhongming.yuan
 * @date 2014-3-29
 */
public class Exercise18 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Exercise18 e = new Exercise18();
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<?> f = es.submit(e.new Task());
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Interrupt task ....");
		f.cancel(true);
	}
	
	class Task implements Runnable {

		@Override
		public void run() {
			NonTask n = new NonTask();
			n.run();
		}
	}

}

class NonTask {
	
	public void run () {
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
