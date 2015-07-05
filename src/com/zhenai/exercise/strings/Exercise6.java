package com.zhenai.exercise.strings;

public class Exercise6 {

	private int i;

	private long l;

	private float f;

	private double d;

	public Exercise6(int i, long l, float f, double d) {
		this.i = i;
		this.l = l;
		this.f = f;
		this.d = d;
	}

	public String toString() {
		return String.format("%d %d %f %f", i, l, f, d);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercise6 e = new Exercise6(1, 5, 1.1f, 1.5);
		System.out.println(e);
	}

}
