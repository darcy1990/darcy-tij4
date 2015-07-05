package com.zhenai.exercise.strings;

import java.util.Formatter;

public class Exercise5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Formatter form = new Formatter(System.out);
		int d = 7;
		char c = 'a';
		boolean b = true;
		String s = "s";
		Float f = 1.1f;
		Double dou = 1.1;

		form.format("%d %c %b %s %f %e", d, c, b, s, f, dou);
	}

}
