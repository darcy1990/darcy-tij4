package cocurrency;

public class Exercise1 {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0;i < 5;i++) {
			Thread t = new Thread(new Runner());
			t.start();
		}
	}

}

class Runner implements Runnable {
	
	public Runner () {
		System.out.println("Starting......!");
	}

	@Override
	public void run() {
		System.out.println("I am running !");
		Thread.yield();
		System.out.println("I am running !");
		Thread.yield();
		System.out.println("I am running !");
		Thread.yield();
		System.out.println("Stopping......!");
	}
	
}
