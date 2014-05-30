package generics;

import java.util.ArrayList;

/**
 * Exercise19
 * @author zhongming.yuan
 * @date 2014-1-19
 */
public class Cargo extends ArrayList<Company>{
	
	public Cargo(int nCompanys, int nContainers, int nProducts) {
		for(int i = 0; i < nCompanys; i++) {
			add(new Company(nContainers, nProducts));
		}
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(Company c : this) {
			for(Container co : c) {
				for(Product p: co) {
					result.append(p);
					result.append("\n");
				}
			}
		}
		return result.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Cargo(5, 2, 3));
	}

}

/*class Product {
	private final int id;
	private String description;
	private double price;

	public Product(int IDnumber, String descr, double price) {
		id = IDnumber;
		description = descr;
		this.price = price;
		System.out.println(toString());
	}

	public String toString() {
		return id + ": " + description + ", price: $" + price;
	}

	public void priceChange(double change) {
		price += change;
	}

	public static Generator<Product> generator = new Generator<Product>() {
		private Random rand = new Random(47);

		public Product next() {
			return new Product(rand.nextInt(1000), "Test", Math.round(rand
					.nextDouble() * 1000.0) + 0.99);
		}
	};
}*/

class Container extends ArrayList<Product>  {
	
	public Container (int nProducts) {
		Generators.fill(this, Product.generator, nProducts);
	}
}

class Company extends ArrayList<Container> {
	
	public Company (int nContainer, int nProducts) {
		for(int i = 0; i < nContainer; i++) {
			add(new Container(nProducts));
		}
	}
}