package generics.exercise;

/**
 * Exercise2
 * @author zhongming.yuan
 * @date 2013-12-26
 * @param <X>
 * @param <Y>
 * @param <Z>
 */
public class HolderThree<X,Y,Z> {
	
	private X x;
	
	private Y y;
	
	private Z z;

	public HolderThree(X x, Y y, Z z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HolderThree<Integer, Integer, Integer> holderThree = 
				new HolderThree<Integer, Integer, Integer>(1, 2, 3);
		System.out.println(holderThree.getX() + holderThree.getY() + holderThree.getZ());
	}

	public X getX() {
		return x;
	}

	public void setX(X x) {
		this.x = x;
	}

	public Y getY() {
		return y;
	}

	public void setY(Y y) {
		this.y = y;
	}

	public Z getZ() {
		return z;
	}

	public void setZ(Z z) {
		this.z = z;
	}

}
