package typeinfo;

//: typeinfo/SimpleDynamicProxy.java
import java.lang.reflect.*;

class DynamicProxyHandler implements InvocationHandler {
	private Object proxied;
	
	private int times;

	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// Exercise23
		// 这里调用了proxy的toString()方法，这样就会调用invoke方法，参数method是toString(),
		// 接着继续打印proxy,出现了死循环,所以不要在invoke方法里调用proxy的方法
//		System.out.println(proxy);
		System.out.println("**** proxy: " + proxy.getClass() + ", method: "
				+ method + ", args: " + args);
		if (args != null)
			for (Object arg : args)
				System.out.println("  " + arg);
		System.out.println(++times); // Exercise22
		return method.invoke(proxied, args);
	}
}

class SimpleDynamicProxy {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}

	public static void main(String[] args) {
		RealObject real = new RealObject();
		consumer(real);
		// Insert a proxy and call again:
		Interface proxy = (Interface) Proxy.newProxyInstance(
				Interface.class.getClassLoader(),
				new Class[] { Interface.class }, new DynamicProxyHandler(real));
		consumer(proxy);
		consumer(proxy);
		consumer(proxy);
		consumer(proxy);
	}
} /*
 * Output: (95% match) doSomething somethingElse bonobo*** proxy: class $Proxy0,
 * method: public abstract void Interface.doSomething(), args: null doSomething
 * *** proxy: class $Proxy0, method: public abstract void
 * Interface.somethingElse(java.lang.String), args: [Ljava.lang.Object;@42e816
 * bonobo somethingElse bonobo
 */// :~
