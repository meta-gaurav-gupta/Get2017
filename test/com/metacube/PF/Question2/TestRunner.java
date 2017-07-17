package com.metacube.PF.Question2;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
/**
 *
 * @author Gaurav
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
