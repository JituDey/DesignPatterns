public class PrototypeTest {

	public static Dog loadData(String name, int age, String color){
    	// load from DB
        Leg l = new Leg(2);
        Eye eye=new Eye(2);
        Ear ear=new Ear(2);
        Tail t=new Tail(1);
        
        Dog dog = new Dog(name, age, color, eye, ear, t, l);
        return dog;
    }

    public static void main(String[] args) throws CloneNotSupportedException{
        Dog d1= loadData("Dog1", 2, "White");
        Dog d2 = (Dog) d1.clone();
        d2.name="Dog2";
        
        System.out.println(d1.name);
        System.out.println(d2.name);
    }
}