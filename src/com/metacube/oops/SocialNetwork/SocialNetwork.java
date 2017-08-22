package com.metacube.oops.SocialNetwork;

import com.metacube.oops.Connection.Connection;
import com.metacube.oops.Constants.Constants;
import com.metacube.oops.Entity.BaseEntity;
import com.metacube.oops.Entity.Organization;
import com.metacube.oops.Entity.Person;
import com.metacube.oops.Utils.ReaderUtils;
import com.metacube.oops.Utils.ValidationNetworkUtils;
import java.io.IOException;
import java.util.HashSet;

/**
 *
 * @author Gaurav
 */
public class SocialNetwork extends Connection{

   /**
     * personSet
     *
     * contains the object of person class
     */
    public static HashSet<Person> personSet = new HashSet<>();

    /**
     * organizationSet
     *
     * contains the object of organization class
     */
    public static HashSet<Organization> organizationSet = new HashSet<>();

    /**
     * read
     *
     * Reader class Object to read file
     */
    private static ReaderUtils reader;

    /**
     * consoleReader
     *
     * Reader class object to read console input
     */
    private static ReaderUtils consoleReader;

    /**
     * instantiate Social Network
     *
     */
    public SocialNetwork() {
        try {
            reader = new ReaderUtils(Constants.PERSON_INFO_FILE);
            personSet = reader.readPersonInformation();
            reader = new ReaderUtils(Constants.ORGANIZATION_INFO_FILE);
            organizationSet = reader.readOrganizationInformation();
            consoleReader = new ReaderUtils(System.in);
        } catch ( IOException |IllegalArgumentException  ex) {
            System.out.println(ex.getMessage());
            System.out.println(" Halting the application");
            System.exit(0);
        }
    }

    /**
     * print menu method
     *
     * prints the menu of application
     */
    public void printMenu() {
        String choice, name1, name2;
        boolean flag = true;
        do {
            System.out.println("");
            System.out.println("Press 1 to Add a new node");
            System.out.println("Press 2 to Display social network");
            System.out.println("Press 3 to Search an entity by name");
            System.out.println("Press 4 to Add a friend");
            System.out.println("Press 5 to Remove a node from network");
            System.out.println("Press 6 to Remove a friend from friend list");
            System.out.println("Press 7 to Exit");
            choice = consoleReader.nextLine().trim();
            switch (choice) {
                case "1":
                    /**
                     * adding new node to network*
                     */
                    System.out.println(addNode(getData())?"Added Successfully!":"Error Occured!");
                    break;
                case "2":
                    /**
                     * Displaying social network
                     */
                    System.out.println("Social Network:");
                    displaySocialNetwork();
                    break;
                case "3":
                    /**
                     * Searching the user *
                     */
                    System.out.println("Enter name to find");
                    searchDisplay(consoleReader.nextLine().trim());
                    break;
                case "4":
                    System.out.println("Enter your name");
                    name1 = consoleReader.nextLine().trim();
                    if(!searchDisplay(name1)){
                        break;
                    }
                    System.out.println("Enter name of friend want to add");
                    name2 = consoleReader.nextLine().trim();
                    /**
                     * Making two user friend*
                     */
                    System.out.println(addFriend(name1, name2)?"Successfully Added!":"Error Occured!");
                    break;
                case "5":
                    System.out.println("Enter name of node to remove");
                    name1 = consoleReader.nextLine().trim();
                    /**
                     * Deleting a node from network*
                     */
                    System.out.println(removeNode(name1)?"Successfully Removed!":"Error Occured!");
                    break;
                case "6":
                    System.out.println("Enter your name");
                    name1 = consoleReader.nextLine().trim();
                    if(!searchDisplay(name1)){
                        break;
                    }
                    System.out.println("Enter name of friend want to remove");
                    name2 = consoleReader.nextLine().trim();
                    /**
                     * Making two user friend*
                     */
                    System.out.println(removeFriend(name1, name2)?"Successfully Removed!":"Error Occured!");
                    break;
                case "7":
                    System.out.println("Closing The application......");
                    /**
                     * Application exit terminal*
                     */
                    System.exit(0);
                default:
                    /**
                     * In case if choice is not valid*
                     */
                    System.out.println("Please choose a valid option");
            }
        } while (flag);

    }

    /**
     * getData method
     *
     * Use to read data of entity from console
     *
     * @return Object of Entity type
     */
    private BaseEntity getData() {
        System.out.println("If want to add Organisation press 1 ");
        System.out.println("If want to add Person press 2 ");
        int choice = 0;
        boolean flag = true;
        do {
            try {
                /**
                 * Take choice from user*
                 */
                choice = Integer.parseInt(consoleReader.nextLine().trim());
                if (choice <= 0 && choice > 2) {
                    throw new IllegalArgumentException();
                }
                flag = false;
            } catch (IllegalArgumentException e) {
                /**
                 * In case if input is not valid*
                 */
                System.out.println("Please Select A Valid Option");
            }
        } while (flag);
        /**
         * Taking name number and mail id as input from user*
         */
        String name = getName();
        String mail = getMail();
        String number = getNumber();

        BaseEntity entity;
        if (choice == 1) {
            System.out.println("/*****Enter type of Organisation******/");
            String type = consoleReader.nextLine().trim();
            /**
             * Making an instance of Organization*
             */
            entity = new Organization(name, mail, number, type);
        } else {
            System.out.println("/*****Enter Native city of Person******/");
            String city = consoleReader.nextLine().trim();
            /**
             * Making an instance of Person*
             */
            entity = new Person(name, mail, number, city);
        }

        /**
         * Returning the entity*
         */
        return entity;
    }

    /**
     * get Name method
     *
     * @return name of user reads from console
     */
    private String getName() {
        boolean flag = true;
        String name = "";
        do {
            try {
                System.out.println("/*****Enter Name******/");
                name = consoleReader.nextLine().trim();
                if (!ValidationNetworkUtils.checkName(name)) {
                    throw new IllegalArgumentException("Duplicate Username");
                }
                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (flag);
        /**
         * Returning name reads from console*
         */
        return name;
    }

    /**
     * get mail method
     *
     * @return mail of user reads from console
     */
    private String getMail() {
        boolean flag = true;
        String mail = "";
        do {
            try {
                System.out.println("/*****Enter Email Address******/");
                mail = consoleReader.nextLine().trim();
                if (!ValidationNetworkUtils.checkMail(mail)) {
                    /**
                     * In case if mail id is not valid*
                     */
                    throw new IllegalArgumentException("Enter a valid mail Id");
                }
                if (!ValidationNetworkUtils.checkDuplicacy(mail)) {
                    /**
                     * In case if mail id is duplicate*
                     */
                    throw new IllegalArgumentException("This mail Id is Already Registered");
                }
                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (flag);
        /**
         * Returning mail reads from console*
         */
        return mail;
    }

    /**
     * get number method
     *
     * @return contact number of user reads from console
     */
    private String getNumber() {
        boolean flag = true;
        String number = "";
        do {
            try {
                System.out.println("/*****Enter Number******/");
                number = consoleReader.nextLine().trim();
                if (!ValidationNetworkUtils.checkNumber(number)) {
                    /**
                     * In case if number is not valid*
                     */
                    throw new IllegalArgumentException("Enter a valid number");
                }
                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (flag);
        /**
         * Returning number reads from console*
         */
        return number;
    }
    
    public void displaySocialNetwork(){
        /**
         * Printing The record on console
         */
        System.out.println("******************Person Record******************\n");
        System.out.println("Name"+"\t"+"EmailID"+"\t\t\t"+"Contact Number"+"\t"+"Native City");

        /**
         * Read from person List and add it to exist Node*
         */
        personSet.stream().map((p) -> {
            addNode(p);
            return p;
        }).forEachOrdered((p) -> {
            p.getRecord();
        });

        /**
         * Printing The record on console
         */
        System.out.println();
        System.out.println();
        System.out.println("**************Organization Record******************\n");
        System.out.println("Name"+"\t"+"EmailID"+"\t\t"+"Contact Number"+"\t"+"Type Of Company");

        /**
         * Read From Organization List and add it to existNode*
         */
        organizationSet.stream().map((o) -> {
            addNode(o);
            return o;
        }).forEachOrdered((o) -> {
            o.getRecord();
        });
    }
    
}
