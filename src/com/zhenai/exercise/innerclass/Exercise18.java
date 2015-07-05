package com.zhenai.exercise.innerclass;

public class Exercise18 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NestedClass nc = new NestedClass();
	}

	private static class NestedClass {
		private int i = 1;

		public int value() {
			return i;
		}
	}

}
