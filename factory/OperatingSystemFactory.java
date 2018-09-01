package factory;

public class OperatingSystemFactory {
	public static OS getInstance(String osType){
		if(osType.equals("Window")){
			return new Window();
		} else if(osType.equals("Android")){
			return new Android();
		} else if(osType.equals("IOS")){
			return new IOS();
		}
		return null;
	}
}
