package com.metacube.ds.assignment2.facade;

import com.metacube.ds.assignment2.entity.Guest;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class AllotmentFacadeTest {

    /**
     * Test of freeRooms method, of class AllotmentFacade.
     */
    @Test
    public void testFreeRooms() {
        AllotmentFacade facade = new AllotmentFacade();
        int expResult = 11;
        int result = facade.freeRooms();
        assertEquals(expResult, result);
        
        Guest guest = new Guest();
        guest.setName("hello");
        guest.setAge(11);
        facade.allotRoom(guest);
        expResult = 10;
        result = facade.freeRooms();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAllGuest method, of class AllotmentFacade.
     */
    @Test
    public void testGetAllGuest() {
        AllotmentFacade facade = new AllotmentFacade();
        int expResult = 2;
        Guest guest = new Guest();
        guest.setName("hello");
        guest.setAge(11);
        facade.allotRoom(guest);
        guest = new Guest();
        guest.setName("world");
        guest.setAge(12);
        facade.allotRoom(guest);
        List<String> guests = facade.getAllGuest();
        int result = guests.size();
        assertEquals(expResult, result);
    }
    
}
