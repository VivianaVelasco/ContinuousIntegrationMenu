package io.javabrains;
import java.util.ArrayList;

public class InputValide {
	public static final int MAX_MEALS_QUANTITY = 100;
	
	
	public static int existMealsMenu(int idMeals, ArrayList<MenuOrder> orderCreatedUser) {
		for(int x = 0; x < orderCreatedUser.size(); x++) {
			if(orderCreatedUser.get(x).getIdMeal() == idMeals) {
				return -4;
			}
		}
		return 0;
	}
	
	public static int emptyOrder(ArrayList<MenuOrder> orderCreate) {
		if(orderCreate.isEmpty()) {
			return -5;
		}
		return 0;
	}
	
	
	public static int validateQuantityMealsInputs(String orders) {
		String[] inputs = orders.split("|");
		for(int j = 0; j < inputs.length; j++) {
			String[] input = orders.split(" ");
			int idMeal = Integer.parseInt(inputs[0]);
			int quantity = Integer.parseInt(inputs[1]);
			if(idMeal < 0 && idMeal > 6) {
				return -2;
			}
			if(!(quantity > 0)) {
				return -1;
			}
		}
		return 0;
	}
	
	
	public static int maxQuantityVerification(int totalPrice) {
		if(totalPrice > MAX_MEALS_QUANTITY ) {
			return -6;
		}
		return 0;
	}
	
}
