package com.zhenai.exercise.arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * invoke a method generate arrays of multiple dimensions
 * @author zhongming.yuan
 * 2014-10-26
 */
public class Exercise3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand = new Random(47);
		Exercise3 e = new Exercise3();
		for (int i = 0; i < 5; i++)
		{
			double[][] array = e.generate(rand.nextInt(7), rand.nextInt(7), 5, 10);
			System.out.println(Arrays.deepToString(array));
		}

	}
	
	private double[][] generate(int dimension1, int dimension2, double min, double max)
	{
		double[][] array = new double[dimension1][dimension2];
		for (int i = 0; i < dimension1; i++)
		{
			for (int j = 0; j < dimension2; j++)
			{
				array[i][j] = Math.random()*(min - max) + max;
			}
		}
		
		return array;
	}

}
