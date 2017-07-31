
package com.metacube.oops;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class CartTest {
   
    /**
     * Test of getProductQuantity method, of class Cart.
     */
    @Test
    public void testGetProductQuantity() {
        int productId = 1001;
        Cart instance = new Cart();
        Product product = new Product();
        product.setProductCode(productId);
        product.setProductQuantity(4);
        instance.addToCart(product);
        int expResult = 4;
        int result = instance.getProductQuantity(productId);
        assertEquals(expResult, result);
    }
    
}
