package com.metacube.oops.Node;

import com.metacube.oops.Entity.BaseEntity;
import com.metacube.oops.Record.Record;
import java.util.HashSet;

/**
 * This class is super class of application
 *
 * @author Gaurav
 */
public class Node implements Record {

    /**
     * Friends Set of entity
     */
    public HashSet<BaseEntity> friends = new HashSet<>();

    /**
     * Method to print Record of entities
     */
    @Override
    public void getRecord() {
    }
}
