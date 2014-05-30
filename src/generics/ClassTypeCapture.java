package generics;

import java.util.HashMap;
import java.util.Map;

//: generics/ClassTypeCapture.java

class Building {
}

class House extends Building {
}

public class ClassTypeCapture<T> {
	Class<T> kind;
	
	Map<String, Class<?>> map = new HashMap<String, Class<?>>();

	public ClassTypeCapture(Class<T> kind) {
		this.kind = kind;
	}

	public boolean f(Object arg) {
		return kind.isInstance(arg);
	}
	
	public void addType(String typename, Class<?> kind) {
		map.put(typename, kind);
	}
	
	public Object createNew(String typename) throws Exception {
		Class<?> clazz = map.get(typename);
		if(clazz == null) {
			throw new Exception("This is no class which key is" + typename);
		}
		return clazz.newInstance();
	}

	public static void main(String[] args) throws Exception {
//		ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>(
//				Building.class);
//		System.out.println(ctt1.f(new Building()));
//		System.out.println(ctt1.f(new House()));
//		ClassTypeCapture<House> ctt2 = new ClassTypeCapture<House>(House.class);
//		System.out.println(ctt2.f(new Building()));
//		System.out.println(ctt2.f(new House()));
		
		// Exercise21
		ClassTypeCapture<House> ctt3 = new ClassTypeCapture<House>(House.class);
		ctt3.addType("Building", Building.class);
		ctt3.addType("House", House.class);
		Building b = (Building) ctt3.createNew("Building");
		House h = (House) ctt3.createNew("House");
	}
} /*
 * Output: true true false true
 */// :~
