package cocurrency;

import static net.mindview.util.Print.print;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Exercise17
 * @author zhongming.yuan
 * @date 2014-3-5
 */
public class RadiationCounter {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new Sensor(i));
		}
		TimeUnit.SECONDS.sleep(3);
		exec.shutdown();
		if (!exec.awaitTermination(10, TimeUnit.SECONDS)) {
			print("Some tasks were not terminated!");
		}
		print(Sensor.getTotal());
		print(Sensor.sumSensors());
		
	}

}

class Sensor implements Runnable {
	private static Count count = new Count();
	
	private static List<Sensor>  sensorList = new ArrayList<Sensor>();
	
	private int number;
	
	private final int id;
	
	private static volatile boolean cancel = false;

	public Sensor(int id) {
		super();
		this.id = id;
		
		sensorList.add(this);
	}

	@Override
	public void run() {
		while(!cancel) {
			synchronized (this) {
				++number;
			}
			count.increment();
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized int getValue() {
		return number;
	}
	
	public static int getTotal() {
		return count.value();
	}
	
	public static int sumSensors() {
		int sum = 0;
		for (Sensor s : sensorList) {
			sum += s.getValue();
		}
		return sum;
	}	
}
