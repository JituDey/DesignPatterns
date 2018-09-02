package builder;

import java.util.ArrayList;

public class Meal {
	private ArrayList<Item> itemList = new ArrayList<>();
	
	public void addItem(Item item){
		itemList.add(item);
	}
	
	public float getCost(){
		float total = 0;
		for(Item i : itemList){
			total += i.price();
		}
		return total;
	}
	
	public void showItems(){
		for(Item i : itemList){
			System.out.println("Item name : "+i.name());
			System.out.println("Item price : "+i.price());
			System.out.println("Item packing : "+i.packing().pack());
		}
	}
}
