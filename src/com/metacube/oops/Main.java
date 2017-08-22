package com.metacube.oops;

import com.metacube.oops.SocialNetwork.SocialNetwork;

/**
 * Main class of the application
 *
 * @author Gaurav
 * @version 1.1 30-JUL-2017
 */
public class Main {


    /**
     *
     * @param args the command Line arguments
     */
    public static void main(String[] args) {
        SocialNetwork obj = new SocialNetwork();
        obj.displaySocialNetwork();
        obj.printMenu();
    }

}
