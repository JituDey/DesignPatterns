package builder;

public class MealBuilderDemo {

	public static void main(String[] args) {
		MealBuilder builder = new MealBuilder();
		Meal nonVegMeal = builder.prepareNonVegMeal();
		System.out.println("Printing chicken meal details - ");
		nonVegMeal.showItems();
		System.out.println("Total Payable :"+nonVegMeal.getCost());
		Meal vegMeal = builder.prepareVegMeal();
		System.out.println("Printing veg meal details - ");
		vegMeal.showItems();
		System.out.println("Total Payable :"+vegMeal.getCost());
	}

}
