package io.javabrains;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

class MenuTest {

    TotalAmount totalAmount;

    @BeforeEach
    public void setUp() {
        totalAmount = new TotalAmount();
        ArrayList<MenuOrder> menuOrders = new ArrayList<MenuOrder>();
        menuOrders.add(new MenuOrder(1, 32));
        menuOrders.add(new MenuOrder(0, 32));
        menuOrders.add(new MenuOrder(2, 13));
        totalAmount.setUserElectionOrder(menuOrders);
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
        int result = InputValide.existMealsMenu(1, this.totalAmount.getUserElectionOrder());
        assertEquals(0, result);
    }

    @Test
    public void emptyOrderTest() {
        int result = InputValide.emptyOrder(this.totalAmount.getUserElectionOrder());
        assertEquals(0, result);
    }

    @Test
    public void maxQuantityVerificationTest() {
        int result = InputValide.maxQuantityVerification(32);
        assertEquals(0, result);
    }

    // class TotalAmount
    @Test
    public void addMealOrderTest() {
        int result = totalAmount.addMealOrder("1 32&4 3&5 4");
        assertEquals(0, result);
    }

    @Test
    public void calculateFinalPriceTotalTest() {
        double result = totalAmount.calculateFinalPriceTotal();
        assertEquals(100, result);
    }

    @Test
    public void obtainTotalTest() {
        int result = totalAmount.obtainTotal();
        assertEquals(100, result);
    }

    @Test
    public void getAmountTotalTest() {
        int result = totalAmount.getAmountTotal();
        assertEquals(100, result);
    }

    @Test
    public void resetExistedMealsTest() {
        int result = totalAmount.resetExistedMeals(0, 10);
        assertEquals(0, result);
    }

    @Test
    public void discountsDoneTest() {
        double totalCostTest = 500;
        int ordersMaked = 7;
        double result = totalAmount.discountsDone(totalCostTest, ordersMaked);
        double testValueEye = 500;
        if (ordersMaked > 5)
            testValueEye += testValueEye * 0.05;
        if (ordersMaked > 10)
            testValueEye += testValueEye * 0.10;
        if (testValueEye > 50)
        	testValueEye -= 10;
        if (testValueEye > 100)
        	testValueEye -= 25;
        assertEquals(testValueEye, result);
    }

    @Test
    public void orderCreatedChangedTest() {
        int result = totalAmount.OrderCreatedChanged("1 40");
        assertEquals(0, result);
    }
    
    // Test by Viviana Velasco

}