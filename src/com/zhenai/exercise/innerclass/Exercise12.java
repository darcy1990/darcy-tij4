package com.zhenai.exercise.innerclass;

public class Exercise12 {

	private int i;

	private int getValue() {
		return i;
	}

	private InnerClass innerClass(final int i) {
		return new InnerClass(i) {
			public void setValue() {
				Exercise12.this.i = i;
				System.out.println(Exercise12.this.getValue());
			}
		};
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercise12 e = new Exercise12();
		InnerClass ic = e.innerClass(5);
		ic.setValue();
	}
}

abstract class InnerClass {
	private int i;

	public InnerClass(int i) {
		this.i = i;
	}

	public abstract void setValue();
}
