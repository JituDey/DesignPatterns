package abstractFactory;

public class ColorFactory extends AbstractFactory{

	@Override
	Color getColor(String color) {
		if(color.equals("Red"))
			return new Red();
		else if(color.equals("Blue"))
			return new Blue();
		else
			return null;
	}

	@Override
	Shape getShape(String shape) {
		return null;
	}

}