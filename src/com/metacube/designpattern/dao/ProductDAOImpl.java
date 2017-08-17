package com.metacube.designpattern.dao;

import com.metacube.designpattern.entity.Product;
import com.metacube.designpattern.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * FileProductDAO perform action on Product in File System
 * @author Gaurav
 *
 */
public class ProductDAOImpl implements ProductDAO{
    private static ProductDAOImpl productsDAO;
    private final static String FILEPATH = "src/Products.csv";
    /**
     * Private Constructor of Class FileProductDAO
     */
    private ProductDAOImpl() {
    
    }

    /**
     * getInstance method to return single object 
     * @return ProductDAO instance
     */
    public static ProductDAOImpl getInstance() {
        if(productsDAO == null) {
            synchronized (ProductDAOImpl.class) {
                if(productsDAO == null) {
                    productsDAO = new ProductDAOImpl();
                }
            }
        }

        return productsDAO;
    }

    /**
     * Method to get all product
     * @return List of Product
     */
    @Override
    public List<Product> getAllProducts(){
        List<Product> listOfProducts = new ArrayList<>();
        List<String> fileData = Utils.readCsvFile(FILEPATH);
        
        for(String lineNumber : fileData) {
            StringTokenizer tokenizer = new StringTokenizer(lineNumber, ",");
            
            while(tokenizer.hasMoreTokens()) {
                Product product = new Product();
                product.setCode(tokenizer.nextToken());
                product.setName(tokenizer.nextToken());
                product.setPrice(tokenizer.nextToken());
                listOfProducts.add(product);
            }
            
        }
        return listOfProducts;
    }

    /**
     * update in file
     * @return boolean
     */
    @Override
    public boolean update() {
        return false;
    }

    /**
     * modify in file
     * @return boolean
     */
    @Override
    public boolean modify() {
        return false;
    }

    /**
     * deletes from file
     * @return boolean
     */
    @Override 
    public boolean delete() {
        return false;
    }

    /**
     * adds to file
     * @return boolean
     */
    @Override
    public boolean add() {
        return false;
    }
}
