
package com.metacube.oops.Connection;

import com.metacube.oops.Entity.BaseEntity;
import com.metacube.oops.Entity.Person;
import com.metacube.oops.Node.Node;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class ConnectionTest {
    
    /**
     * Test of addNode method, of class Connection.
     */
    @Test
    public void testAddNode() {
        //Positive Test Case
        Node node = new Person("hello","world@hello.com","1010101010","jaipur");
        Connection instance = new Connection();
        boolean expResult = true;
        boolean result = instance.addNode(node);
        assertEquals(expResult, result);
        
        //Negative Test Case
        //User Already Exists Test Case
        node = new Person("hello","world@hello.com","1010101010","jaipur");
        expResult = false;
        result = instance.addNode(node);
        assertEquals(expResult, result);
    }

    /**
     * Test of addFriend method, of class Connection.
     */
    @Test
    public void testAddFriend() {
        //Positive Test Case
        String name1 = "gaurav";
        String name2 = "rahul";
        Connection instance = new Connection();
        Node user1 = new Person(name1,"world@hello.com","1010101010","jaipur");
        Node user2 = new Person(name2,"world@hello.com","1010101010","jaipur");
        instance.addNode(user1);
        instance.addNode(user2);
        boolean expResult = true;
        boolean result = instance.addFriend(name1, name2);
        assertEquals(expResult, result);
        
        //Negative Test Case
        String name3 = "hello";
        expResult = false;
        result = instance.addFriend(name1, name3);
        assertEquals(expResult, result);
    }

    /**
     * Test of nodeFinderByName method, of class Connection.
     */
    @Test
    public void testNodeFinderByName() {
        //Positive Test Case
        String name1 = "gaurav";
        Node user1 = new Person(name1,"world@hello.com","1010101010","jaipur");
        Connection instance = new Connection();
        instance.addNode(user1);
        BaseEntity result = instance.nodeFinderByName(name1);
        assertNotNull(result);
        
        //Negative Test Case
        String name2 = "user123";
        result = instance.nodeFinderByName(name2);
        assertNull(result);
    }

    /**
     * Test of searchDisplay method, of class Connection.
     */
    @Test
    public void testSearchDisplay() {
        //Positive Test Case
        String name = "gaurav";
        Connection instance = new Connection();
        boolean expResult = true;
        boolean result = instance.searchDisplay(name);
        assertEquals(expResult, result);
        
        //Negative Test Case
        String name2 = "user123";
        expResult = false;
        result = instance.searchDisplay(name2);
        assertEquals(expResult, result);
    }
    
}
