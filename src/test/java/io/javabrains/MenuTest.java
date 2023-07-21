package io.javabrains;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class MenuTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	


	@BeforeEach()
	public void setup() {
		MenuOrder menu;
		menu = new MenuOrder();
		ArrayList<MenuOrden> ordersU = new ArrayList<>();
		ordersU.add(new MenuOrden(3,17));
		menu.setUsersOptionsSelected(ordersU);
	} 
}
