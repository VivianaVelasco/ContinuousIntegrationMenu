package io.javabrains;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Optional;



public class TotalAmount {

	private static int MAX_MEALS_QUANTITY = 100;
	private static int QUANTITY_MEALS_EXIST = 300;
	private ArrayList<MenuOrder> userElectionOrder;
	private ArrayList<Integer> specialMenuID;
	private ArrayList<Integer> availableMeals;
	private ArrayList<String> mealsNames;
	private ArrayList<Integer> priceMeals;
	

	
	public TotalAmount() {

		this.userElectionOrder = new ArrayList<>();
		this.availableMeals = new ArrayList<>(Arrays.asList(50, 50, 50, 50, 50, 50));
		this.mealsNames = new ArrayList<>(Arrays.asList( "Macarrones con Queso","Carbonata", "Pizza", "Fetuccini", "Frutti di Mare","Carapaccio" ));
		this.priceMeals = new ArrayList<>(Arrays.asList(5, 8, 10, 35, 50, 100));
		this.specialMenuID = this.createdSpecialsMeals(); 
		
	}
	
	public ArrayList<Integer> createdSpecialsMeals() {
		int finalLength = this.mealsNames.size() / 2;
		ArrayList<Integer> specialIDMeals = new ArrayList<>();
		for(int k = 0; k < finalLength; k++) {
			specialIDMeals.add(finalLength + k);
		}
		return specialIDMeals;
		
	}

	public int addMealOrder(String orders) {
		String[] ordersSeparated = orders.split("&");
		for(int x = 0; x < ordersSeparated.length; x++) {
			String orderSplit = ordersSeparated[x];
			String[] responseSplit = orderSplit.split("&");
			int idMenuMealElection = Integer.parseInt(responseSplit[0]) - 1;
			int userQElection = Integer.parseInt(responseSplit[1]);
			int validRes = MenuOrder.validate(orderSplit);
			this.seeAdvMessage(validRes);
			if(validRes != -1 || validRes != -2) {
				MenuOrder order = new MenuOrder(idMenuMealElection, userQElection);
				int validIdres = InputValide.existMealsMenu(validRes, userElectionOrder);
				if(validIdres != -4) {
					
					this.userElectionOrder.add(order);
				}else {
					this.seeAdvMessage(validIdres);
					
				}
			}
		}
		
		return 0;
		
	}
	
	public void calculateFinalPriceTotal() {
		int totalPrice = this.getAmountTotal();
		int amountResultVerRes = InputValide.maxQuantityVerification(totalPrice);
		if(amountResultVerRes == -6) {
			this.seeAdvMessage(amountResultVerRes);
			return;
		}
		
		int emptyReponseVer = InputValide.emptyOrder(this.userElectionOrder);
		if(emptyReponseVer == -5) {
			
			this.seeAdvMessage(emptyReponseVer);
			return;
		}
		for(int k = 0; k < this.userElectionOrder.size(); k++) {
			MenuOrder orderCreatedUser = userElectionOrder.get(k);
			int resExisted = this.resetExistedMeals(orderCreatedUser.getIdMeal(), orderCreatedUser.getQuantity());
			if(resExisted == -4) {
				
				this.seeAdvMessage(resExisted, orderCreatedUser.getIdMeal());
				System.out.println("Escriba 0 en el plato. Este plato no esta disponible. "
						+ "quantity. Verifiqiue el indice del plato sea el mismo.");
				break;
			}
		}
		double finalCost = this.obtainTotal();
		double finaCostIncludeDiscount = this.discountsDone(finalCost, this.userElectionOrder.size());
		
		
	}
	
	
	
	
	public int obtainTotal() {
		int result = 0;
		for(int m = 0; m < this.userElectionOrder.size(); m++ ) {
			int idDinner = this.userElectionOrder.get(m).getIdMeal();
			int amountDinner = this.userElectionOrder.get(m).getIdMeal();
			if(this.specialMenuID.contains(idDinner)) {
				result += (this.priceMeals.get(m) * amountDinner + this.priceMeals.get(m) * amountDinner * 0.05);
			}else {
				result += this.priceMeals.get(m)* amountDinner;			
			}
		}		
		return result;
	}
	
	public int getAmountTotal() {
		int total = this.userElectionOrder.stream()
				.map(element -> element.getQuantity())
				.reduce((acu, element) -> acu + element).orElse(0);
		return total;
	}

	
	public int resetExistedMeals(int id, int amount) {
		int amountTotal = this.availableMeals.get(id);
		if(amountTotal == 0) {
			return -3;
		}
		this.availableMeals.set(id, amountTotal - amount);
		return 0;
	}
	
	private void seeAdvMessage(int res, int... idMenuElectionUser) {
		if(res == -1) {
			System.out.println("La cantidad es negativa, la cual no se podra agregar a la orden. \n");
		}
		if(res == -2) {
			System.out.println("El id del plato es invalido, el cual no se podra agregar a la orden. \n");
		}
		if(res == -3) {
			System.out.println("El plato con el id:" + idMenuElectionUser + "no esta disponible. \n");
		}
		if(res == -4) {
			System.out.println("El id del plato ha sido seleccionado. Por favor ve al Cambiar Cantidad de platos para actualizar. \n");
		}
		if(res == -5) {
			System.out.println("No ha seleccionado un plato del menu. Por favor, elige un plato.\n");
		}
		if(res == -6) {
			System.out.println("Ha excedido el numero de platos disponibles en el restaurante. "
					+ "Porfavor corregir el numero de platos.\n");
		}
	}
	
public double discountsDone(double totalFinal, int numElectionMealsUser) {
	
		
		if( numElectionMealsUser > 5) {
			totalFinal = totalFinal * 0.05;
		}
		if(numElectionMealsUser > 10) {
			totalFinal = totalFinal * 0.10;
		}
		if(totalFinal > 50) {
			totalFinal -= 10;
		}
		if(totalFinal > 50) {
			totalFinal -= 10;
		}
		return totalFinal;
	}
	
	public void OrderCreatedChanged(String inputUser) {
		int validationRes = MenuOrder.validate(inputUser);
		if(validationRes != 1 || validationRes != 2) {
			
			String[] inputSplited = inputUser.split(" ");
			int userMealIdElection = Integer.parseInt(inputSplited[0]);
			int quantityMeals = Integer.parseInt(inputSplited[1]);
			MenuOrder order = this.userElectionOrder.get(userMealIdElection);
			order.setQuantity(quantityMeals);
			System.out.println("ID" + userMealIdElection + "El menu se ha actualizado. \n");
		}else {
			this.seeAdvMessage(validationRes);
			
		}
		
	}
	
	public void cancelUserOrder() {
		this.availableMeals = new ArrayList<>();
	}

}
