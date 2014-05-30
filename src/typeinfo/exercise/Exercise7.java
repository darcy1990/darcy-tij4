package typeinfo.exercise;

//: typeinfo/SweetShop.java
// Examination of the way the class loader works.
import static net.mindview.util.Print.*;

class Candy {
  static { print("Loading Candy"); }
}

class Gum {
  static { print("Loading Gum"); }
}

class Cookie {
  static { print("Loading Cookie"); }
}

public class Exercise7 {

	public static void main(String[] args) {
	print("inside main");
	if (args == null) {
		System.out.println("please input object to create.");
		return;
	} 
	
	if (args.length >= 3 && args[0].equals("java") && args[1].equals("Exercise7")) {
		for (int i = 2; i < args.length; i++) {
			try {
				Class.forName("typeinfo.exercise" + "." + args[i]);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	} else {
		System.out.println("Illigal input!");
	}
  }
} /* Output:
inside main
Loading Candy
After creating Candy
Loading Gum
After Class.forName("Gum")
Loading Cookie
After creating Cookie
*///:~
