package com.zhenai.exercise.arrays;


public class Exercise1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BerylliumSphere[] a; // Local uninitialized variable
		
		BerylliumSphere[] d = { new BerylliumSphere(), new BerylliumSphere(),
				new BerylliumSphere() };
		
		// Dynamic aggregate initialization:
		a = new BerylliumSphere[] { new BerylliumSphere(),
				new BerylliumSphere(), };
		
		Exercise1 e = new Exercise1();
		e.invoke(d);
		e.invoke(a);

	}

	public void invoke(BerylliumSphere[] array) {
		System.out.println(array);
	}

}
