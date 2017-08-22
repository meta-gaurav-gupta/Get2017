/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.Facade;

import com.metacube.entity.Product;
import com.metacube.enums.Status;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class ProductFacadeTest {

    /**
     * Test of search product method, of class ProductFacade.
     */
    @Test
    public void testSearchproduct() {
        //Positive Test Case
        String id = "1001";
        ProductFacade instance = ProductFacade.getInstance();
        Status expResult = Status.Found;
        Status result = instance.searchproduct(id);
        assertEquals(expResult, result);
        
        //Negative Test Case
        id = "500000";
        expResult = Status.NOT_Found;
        result = instance.searchproduct(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getProduct method, of class ProductFacade.
     */
    @Test
    public void testGetProduct() {
        String id = "1001";
        ProductFacade instance = ProductFacade.getInstance();
        Product expResult = new Product();
        expResult.setId("1001");
        expResult.setName("Reebok Sneakers");
        expResult.setPrice(899);
        instance.getAllProduct();
        Product result = instance.getProduct(id);
        assertEquals(expResult.getId(), result.getId());
    }

}
