package typeinfo.exercise;

import java.lang.reflect.Field;
import java.util.HashMap;

public class Exercise8 {

	/**
	 * @param args
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException {
		Exercise8 e = new Exercise8();
		e.printSuperClass(new B());
		// Class typeinfo.exercise.Exercise8 can not access a member of class
		// java.util.AbstractMap with modifiers "protected"
		e.printSuperClass(new HashMap<Object, Object>());
	}

	private void printSuperClass(Object obj) throws InstantiationException,
			IllegalAccessException {
		Class<?> clazz = obj.getClass();
		System.out.println("class name:");
		System.out.println(clazz.getSimpleName());
		Field[] fields = clazz.getDeclaredFields();
		System.out.println("field name:");
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getName());
		}
		if (clazz != Object.class) { // if not Object
			Class<?> clazzSuper = clazz.getSuperclass();
			printSuperClass(clazzSuper.newInstance());
		}
	}

}

class A {

}

class B extends A {

}
