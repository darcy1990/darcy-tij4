package generics;

import java.util.Iterator;

import net.mindview.util.Generator;

public class CompositionIterableFibonacci implements Generator<Integer>,
		Iterable<Integer> {
	private int count = 0;
	
	private int n = 0;

	public CompositionIterableFibonacci(int i) {
		n = i;
	}

	public Integer next() {
		return fib(count++);
	}

	private int fib(int n) {
		if (n < 2)
			return 1;
		return fib(n - 2) + fib(n - 1);
	}

	public static void main(String[] args) {
		for(int i : new CompositionIterableFibonacci(18)) {
			System.out.print(i + " ");
		}	      
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			public boolean hasNext() {
				return n > 0;
			}

			public Integer next() {
				n--;
				return CompositionIterableFibonacci.this.next();
			}

			public void remove() { // Not implemented
				throw new UnsupportedOperationException();
			}
		};
	}

}
