package com.metacube.ds.counseling;

import com.metacube.ds.counseling.controller.CounsellingController;

/**
 *
 * @author GAurav
 */
public class Main {
    
    public static void main(String[] args) {
        CounsellingController cl = new CounsellingController();
        cl.doAllotment();
    }
}
