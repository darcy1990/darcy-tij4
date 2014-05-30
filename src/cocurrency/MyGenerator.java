package cocurrency;

public class MyGenerator extends IntGenerator {

	private volatile boolean canceled = false;

	private int a = 1;

	private int b = 2;

	@Override
	
	public synchronized int next() {
		a = a + 1;
		b = b + 2;
		return a + b;
	}

	public void cancel() {
		canceled = true;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public static void main(String[] args) {
		Exercise11.test(new MyGenerator());
	}

}
