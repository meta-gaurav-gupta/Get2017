/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.oops.Connection;

import com.metacube.oops.Entity.BaseEntity;
import com.metacube.oops.Graph.Graph;
import com.metacube.oops.Node.Node;

/**
 * Helper Class
 * @author Gaurav
 */
public class Connection{
    
    /**
     * Single instance of graph
     */
    private Graph graph;
    
    /**
     * Constructor to initialize the graph instance for once
     */
    public Connection(){
        graph = Graph.getInstance();
    }
    
    /**
     * Adds the node.
     *
     * @param node the node
     * @return true, if successful
     */
    public boolean addNode(Node node) {
        return graph.addNode(node);
    }
    
    /**
     * Adds the friend.
     *
     * @param name1 the name 1
     * @param name2 the name 2
     * @return true, if successful
     */
    public boolean addFriend(String name1, String name2) {
        return graph.addFriend(name1, name2);
    }
    
    /**
     * Find node in entity set by name
     *
     * @param name is name of organization or person
     * @return object for which user was looking null if user is not in network
     */
    public BaseEntity nodeFinderByName(String name) {
        return graph.nodeFinderByName(name);
    }
    
    /**
     * It shows the search result
     *
     * @param name
     * @return if user exits or not
     */
    public boolean searchDisplay(String name) {
        return graph.searchDisplay(name);
    }
    
    /**
     * Remove node from network by name
     *
     * @param nameToRemove
     * @return boolean success or failed
     */
    public boolean removeNode(String nameToRemove) {
        return graph.removeNode(nameToRemove);
    }
    
    /**
     * Method to remove a friend from friend list
     *
     * @param name1 is the node1
     * @param name2 is the node2
     * @return boolean success or failed
     */
    public boolean removeFriend(String name1, String name2) {
        return graph.removeFriend(name1, name2);
    }
    
    /**
     * Removes the friends from all entities.
     *
     * @param entity the entity
     */
    public void removeFriendsFromAll(BaseEntity entity) {
        graph.removeFriendsFromAll(entity);
    }
    
}
