package com.metacube.pf.Question1;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gaurav
 */
public class TowerOfHanoiTest {
    /**
     * Test of towerOfHanoi method, of class TowerOfHanoi.
     */
    @Test
    public void testTowerOfHanoi() {
        
        //Positive Test Case
        TowerOfHanoi instance = new TowerOfHanoi();
        List<String> expResult = new ArrayList<>();
        expResult.add("Move Disk 3 from A to B");
        expResult.add("Move Disk 2 from A to C");
        expResult.add("Move Disk 3 from B to C");
        expResult.add("Move Disk 1 from A to B");
        expResult.add("Move Disk 3 from C to A");
        expResult.add("Move Disk 2 from C to B");
        expResult.add("Move Disk 3 from A to B");
        List<String> result = instance.towerOfHanoi("A", "B", "C", 3);
        assertEquals(expResult, result);
        
        //Negative Test Case
        result = instance.towerOfHanoi("", "", "", 3);
        expResult = null;
        assertEquals(expResult, result);
    }
    
}
