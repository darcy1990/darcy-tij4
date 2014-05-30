package proxy;

import java.io.IOException;
import java.lang.reflect.Proxy;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		FileOperation fo = new FileOperation("E:\\workspace\\Prj_test\\src\\project\\file.txt");
		Operation proxy = (Operation) Proxy.newProxyInstance(Operation.class.getClassLoader(),
				new Class[]{Operation.class},
				new ProxyHandler(fo));
		proxy.create();
		proxy.write("just you know why.");
		proxy.read();
	}

}
