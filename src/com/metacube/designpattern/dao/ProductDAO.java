package com.metacube.designpattern.dao;

import com.metacube.designpattern.entity.Product;
import java.util.List;

/**
 * ProductDAO is an interface which extends the BaseDAO
 * @author Gaurav
 *
 */
public interface ProductDAO extends BaseDAO{

    List<Product> getAllProducts();

}
