package io.javabrains;

import java.util.Scanner;

public class Main {
	public static void main() {
		try {
			Scanner scan = new Scanner(System.in);
			String userOptionSelected = "";
			TotalAmount sum = new TotalAmount();
			int userInput = 0;
			while (userInput != 999) {
				numeroAcciones();
				userInput = scan.nextInt();

				if (userInput == 1) {
					mostrarMenu();
					System.out.println("Ecribe el numero de plato y las cantidades que deseas del plato ");
					System.out.println(
							"(Ejemplo: 2 7 ,o para seleccionar multiples platos y sus cantidades: 3 12 & 4 4 & 1 20):");
					userOptionSelected = scan.next();
					int respuesta = MenuOrder.validate(userOptionSelected);
					if (respuesta == -1)
						System.out.println("Ya has seleccionado esta opcion de nuevo.");
					else if (respuesta == -2)
						System.out.println("El numero de plato no existe. Ingrese de nuevo.");
					else
						sum.addMealOrder(userOptionSelected);
				}
				if (userInput == 2)
					sum.OrderCreatedChanged(userOptionSelected);
				if (userInput == 3)
					System.out.println("Total Cost is: " + sum.calculateFinalPriceTotal());
				if (userInput == 4)
					sum.cancelUserOrder();

			}
			System.out.println("Gracias. Regrese pronto.");
		} catch (Exception e) {
			System.out.println("Ocurrio un error en el sistema.");
			System.out.println("Cerrado!");
		}
	}

	private static void mostrarMenu() {
		System.out.println("[+] Bienvenido [+]");
		System.out.println("Escojan un plato: ");
		System.out.println("Menu: \n1. Macarrones con Queso $5\n" + "2. Carbonata $8\n" + "3. Pizza $10");
		System.out.println("Menu Premium: \n4. Fetuccini $35\n" + "5. Frutti di Mare $50\n" + "6. Carapaccio  $100");
	}

	private static void numeroAcciones() {
		System.out.println("1. Crear orden");
		System.out.println("2. Hacer cambios las cantidades de la orden");
		System.out.println("3. Confirmar order");
		System.out.println("4. Cancelar order");
		System.out.println("999. Salir");
	}
}