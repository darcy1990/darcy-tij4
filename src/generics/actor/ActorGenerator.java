package generics.actor;

import java.util.Iterator;
import java.util.Random;

import net.mindview.util.Generator;

/**
 * Exercise8
 * @author zhongming.yuan
 * @date 2014-1-9
 */
public class ActorGenerator implements Generator<Actor>, Iterable<Actor> {
	
	private Class<?>[] types = {Eason.class, Jackie.class, Leehom.class, Yuanyuan.class};
	
	private static Random random = new Random(47);
	
	// For iteration:
	private int size = 0;
	
	public ActorGenerator() {

	}

	public ActorGenerator(int size) {
		super();
		this.size = size;
	}

	@Override
	public Iterator<Actor> iterator() {
		return new ActorIterator();
	}

	@Override
	public Actor next() {
		try {
			return (Actor) types[random.nextInt(types.length)].newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	class ActorIterator implements Iterator<Actor> {
		
		int count = size;

		@Override
		public boolean hasNext() {
			return count > 0;
		}

		@Override
		public Actor next() {
			count--;
			return ActorGenerator.this.next();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ActorGenerator gen = new ActorGenerator();
		for (int i = 0; i < 5; i++) {
			System.out.println(gen.next());
		}
		for (Actor a : new ActorGenerator(5)) {
			System.out.println(a);
		}
	}

}
