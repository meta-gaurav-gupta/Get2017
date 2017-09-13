package com.metacube.ds.assignment2.controller;

import com.metacube.ds.assignment2.entity.Guest;
import com.metacube.ds.assignment2.enums.Rooms;
import com.metacube.ds.assignment2.facade.AllotmentFacade;
import java.util.List;

/**
 *
 * @author Gaurav
 */
public class Controller {

    private AllotmentFacade facade;
    
    /**
     * Initialize facade singleton object
     */
    public Controller() {
        facade = AllotmentFacade.getInstance();
    }
    
    /**
     * Allot rooms to the list of guests
     * @param guests List of guests 
     */
    public void allotRooms(List<Guest> guests){
        guests.forEach((guest) -> {
            facade.allotRoom(guest);
        });
        
        facade.getAllGuest().forEach((data) -> {
            System.out.println(data);
        });
    }
    
    /**
     * Check if rooms are available, if true are they sufficient
     * @param rooms integer no of rooms
     * @return Rooms enum FULL if no room available, INSUFFICIENT if not enough space, AVAILABLE if enough space is free
     */
    public Rooms isAvailable(int rooms){
        Rooms result;
        int freeRooms = facade.freeRooms();
        if(freeRooms == 0) {
            result = Rooms.FULL;
        } else if(freeRooms < rooms) {
            result = Rooms.INSUFFICIENT;
        } else {
            result = Rooms.AVAILABLE;
        }
        return result;
    }
}
