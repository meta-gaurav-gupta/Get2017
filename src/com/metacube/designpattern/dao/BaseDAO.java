package com.metacube.designpattern.dao;

/**
 * BaseDAO is an super interface for all type of DAO
 * @author Gaurav
 *
 */
public interface BaseDAO {
	
    /**
     * adds to Database or file
     * @return boolean
     */
    public boolean add();

    /**
     * update in Database or file
     * @return boolean
     */
    public boolean update();

    /**
     * modify in Database or file
     * @return boolean
     */
    public boolean modify();

    /**
     * delete from Database or file
     * @return boolean
     */
    public boolean delete();

}
