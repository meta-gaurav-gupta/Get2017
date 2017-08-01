
package com.metacube.oops;

/**
 *
 * @author Gaurav
 */
public class ActionableMenuItem extends MenuItem{
    Action action;
    
    /**
     * Trigger Action
     * @param type Integer type of action
     */
    public void triggerAction(int type){
        this.action.performAction(type);
    }

    /**
     * Constructor
     * @param action 
     */
    public ActionableMenuItem(Action action) {
        this.action = action;
    }
    
}
