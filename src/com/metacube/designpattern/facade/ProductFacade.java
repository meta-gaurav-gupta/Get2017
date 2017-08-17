package com.metacube.designpattern.facade;

import com.metacube.designpattern.dao.ProductDAOImpl;
import com.metacube.designpattern.entity.Product;
import java.util.List;

/**
 * @author Gaurav
 */
public class ProductFacade {
    private final ProductDAOImpl productDAO = ProductDAOImpl.getInstance();

    /**
     * returns all products which is available in store
     * @return List of Product
     */
    public List<Product> getAllProducts(){
        return productDAO.getAllProducts();
    }

    /**
     * find the product using specific product code
     * @param code
     * @return Product
     */
    public Product getProductByCode(String code) {
        List<Product> allProducts = productDAO.getAllProducts();
        Product product = null;
        for(Product tempProduct : allProducts){
            if(tempProduct.getCode().equals(code)){
                product = tempProduct;
                break;
            }
        }
        return product;
    }
	
}
