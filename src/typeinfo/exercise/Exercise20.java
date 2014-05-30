package typeinfo.exercise;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.security.ProtectionDomain;

/**
 * @author zhongming.yuan
 * @date 2013-12-26
 * all use of Class Class<?>
 */
public class Exercise20 {

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Exercise20 e = new Exercise20();
		getClassInfo(e.getClass());
	}
	
	public static void getClassInfo(Class<?> clazz) throws InstantiationException, IllegalAccessException {
		// ?
		Annotation[] annotations = clazz.getAnnotations();
		
		String canonicalName = clazz.getCanonicalName();
		System.out.println(canonicalName);
		
		Class<?>[] classes = clazz.getClasses();
		
		ClassLoader classloader = clazz.getClassLoader();
		
		// ?
		Class<?> componentType = clazz.getComponentType();
		
		Constructor<?>[] constructors = clazz.getConstructors();
		
		Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
		
		Field[] declaredFields = clazz.getDeclaredFields();
		
		Method[] delcaredMethods = clazz.getDeclaredMethods();
		
		Class<?> declaredClass = clazz.getDeclaringClass();
		
		Field[] fields = clazz.getFields();
		
		Type[] types = clazz.getGenericInterfaces();
		
		Type type = clazz.getGenericSuperclass();
		
		Class<?>[] interfaces = clazz.getInterfaces();
		
		Method[] methods = clazz.getDeclaredMethods();
		
		int modifiers = clazz.getModifiers();
		System.out.println(modifiers);
		
		String name = clazz.getName();
		System.out.println(name);
		
		Package pack = clazz.getPackage();
		
		// ?
		ProtectionDomain protectionDomain = clazz.getProtectionDomain();
		
		Object[] signers = clazz.getSigners();
		
		String simpleName = clazz.getSimpleName();
		System.out.println(simpleName);
		
		Class<?> superClass = clazz.getSuperclass();
		
		System.out.println(clazz.isAnnotation());
		System.out.println(clazz.isAnonymousClass());
		System.out.println(clazz.isArray());
		System.out.println(clazz.isEnum());
		System.out.println(clazz.isInterface());
		System.out.println(clazz.isLocalClass());
		System.out.println(clazz.isMemberClass());
		System.out.println(clazz.isPrimitive());
		System.out.println(clazz.isSynthetic());
		
		Object o = clazz.newInstance();
		
		System.out.println(clazz.toString());		
	}
}
