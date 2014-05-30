package typeinfo;

//: typeinfo/Shapes.javas
import java.util.*;

abstract class Shape {
	void draw() {
		System.out.println(this + ".draw()");
	}
	
	// Exercise5: Circle doesn't need to rotate !
	void rotate() {
		if (this instanceof Circle) {
			System.out.println("Circle doesn't need to rotate !");
		} else {
			System.out.println(this + ".rotate()");
		}
	}

	abstract public String toString();
}

class Circle extends Shape {
	public String toString() {
		return "Circle";
	}
}

class Square extends Shape {
	public String toString() {
		return "Square";
	}
}

class Triangle extends Shape {
	public String toString() {
		return "Triangle";
	}
}

class Rhomboid extends Shape {
	public String toString() {
		return "Rhomboid";
	}
}

public class Shapes {
	public static void main(String[] args) {
		List<Shape> shapeList = Arrays.asList(new Circle(), new Square(),
				new Triangle());
		for (Shape shape : shapeList) {
			shape.draw();
			shape.rotate();
		}
		Rhomboid rh = new Rhomboid();
		Shape s = rh;
		Rhomboid newRh = null;
		if (s instanceof Rhomboid) {
			newRh = (Rhomboid) s;
		}
		System.out.println(newRh);
		Circle c = null;
		if (s instanceof Circle) { // Exercise4: use instanceof to check the type
			c = (Circle) s;
		}
//		Circle c = (Circle) s; // Exercise3: typeinfo.Rhomboid cannot be cast to typeinfo.Circle
		System.out.println(c);
	}
} /*
 * Output: Circle.draw() Square.draw() Triangle.draw()
 */// :~
