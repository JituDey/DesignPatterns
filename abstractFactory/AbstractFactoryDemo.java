package abstractFactory;

public class AbstractFactoryDemo {
	public static void main(String[] args){
		AbstractFactory shapeFactory = FactoryProducer.getFactory("Shape");
		shapeFactory.getShape("Circle").draw();
		AbstractFactory colorFactory = FactoryProducer.getFactory("Color");
		colorFactory.getColor("Red").fill();
		colorFactory.getColor("Blue").fill();
	}
}
