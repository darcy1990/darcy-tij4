package generics;

public class Fitzwilliam implements Person {
	
	private String lily;
	
	public Fitzwilliam (String lily) {
		this.lily = lily;
	}

	@Override
	public void sleep() {
		System.out.println("zzz...");
	}

	@Override
	public void love() {
		System.out.println("I love " + lily);
	}
	
	public void loveElizabeth() {
		System.out.println("I love Elizabeth.");
	}

}
