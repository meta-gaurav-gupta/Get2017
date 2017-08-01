package com.metacube.oops;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Gaurav
 */
public class MenuUtils {
    
    /**
     * Create Menu Add Menu Items To Main Menu
     * @return Created Menu
     */
    public Menu createMenu(){
        System.out.println("Shopping Cart.");
        Menu mainMenu = new Menu();
        List<MenuItem> subMenu = mainMenu.getSubMenu();
        ShoppingStore store = new ShoppingStore();
        MenuItem addToCartMenu = new ActionableMenuItem(store);
        addToCartMenu.setDisplayName("1. Add To Cart.");
        subMenu.add(addToCartMenu);
        MenuItem showCartMenu = new ActionableMenuItem(store);
        showCartMenu.setDisplayName("2. Show Cart.");
        subMenu.add(showCartMenu);
        MenuItem exit = new ActionableMenuItem(store);
        exit.setDisplayName("3. Exit.");
        subMenu.add(exit);
        return mainMenu;
    }
    
    /**
     * Display the provided Menu
     * @param menu 
     */
    private void displayMenu(Menu menu){
        Iterator<MenuItem> iterator = menu.getSubMenu().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getDisplayName());
        }
    }
    
    /**
     * Initialize the provided menu and perform operations
     * @param menu 
     */
    public void initMenu(Menu menu){
        int choice;
        MenuItem menuItem;
        while(true){
            displayMenu(menu);
            choice = Utils.takeIntegerInput(1, 3);
            menuItem = menu.getSelection(choice - 1);
            ((ActionableMenuItem)menuItem).triggerAction(choice);   //All 3 options are actionable items, performing action
        }   
    }
}
