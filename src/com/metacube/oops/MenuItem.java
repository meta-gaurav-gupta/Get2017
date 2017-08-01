package com.metacube.oops;

/**
 *
 * @author Gaurav
 */
public abstract class MenuItem {
    private String displayName;

    /**
     * Get Display Name Of Menu Item
     * @return String display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Set Display Name Of Menu Item
     * @param displayName String
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
