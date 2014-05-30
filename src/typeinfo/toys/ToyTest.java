//: typeinfo/toys/ToyTest.java
// Testing class Class.
package typeinfo.toys;

import static net.mindview.util.Print.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Pattern;

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

//Exercise 2: the program can detect the new interface
interface NewInterface {
	
}

class Toy {
	// Comment out the following default constructor
	// to see NoSuchMethodError from (*1*)
	// Exercise1 : cannot instantiate
	Toy() {
	}

	public Toy(int i) {
	}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots, NewInterface{
	FancyToy() {
		super(1);
	}
}

public class ToyTest {
	static void printInfo(Class cc) {
		print("Class name: " + cc.getName() + " is interface? ["
				+ cc.isInterface() + "]");
		print("Simple name: " + cc.getSimpleName());
		print("Canonical name : " + cc.getCanonicalName());
	}

	public static void main(String[] args) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Class<?> c = null;
		try {
			c = Class.forName("typeinfo.toys.FancyToy");
		} catch (ClassNotFoundException e) {
			print("Can't find FancyToy");
			System.exit(1);
		}
		printInfo(c);
		for (Class<?> face : c.getInterfaces())
			printInfo(face);
		Class<?> up = c.getSuperclass();
		
		
		/*Constructor[] constructors = up.getConstructors();
		Pattern p = Pattern.compile("\\w+\\.|native\\s|final\\s");
		for (Constructor ctor : constructors)
			print(p.matcher(ctor.toString()).replaceAll(""));*/
		
		// Exercise19
		// the non default constructor of class Toy has been changed to public
		try {
			Constructor<?> nonDefaultConstructor = up.getConstructor(int.class);
			Object o = nonDefaultConstructor.newInstance(5);
			System.out.println(o);
			
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		Object obj = null;
		try {
			// Requires default constructor:
			obj = up.newInstance();
		} catch (InstantiationException e) {
			print("Cannot instantiate");
			System.exit(1);
		} catch (IllegalAccessException e) {
			print("Cannot access");
			System.exit(1);
		}
		printInfo(obj.getClass());
		
	}
} /*
 * Output: Class name: typeinfo.toys.FancyToy is interface? [false] Simple name:
 * FancyToy Canonical name : typeinfo.toys.FancyToy Class name:
 * typeinfo.toys.HasBatteries is interface? [true] Simple name: HasBatteries
 * Canonical name : typeinfo.toys.HasBatteries Class name:
 * typeinfo.toys.Waterproof is interface? [true] Simple name: Waterproof
 * Canonical name : typeinfo.toys.Waterproof Class name: typeinfo.toys.Shoots is
 * interface? [true] Simple name: Shoots Canonical name : typeinfo.toys.Shoots
 * Class name: typeinfo.toys.Toy is interface? [false] Simple name: Toy
 * Canonical name : typeinfo.toys.Toy
 */// :~
