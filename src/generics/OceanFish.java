package generics;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import net.mindview.util.Generator;

/**
 * Exercise18
 * @author zhongming.yuan
 * @date 2014-1-19
 */
public class OceanFish {
	
	public static void eat(BigFish b, LittleFish l) {
		System.out.println(b + " eat " + l);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand = new Random(47);
		Queue<LittleFish> littles = new LinkedList<LittleFish>();
		Generators.fill(littles, LittleFish.generator(), 10);
		List<BigFish> bigs = new LinkedList<BigFish>();
		Generators.fill(bigs, BigFish.generator(), 10);
		for(LittleFish b : littles) {
			eat(bigs.get(rand.nextInt(bigs.size())), b);
		}
	}

}

class LittleFish {
	
	private static long counter = 1;
	
	private final long id = counter++;

	public LittleFish() {
		
	}
	
	public String toString () {
		return "LittleFish " + id;
	}
	
	public static Generator<LittleFish> generator() {
		return new Generator<LittleFish>() {
			public LittleFish next () {
				return new LittleFish();
			}
		};
	}
}

class BigFish {
	
	private static long counter = 1;
	
	private final long id = counter++;

	public BigFish() {
		
	}
	
	public String toString () {
		return "BigFish " + id;
	}
	
	public static Generator<BigFish> generator() {
		return new Generator<BigFish>() {
			public BigFish next () {
				return new BigFish();
			}
		};
	}
}
