/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.PF.Question2;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
/**
 *
 * @author User
 */
public class TestRunner {
    public static void main(String[] args) {
      Result result = JUnitCore.runClasses(TestSuite.class);

      result.getFailures().forEach((failure) -> {
          System.out.println(failure.toString());
        });
  
      System.out.println(result.wasSuccessful());
   }
}
