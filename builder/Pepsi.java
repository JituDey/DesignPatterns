package builder;

public class Pepsi extends ColdDrink {
	@Override
	public float price(){
		return 35;
	}
	
	@Override
	public String name(){
		return "Pepsi";
	}
}
