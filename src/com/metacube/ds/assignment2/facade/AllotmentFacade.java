package com.metacube.ds.assignment2.facade;

import com.metacube.ds.assignment2.entity.Guest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Gaurav
 */
public class AllotmentFacade {
    
    private static volatile AllotmentFacade facade;

    private static int num = 1;

    /**
     * Gets the single instance of AllotmentFacade.
     *
     * @return single instance of AllotmentFacade
     */
    public static AllotmentFacade getInstance() {
        if (facade == null) {
            synchronized (AllotmentFacade.class) {
                if (facade == null) {
                   facade = new AllotmentFacade();
                }
            }

        }

        return facade;
    }

    private List<Guest> infoList;

    private TreeMap<Integer, Boolean> rooms;

    private final static int TOTAL_ROOMS = 11;

    /**
     * Instantiates a new allotment facade.
     */
    public AllotmentFacade() {
        rooms = new TreeMap<>();
        infoList = new ArrayList<>();
        for (int index = 1; index <= TOTAL_ROOMS; index++) {
            rooms.put(index, true);
        }
    }

    /**
     * Allot rooms.
     *
     * @param guest the guest
     */
    public void allotRoom(Guest guest) {
        int hash;
        int roomNumber = 0;
        try {
            hash = guest.hashCode();
            hash = hash * num;
            num++;
            
            roomNumber = Math.abs(hash % TOTAL_ROOMS);
            if(roomNumber == 0) {
                roomNumber++;
            }
            
            if (!rooms.get(roomNumber)) {
                Set<Integer> set = rooms.keySet();
                Iterator<Integer> itr = set.iterator();
                
                while (itr.hasNext()) {
                    roomNumber = itr.next();
                    if (rooms.get(roomNumber)) {
                            break;
                    }
                }
            }
            guest.setRoom(roomNumber);
            infoList.add(guest);
            rooms.put(roomNumber, false);
        }catch(Exception e) {
            System.out.println("Error while alloting the room" + e.getMessage());
        }
    }

    /**
     * Return the number of free room
     *
     * @return the number of free rooms
     */
    public int freeRooms() {
        int result = 0;
        Set<Integer> keys = rooms.keySet();
        Iterator<Integer> itr = keys.iterator();
        while (itr.hasNext()) {
            if (rooms.get(itr.next())) {
                result++;
            }
        }
        return result;
    }

    /**
     * Return the 
     *
     * @return The string containing information of all guest
     */
    public List<String> getAllGuest() {
        Iterator<Guest> itr = infoList.iterator();
        List<String> details = new ArrayList<>();
        while (itr.hasNext()) {
            details.add(itr.next().toString());
        }
        return details;
    }
    
}
