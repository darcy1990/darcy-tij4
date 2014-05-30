package cocurrency;

public class Exercise2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 20;
		for (int i = 0;i < 5;i++) {
			Thread t = new Thread(new Runner2(5));
			t.start();
		}
	}

}

class Runner2 implements Runnable {
	
	int n;
	
	public Runner2 (int n) {
		this.n = n;
	}

	@Override
	public void run() {
		while (n > 0) {
			System.out.println(fib(n));
			n--;
		}
	}
	
	private int fib(int n) {
	    if(n < 2) return 1;
	    return fib(n-2) + fib(n-1);
	}
	
}
