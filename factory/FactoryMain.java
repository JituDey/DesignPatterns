package factory;

public class FactoryMain {

	public static void main(String[] args) {
		OperatingSystemFactory.getInstance("Window").spec();
		OperatingSystemFactory.getInstance("IOS").spec();
	}
}