package generics;

//: generics/RandomList.java
import java.util.*;

import typeinfo.pets.Person;

public class RandomList<T> {
	private ArrayList<T> storage = new ArrayList<T>();
	private Random rand = new Random(47);

	public void add(T item) {
		storage.add(item);
	}

	public T select() {
		return storage.get(rand.nextInt(storage.size()));
	}

	public static void main(String[] args) {
		RandomList<String> rs = new RandomList<String>();
		for (String s : ("The quick brown fox jumped over "
				+ "the lazy brown dog").split(" "))
			rs.add(s);
		for (int i = 0; i < 11; i++)
			System.out.print(rs.select() + " ");
		
		// Exercise6
		System.out.print("\n");
		RandomList<Integer> rsi = new RandomList<Integer>();
		for (int j = 0; j < 10; j++) {
			rsi.add(j);
		}
		for (int k = 0; k < 10; k++) {
			System.out.print(rsi.select() + " ");
		}
		
		System.out.print("\n");
		RandomList<Person> rsPerson = new RandomList<Person>();
		for (int j = 0; j < 10; j++) {
			rsPerson.add(new Person("Mathew"));
		}
		for (int k = 0; k < 10; k++) {
			System.out.print(rsPerson.select() + " ");
		}
	}
} /*
 * Output: brown over fox quick quick dog brown The brown lazy brown
 */// :~
