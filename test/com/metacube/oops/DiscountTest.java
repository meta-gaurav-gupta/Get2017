
package com.metacube.oops;

import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class DiscountTest {
    
    /**
     * Test of getProductLevelDiscount method, of class Discount.
     */
    @Test
    public void testGetProductLevelDiscount() {
        int productId = 1001;
        double productPrice = 749.00;
        HashMap<String, String> expResult = new HashMap<>();
        expResult.put("TYPE", Promotions.AMOUNT_DISCOUNT);
        expResult.put("DISCOUNT", "100.0");
        HashMap<String, String> result = Discount.getProductLevelDiscount(productId, productPrice);
        assertEquals(expResult, result);
    }

    /**
     * Test of getOrderLevelDiscount method, of class Discount.
     */
    @Test
    public void testGetOrderLevelDiscount() {
        double orderAmount = 2000;
        double expResult = 400;
        double result = Discount.getOrderLevelDiscount(orderAmount);
        assertEquals(expResult, result, 0.0);
    }
    
}
