package com.zhenai.exercise.concurrency;

import static net.mindview.util.Print.print;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * use a queue to buffer products between consumer and producer
 * @author Matthew Yuan
 *
 */
public class Exercise24 {
	
	Queue<Product> products = new LinkedList<Exercise24.Product>();
	
	int Maxsize = 10;
	
	int sero;
	
	ExecutorService exec = Executors.newCachedThreadPool();
	Consumer consumer = new Consumer(this);
	Producer producer = new Producer(this);

	public Exercise24() {
		exec.execute(consumer);
		exec.execute(producer);
	}
	
	class Product {
		
		private final int orderNum;

		public Product(int orderNum) {
			this.orderNum = orderNum;
			sero ++;
		}

		public String toString() {
			return "Product " + orderNum;
		}
	}
	
	class Producer implements Runnable {
		
		public Producer(Exercise24 e) {
			super();
			this.e = e;
		}

		Exercise24 e;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while (!Thread.interrupted()) {
					synchronized (this) {
						while (e.products.size() == Maxsize)
							wait(); 
					}
					
					TimeUnit.MILLISECONDS.sleep(1000); // produce speed
					Product p = new Product(sero);
					e.products.add(p);
					print("Producer produce " + p);
					
					synchronized (e.consumer) {
						if (e.products.size() > 0) {
							e.consumer.notifyAll();
						}
					}
				}
			} catch (InterruptedException e) {
				print("WaitPerson interrupted");
			}
		}
		
	}
	
	class Consumer implements Runnable {
		
		public Consumer(Exercise24 e) {
			super();
			this.e = e;
		}

		Exercise24 e;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while (!Thread.interrupted()) {
					synchronized (this) {
						while (e.products.size() == 0)
							wait();
					}
					
					TimeUnit.MILLISECONDS.sleep(2000); // consumer speed
					print("Consumer got " + e.products.poll());
					
					synchronized (e.producer) {
						if (e.products.size() < Maxsize) {
							e.producer.notifyAll();
						}
					}
				}
			} catch (InterruptedException e) {
				print("WaitPerson interrupted");
			}
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Exercise24();
	}

}
