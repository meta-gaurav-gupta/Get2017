package com.metacube.ds.assignment2.view;

import com.metacube.ds.assignment2.controller.Controller;
import com.metacube.ds.assignment2.entity.Guest;
import com.metacube.ds.assignment2.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gaurav
 */
public class View {
    
    /**
     * Initialize View
     */
    public void init() {
        Controller controller = new Controller();
        System.out.println("Hotel");
        System.out.println("\nEnter Number Of Rooms To Be Booked");
        int numberOfRooms = Utils.takeIntegerAsInput("number");
        switch(controller.isAvailable(numberOfRooms)){
            case AVAILABLE:
                controller.allotRooms(addGuests(numberOfRooms));
                System.out.println("\nAlloted Successfully!! ");
                break;
            case INSUFFICIENT:
                System.out.println("Insufficient Space");
                break;
            case FULL:
                System.out.println("No Room Available, All Booked!");
                break;
        }
    }
    
    /**
     * Get guests information
     * @param numberOfGuests integer
     * @return List of guest with information
     */
    private List<Guest> addGuests(int numberOfGuests){
        List<Guest> guests = new ArrayList<>();
        Guest guest;
        String name;
        int age;
        for(int index = 0; index < numberOfGuests; index++) {
            guest = new Guest();
            System.out.println("Enter Name Of Guest: " + (index + 1));
            name = Utils.takeStringAsInput();
            System.out.println("Enter Age Of Guest: " + (index + 1));
            age = Utils.takeIntegerAsInput("age");
            guest.setName(name);
            guest.setAge(age);
            guests.add(guest);
        }
        return guests;
    }
}
