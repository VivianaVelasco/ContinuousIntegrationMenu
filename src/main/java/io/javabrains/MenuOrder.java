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

	
	
	
}
