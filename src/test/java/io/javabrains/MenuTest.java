import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

class MenuTest {

    TotalAmount totalAmount;

    @BeforeEach
    public void setUp() {
        totalAmount = new TotalAmount();
        ArrayList<MenuOrder> menuOrders = new ArrayList<MenuOrder>();
        menuOrders.add(new MenuOrder(1, 32));
        menuOrders.add(new MenuOrder(0, 32));
        menuOrders.add(new MenuOrder(2, 13));
        totalAmount.setMenuOrders(menuOrders);
    }

    // class MenuOrder
    @Test
    public void validateCorrectInputUserWriteOrdersTest() {
        int result = MenuOrder.validate("3 2&3 2");
        assertEquals(0, result);
    }

    // class InputValide
    @Test
    public void existMealsMenuTest() {
        int result = InputValide.existMealsMenu(1, this.totalAmount);
        assertEquals(0, result);
    }

    @Test
    public void emptyOrderTest() {
        int result = InputValide.orderCreate(this.totalAmount);
        assertEquals(0, result);
    }

    @Test
    public void maxQuantityVerificationTest() {
        int result = InputValide.maxQuantityVerification(32);
        assertEquals(0, result);
    }


}