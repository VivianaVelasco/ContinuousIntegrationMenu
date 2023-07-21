package io.javabrains;

import java.util.ArrayList;

public class InputValide {
	public static int existMealsMenu(int idMeals, ArrayList<MenuOrder> orderCreatedUser) {
		for (int x = 0; x < orderCreatedUser.size(); x++) {
			if (orderCreatedUser.get(x).getIdMeal() == idMeals) {
				return -4;
			}
		}
		return 0;
	}

	public static int emptyOrder(ArrayList<MenuOrder> orderCreate) {
		int result = (orderCreate.isEmpty()) ? -5 : 0;
		return result;
	}

	public static int maxQuantityVerification(int totalPrice) {
		if (totalPrice > 100) {
			return -6;
		}
		return 0;
	}
}