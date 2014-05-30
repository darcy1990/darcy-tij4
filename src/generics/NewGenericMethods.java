package generics;

/**
 * Exercise9&10
 * @author zhongming.yuan
 * @date 2014-1-9
 */
public class NewGenericMethods {

	public <R, S, T> void f(R r,S s,Float f) {
		System.out.println(r.getClass().getName() + "\n" +
				s.getClass().getName() + "\n" +
				f.getClass().getName());
	}

	public static void main(String[] args) {
		NewGenericMethods gm = new NewGenericMethods();
		gm.f("", 1, 1.0F);
	}

}
