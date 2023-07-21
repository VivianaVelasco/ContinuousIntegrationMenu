package io.javabrains;

public class MenuOrder {

	private int idMeal;
	private int quantity;

	public MenuOrder(int idMeal, int quantity) {
		super();
		this.idMeal = idMeal;
		this.quantity = quantity;
	}

	public int getIdMeal() {
		return idMeal;
	}

	public void setIdMeal(int idMeal) {
		this.idMeal = idMeal;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public static int validate(String ordersUser) {
		if (!ordersUser.contains("&")) {
			ordersUser += "&";
		}
		String[] userInputs = ordersUser.split("&");
		for (String inputSplit : userInputs) {
			String[] in = inputSplit.split(" ");
			int idMeal = Integer.parseInt(in[0]);
			int quantity = Integer.parseInt(in[1]);
			if (idMeal < 0 && idMeal > 6) {
				return -2;
			}
			if (!(quantity > 0)) {
				return -1;
			}
		}
		return 0;
	}

}