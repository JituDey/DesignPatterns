package abstractFactory;

public class ShapeFactory extends AbstractFactory{

	@Override
	Color getColor(String color) {
		return null;
	}

	@Override
	Shape getShape(String shape) {
		if(shape.equals("Circle"))
			return new Circle();
		else if(shape.equals("Triangle"))
			return new Triangle();
		else
			return null;
	}

}
