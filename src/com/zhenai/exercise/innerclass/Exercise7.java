package com.zhenai.exercise.innerclass;

public class Exercise7 {

	private int i;

	private int getValue() {
		return i;
	}

	private class InnerClass {
		private void setValue(int j) {
			Exercise7.this.i = j;
			Exercise7.this.getValue();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercise7 e = new Exercise7();
		InnerClass ic = e.new InnerClass();
		ic.setValue(5);
		System.out.println(e.getValue());
	}

}
