package cocurrency;

import java.util.concurrent.TimeUnit;

public class Exercise15b {
	
	private Object o1 = new Object();
	
	private Object o2 = new Object();
	
	private Object o3 = new Object();
	
	public void f() {
		synchronized (o1) {
			while(true) {
				System.out.println("f()");
				Thread.yield();
			}
		}
	}
	
	public void g() {
		synchronized (o2) {
			while(true) {
				System.out.println("g()");
				Thread.yield();
			}
		}
	}
	
	public void h() {
		synchronized (o3) {
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
		final Exercise15b e = new Exercise15b();
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
