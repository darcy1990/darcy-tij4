package typeinfo;

//: typeinfo/SimpleProxyDemo.java
import static net.mindview.util.Print.*;

interface Interface {
	void doSomething();

	void somethingElse(String arg);
}

class RealObject implements Interface {
	public void doSomething() {
		print("doSomething");
	}

	public void somethingElse(String arg) {
		print("somethingElse " + arg);
	}
}

class SimpleProxy implements Interface {
	private Interface proxied;
	
	public int times;

	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}

	public void doSomething() {
		print("SimpleProxy doSomething");
		proxied.doSomething();
		times++;
	}

	public void somethingElse(String arg) {
		print("SimpleProxy somethingElse " + arg);
		proxied.somethingElse(arg);
		times++;
	}
}

class SimpleProxyDemo {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.doSomething();
		iface.doSomething();
		iface.doSomething();
		iface.somethingElse("bonobo");
	}

	public static void main(String[] args) {
		consumer(new RealObject());
		SimpleProxy simpleProxy = new SimpleProxy(new RealObject());
		consumer(simpleProxy);
		System.out.println(simpleProxy.times); // Exercise21
	}
} /*
 * Output: doSomething somethingElse bonobo SimpleProxy doSomething doSomething
 * SimpleProxy somethingElse bonobo somethingElse bonobo
 */// :~
