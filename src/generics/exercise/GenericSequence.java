package generics.exercise;


//: innerclasses/Sequence.java
// Holds a sequence of Objects.

interface Selector {
	boolean end();

	Object current();

	void next();
}

public class GenericSequence<T> {
	private T[] items;
	private int next = 0;

	public GenericSequence(int size) {
		items = (T[]) new Object[size];
	}

	public void add(T x) {
		if (next < items.length)
			items[next++] = x;
	}

	private class SequenceSelector implements Selector {
		private int i = 0;

		public boolean end() {
			return i == items.length;
		}

		public Object current() {
			return items[i];
		}

		public void next() {
			if (i < items.length)
				i++;
		}
	}

	public Selector selector() {
		return new SequenceSelector();
	}

	public static void main(String[] args) {
		GenericSequence<String> sequence = new GenericSequence<String>(10);
		for (int i = 0; i < 10; i++)
			sequence.add("abc");
		Selector selector = sequence.selector();
		while (!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
	}
} /*
 * Output: 0 1 2 3 4 5 6 7 8 9
 */// :~
