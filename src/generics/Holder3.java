package generics;

import typeinfo.pets.Cat;
import typeinfo.pets.Pet;

//: generics/Holder3.java

public class Holder3<T> {
	private T a;

	public Holder3(T a) {
		this.a = a;
	}

	public void set(T a) {
		this.a = a;
	}

	public T get() {
		return a;
	}

	public static void main(String[] args) {
		Holder3<Automobile> h3 = new Holder3<Automobile>(new Automobile());
		Automobile a = h3.get(); // No cast neededa
		// h3.set("Not an Automobile"); // Error
		// h3.set(1); // Error
		Holder3<Pet> h = new Holder3<Pet>(new Cat()); // Exercise1
		Cat c = (Cat) h.get();
	}
} // /:~
