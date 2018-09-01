package abstractFactory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String factoryType){
		if(factoryType.equals("Shape")){
			return new ShapeFactory();
		} else if(factoryType.equals("Color")){
			return new ColorFactory();
		}
		return null;
	}
}
