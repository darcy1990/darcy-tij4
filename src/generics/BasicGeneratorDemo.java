package generics;

//: generics/BasicGeneratorDemo.java
import net.mindview.util.*;

/**
 * @author zhongming.yuan
 * @date 2014-1-18
 */
public class BasicGeneratorDemo {
  public static void main(String[] args) {
    Generator<CountedObject> gen =
      BasicGenerator.create(CountedObject.class);
    // Exercise14
    Generator<CountedObject> gen_implicit =
      new BasicGenerator<CountedObject>(CountedObject.class);
    for(int i = 0; i < 5; i++)
      System.out.println(gen.next());
    for(int i = 0; i < 5; i++)
        System.out.println(gen_implicit.next());
  }
} /* Output:
CountedObject 0
CountedObject 1
CountedObject 2
CountedObject 3
CountedObject 4
*///:~
