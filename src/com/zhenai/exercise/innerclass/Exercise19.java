package com.zhenai.exercise.innerclass;

public class Exercise19 {

	private static class NestedClass1 {
		private int i = 1;

		public int value() {
			return i;
		}

		private static class NestedClass2 {
			private int i = 1;

			public int value() {
				return i;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
