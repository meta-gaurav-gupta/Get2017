package com.metacube.DAO;
import com.metacube.entity.BaseEntity;
import java.util.List;

/**
 * The Interface BaseDao.
 *
 *This DAO is the super DAO 
 * @param <T> the generic type
 * @author Gaurav
 */
public interface BaseDao<T extends BaseEntity> {
    

    /**
     * Gets the all product.
     *
     * @param <Product> the generic type
     * @return the list containing  all product
     */
    public <Product> List<T> getAllProduct();

    /**
    * Search product.
    *
    * @param <Product>
    * @param id the id
    * @return the t
    */
    public <Product> T searchproduct(String id);
}
