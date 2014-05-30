package net.mindview.util;

public class SixTuple<A,B,C,D,E,F> extends FiveTuple<A, B, C, D, E>{
	
	public final F sixth;
	
	public SixTuple(A a, B b, C c, D d, E e, F f) {
		super(a, b, c, d, e);
		this.sixth = f;
	}
	
	public String toString() {
		return "(" + first + ", " + second + ", " +
			      third + ", " + fourth + ", " + fifth + "," + sixth + ")";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SixTuple<Integer, Integer, Long, Float, Double, Character> sixTuple = 
				new SixTuple<Integer, Integer, Long, Float, Double, Character>(5, 2, 3l, 1.1f, 1.2, 'c');
		System.out.println(sixTuple);
	}

}
