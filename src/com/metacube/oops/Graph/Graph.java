package com.metacube.oops.Graph;

import com.metacube.oops.Entity.BaseEntity;
import com.metacube.oops.Entity.Organization;
import com.metacube.oops.Entity.Person;
import com.metacube.oops.Node.Node;
import com.metacube.oops.SocialNetwork.SocialNetwork;
import java.util.*;

/**
 * The Class Graph.
 *
 * @author Gaurav
 */
public class Graph {

    /**
     * The exist node.
     */
    public Set<BaseEntity> listOfNodes = new HashSet<>();

    private static Graph instance;
    
    public static Graph getInstance(){
        if(instance == null) {
            synchronized (Graph.class) {
                if(instance == null) {
                    instance = new Graph();
                }
            }
        }

        return instance;
    }
    
    /**
     * Adds the node.
     *
     * @param node the node
     * @return true, if successful
     */
    public boolean addNode(Node node) {
        boolean add = true;
        try {
            /**
             * Converts the object of type node to entity
             */
            BaseEntity entity = (BaseEntity) node;

            /**
             * Makes an Iterator over that
             */
            Iterator<BaseEntity> existNodeIterator = listOfNodes.iterator();

            /**
             * Check If the Node is Already Exist
             */
            while (existNodeIterator.hasNext()) {
                if (existNodeIterator.next().getEmailId().equals(entity.getEmailId())) {
                    /**
                     * If the node is exist than break the loop and return false
                     */
                    add = false;
                    break;
                }
            }
            /**
             * else
             */
            if (entity instanceof Person) {
                /**
                 * If the object is type of Person than add that object to
                 * person List
                 */
                SocialNetwork.personSet.add((Person) entity);
            } else {
                /**
                 * If the object is type of organization than add that object to
                 * organization List
                 */
                SocialNetwork.organizationSet.add((Organization) entity);
            }

            /**
             * Also add that object to exist node list*
             */
            listOfNodes.add(entity);
            
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return add;
    }

    /**
     * Adds the friend.
     *
     * @param name1 the name 1
     * @param name2 the name 2
     * @return true, if successful
     */
    public boolean addFriend(String name1, String name2) {

        /**
         * Object of entity to make friend*
         */
        BaseEntity entity1 = null;
        BaseEntity entity2 = null;

        /**
         * flag to check weather the nae are there or not*
         */
        boolean firstPersonNameExist = false;
        boolean secondPersonNameExist = false;

        /**
         * Flag to check if they are already a friend*
         */
        boolean checkForFriend = false;

        /**
         * Result flag*
         */
        boolean addFriend = false;
        try {
            Iterator<BaseEntity> iteratorexistNode = listOfNodes.iterator();
            /**
             * First checks If both the name exist on network*
             */
            while (iteratorexistNode.hasNext()) {

                BaseEntity entityTemp = iteratorexistNode.next();
                if (entityTemp.getName().equalsIgnoreCase(name1)) {
                    /**
                     * If name of first Person found*
                     */
                    entity1 = (BaseEntity) entityTemp;
                    firstPersonNameExist = true;
                }
                if (entityTemp.getName().equalsIgnoreCase(name2)) {
                    /**
                     * If name of Second Person found*
                     */
                    entity2 = (BaseEntity) entityTemp;
                    secondPersonNameExist = true;
                }
                if (firstPersonNameExist && secondPersonNameExist) {
                    /**
                     * If both of the Person found*
                     */
                    break;
                }
            }

            /**
             * If both the name exist on network than proceed further*
             */
            if (firstPersonNameExist && secondPersonNameExist) {
                /**
                 * Make an iterator to iterate over friends list*
                 */
                Iterator<BaseEntity> itr = entity1.friends.iterator();
                while (itr.hasNext()) {
                    if (itr.next().getEmailId().equalsIgnoreCase(entity2.getEmailId())) {
                        /**
                         * If both the person are already friend*
                         */
                        checkForFriend = true;
                    }
                }
                if (!checkForFriend) {
                    /**
                     * If both the person are not friend of each other* Make
                     * them friend*
                     */
                    entity1.friends.add(entity2);
                    entity2.friends.add(entity1);
                    addFriend = true;
                } else {
                    /**
                     * In case if they are already a friend*
                     */
                    System.out.println("Already Friend");
                }
            } else {
                /**
                 * If one of the name not exist on network*
                 */
                String s = (!firstPersonNameExist) ? name1 : name2;
                System.out.println(s + " Not Found in network");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /**
         * Result*
         */
        return addFriend;
    }

    /**
     * Find node in entity set by name
     *
     * @param name is name of organization or person
     * @return object for which user was looking null if user is not in network
     */
    public BaseEntity nodeFinderByName(String name) {
        BaseEntity entity = null;
        /**
         * Make an iterator over Exist Node List*
         */
        Iterator<BaseEntity> iteratorexistNode = listOfNodes.iterator();

        while (iteratorexistNode.hasNext()) {
            BaseEntity entityTemp = iteratorexistNode.next();
            if (entityTemp.getName().equalsIgnoreCase(name)) {
                /**
                 * If get the entity than set it to entity1 and return the
                 * object*
                 */
                entity = (BaseEntity) entityTemp;
                break;
            }
        }
        /**
         * Result Object*
         */
        return entity;
    }

    /**
     * It shows the search result
     *
     * @param name
     * @return boolean if user exists or not
     */
    public boolean searchDisplay(String name) {
        boolean isExist = false;
        BaseEntity entity = null;
        try {
            /**
             * First search entity by its name*
             */
            entity = nodeFinderByName(name);
            /**
             * If entity found than proceed further*
             */
            if (entity != null) {
                /**
                 * prints the information of entity*
                 */
                System.out.println("\nEntity Details:");
                entity.getRecord();
                System.out.println("\nFriend List:");
                /**
                 * Loop to iterate over friend list of entity*
                 */
                if(entity.friends.isEmpty()){
                    System.out.println("Empty");
                } else {
                    for (BaseEntity en : entity.friends) {
                        /**
                         * Prints the name of friend of entity*
                         */
                        System.out.println(en.getName());
                    }
                }
                isExist = true;
            } else {
                /**
                 * If entity is not in network than print the message*
                 */
                System.out.println("No record found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isExist;
    }

    /**
     * Remove node from network by name
     *
     * @param nameToRemove
     * @return boolean success or failed
     */
    public boolean removeNode(String nameToRemove) {
        boolean isNodeRemoved = false;
        try {
            /**
             * First Search node by its name*
             */
            BaseEntity entityToRemove = nodeFinderByName(nameToRemove);
            if (entityToRemove != null) {
                /**
                 * If node found than remove it from the list of all the nodes
                 * over network*
                 */
                removeFriendsFromAll(entityToRemove);
                /**
                 * remove from exist node over network
                 */
                listOfNodes.remove(entityToRemove);

                if (entityToRemove instanceof Person) {
                    /**
                     * If the node is of type person remove it from person list*
                     */
                    SocialNetwork.personSet.remove((Person) entityToRemove);
                } else {
                    /**
                     * else remove it from organization list*
                     */
                    SocialNetwork.organizationSet.remove((Organization) entityToRemove);
                }
                isNodeRemoved = true;
            } else {
                System.out.println("Person not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isNodeRemoved;
    }

    /**
     * Method to remove a friend from friend list
     *
     * @param name1 is the node1
     * @param name2 is the node2
     * @return success or failed
     */
    public boolean removeFriend(String name1, String name2) {
        boolean isFriendRemoved = false;
        try {
            /**
             * First create Object by finding name of person*
             */
            BaseEntity entity1 = nodeFinderByName(name1);
            BaseEntity entity2 = nodeFinderByName(name2);

            /**
             * Iterate over one's friend list*
             */
            Iterator<BaseEntity> iteratorFriends = entity1.friends.iterator();
            while (iteratorFriends.hasNext()) {
                if (iteratorFriends.next().getEmailId().equalsIgnoreCase(entity2.getEmailId())) {
                    /**
                     * If entity is found than remove it from friend List*
                     */
                    entity1.friends.remove(entity2);
                }
            }
            /**
             * Iterate over another object's friend list*
             */
            iteratorFriends = entity2.friends.iterator();
            while (iteratorFriends.hasNext()) {
                if (iteratorFriends.next().getEmailId().equalsIgnoreCase(entity1.getEmailId())) {
                    /**
                     * If entity is found than remove it from friend List*
                     */
                    entity2.friends.remove(entity1);
                }
            }
            isFriendRemoved = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return isFriendRemoved;
    }

    /**
     * Removes the friends from all entities.
     *
     * @param entity the entity
     */
    public void removeFriendsFromAll(BaseEntity entity) {
        try {
            /**
             * Make an iterator to iterate over exist node*
             */
            Iterator<BaseEntity> iteratorexistNode = listOfNodes.iterator();

            while (iteratorexistNode.hasNext()) {
                BaseEntity entityTemp = iteratorexistNode.next();
                /**
                 * Make an iterator to iterate over exist node*
                 */
                Iterator<BaseEntity> itrFriends = entityTemp.friends.iterator();
                while (itrFriends.hasNext()) {
                    if (itrFriends.next().getEmailId().equalsIgnoreCase(entity.getEmailId())) {
                        /**
                         * If entity found than remove It*
                         */
                        entityTemp.friends.remove(entity);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
