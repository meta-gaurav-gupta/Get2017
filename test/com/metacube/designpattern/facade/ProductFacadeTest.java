/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.designpattern.facade;

import com.metacube.designpattern.entity.Product;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class ProductFacadeTest {
    
    /**
     * Test of getProductByCode method, of class ProductFacade.
     */
    @Test
    public void testGetProductByCode() {
        //Positive Test Case
        String code = "1001";
        ProductFacade instance = new ProductFacade();
        Product expResult = new Product();
        expResult.setCode("1001");
        expResult.setName("Reebok Sneakers");
        expResult.setPrice("749.00");
        Product result = instance.getProductByCode(code);
        assertEquals(expResult.getName(), result.getName());
        
        //Test Case for product no found
        code = "100";
        expResult = null;
        result = instance.getProductByCode(code);
        assertEquals(expResult, result);
    }
    
}
