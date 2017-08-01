package com.metacube.oops;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gaurav
 */
public class Menu extends MenuItem{
    private List<MenuItem> subMenu=new ArrayList<>();

    /**
     * Get Sub menu
     * @return List of menu items
     */
    public List<MenuItem> getSubMenu() {
        return subMenu;
    }

    /**
     * Set the list of menu items
     * @param list of menu items
     */
    public void setSubMenu(List<MenuItem> list) {
        this.subMenu= list;
    }

    /**
     * Get Selection From Choice Entered
     * @param choice Integer
     * @return Menu Item associated with the selected number
     */
    public MenuItem getSelection(int choice){
        if(choice>=subMenu.size()){
            return null;
        }
        
        return subMenu.get(choice);
    }
}
