package com.metacube.ds.assignment2.collection;

import com.metacube.ds.assignment2.entity.Employee;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gaurav
 */
public class EmployeeCollection implements Collection{

    private Map<Integer,Employee> map;

    /**
     * Constructs a new, empty collection
     */
    public EmployeeCollection() {
        map = new HashMap<>();
    }
    
    /**
     * Adds the specified element to this collection if it is not already present.
     *
     * @param e element to be added to this set
     * @return true if this collection did not already contain the specified
     * element false if the data is duplicate
     */
    @Override
    public boolean add(Object e) {
        boolean result;
        if(contains(e)){
            result = false;
        } else {
            map.put(((Employee)e).getEmpId(), (Employee)e);
            result = true;
        }
        return result;
    }
    
    /**
     * Returns the number of elements in this collection.
     *
     * @return the number of elements in this collection
     */
    @Override
    public int size() {
        return map.size();
    }

    /**
     * Returns true if this collection contains no elements.
     *
     * @return true if this collection contains no elements
     */
    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }
    
    /**
     * Returns list of employees contains in this collection
     * 
     * @return list of employees contains in this collection
     */
    public List<Employee> toList(){
        return new ArrayList<>(map.values());
    }
    
    /**
     * Returns true if this set contains the specified element.
     *
     * @param o element whose presence in this collection is to be tested
     * @return true if this collection contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        return map.containsKey(((Employee)o).getEmpId());
    }

    /**
     * Returns an iterator over the elements in this collection.
     *
     * @return an Iterator over the elements in this collection
     */
    @Override
    public Iterator iterator() {
        return map.values().iterator();
    }

    /**
     * Returns an array containing all of the elements in this collection.
     *
     * @return an array containing all of the elements in this collection
     */
    @Override
    public Object[] toArray() {
        // TODO convert the map to object array
        return null;
    }

    /**
     * Returns an array containing all of the elements in this collection;
     * the runtime type of the returned array is that of the specified array.
     * @param a the array into which the elements of this collection are to be
     * stored
     */
    @Override
    public Object[] toArray(Object[] a) {
        // TODO convert the map to object array
        return null;
    }

    
    /**
     * Removes the specified element from this collection if it is present.
     *
     * @param o object to be removed from this collection, if present
     * @return true if the collection contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        //TODO remove employee from map
        return false;
    }

    /**
     * Returns true if this collection contains all of the elements
     * in the specified collection.
     *
     * @param  c collection to be checked for containment in this collection
     * @return true if this collection contains all of the elements
     *         in the specified collection
     */
    @Override
    public boolean containsAll(Collection c) {
        //TODO check if c exits in map
        return false;
    }

    /**
     * Adds all of the elements in the specified collection to this collection
     * (optional operation).
     *
     * @param c collection containing elements to be added to this collection
     * @return true if this collection changed as a result of the call
     */
    @Override
    public boolean addAll(Collection c) {
        //TODO add collection c to current map
        return false;
    }

    /**
     * Removes all of this collection's elements that are also contained in the
     * specified collection (optional operation).
     *
     * @param c collection containing elements to be removed from this collection
     * @return true if this collection changed as a result of the
     * call
     */
    @Override
    public boolean removeAll(Collection c) {
        //TODO remove all exits in c from map
        return false;
    }

    /**
     * Removes all of the elements from this collection.
     * The set will be empty after this call returns.
     */
    @Override
    public void clear() {
        map.clear();
    }

    /**
     * Retains only the elements in this collection that are contained in the
     * specified collection.
     *
     * @param c collection containing elements to be retained in this collection
     * @return true if this collection changed as a result of the call
     */
    @Override
    public boolean retainAll(Collection c) {
        //TODO Retains only the elements in this collection that are contained in the specified collection
        return false;
    }
    
}
