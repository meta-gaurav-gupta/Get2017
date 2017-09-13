package com.metacube.ds.assignment2.controller;

import com.metacube.ds.assignment2.entity.Guest;
import com.metacube.ds.assignment2.enums.Rooms;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class ControllerTest {

    /**
     * Test of isAvailable method, of class Controller.
     */
    @Test
    public void testIsAvailable() {
        int rooms = 2;
        Controller controller = new Controller();
        Rooms expResult = Rooms.AVAILABLE;
        Rooms result = controller.isAvailable(rooms);
        assertEquals(expResult, result);
        
        rooms = 12;
        expResult = Rooms.INSUFFICIENT;
        result = controller.isAvailable(rooms);    
        assertEquals(expResult, result);
        List<Guest> guests = new ArrayList<>();
        Guest guest;
        for(int index = 1; index <= 11; index++){
            guest = new Guest();
            guest.setName("hello " + index);
            guest.setAge(index);
            guests.add(guest);
        }
        controller.allotRooms(guests);
        expResult = Rooms.FULL;
        result = controller.isAvailable(rooms);    
        assertEquals(expResult, result);
    }
    
}
