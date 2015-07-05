package com.zhenai.exercise.generics;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Exercise22
 * @author zhongming.yuan
 * @date 2014-1-24
 */
public class Exercise22 {
	
	Class<?> clazz;
	
	public Exercise22(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	public Object createNew() throws Exception {
		Constructor<?> c = clazz.getDeclaredConstructor(int.class);
		return c.newInstance(5);
	}

	/**
	 * @param args
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws NoSuchMethodException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 */
	public static void main(String[] args) throws Exception {
		Exercise22 e = new Exercise22(A.class);
		A a = (A) e.createNew();
		System.out.println(a.a);
	}

}

class A {
	
	int a;
	
	public A(int a) {
		this.a = a;
	}
}
