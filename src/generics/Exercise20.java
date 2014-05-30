package generics;

public class Exercise20 {
	
	public <T extends Person> void description (T t) {
		t.sleep();
		t.love();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fitzwilliam fi = new Fitzwilliam("eeeeeeeeeeeeeelizabeth");
		Exercise20 e = new Exercise20();
		e.description(fi);
	}

}
