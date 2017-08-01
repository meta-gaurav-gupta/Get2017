package com.metacube.oops;

/**
 *
 * @author Gaurav
 */
public class MainClass {
    public static void main(String[] args) {
        MenuUtils menuUtils = new MenuUtils();
        Menu menu = menuUtils.createMenu();
        menuUtils.initMenu(menu);
    }
}
