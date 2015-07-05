package com.zhenai.exercise.typeinfo;

import java.lang.reflect.Field;

public class Exercise9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// char[] is an object, because it has class name
		// but char is not an object
		char[] ch = {};
		// char c = 'a';
		Class<?> clazz = ch.getClass();
		System.out.println("class name:");
		System.out.println(clazz.getSimpleName());
		Field[] fields = clazz.getDeclaredFields();
		System.out.println("field name:");
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getName());
		}
	}

}
