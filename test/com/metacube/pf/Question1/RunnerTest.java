package com.metacube.pf.Question1;

/**
 *
 * @author Gaurav
 */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class RunnerTest {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(SuiteTest.class);

      result.getFailures().forEach((failure) -> {
          System.out.println(failure.toString());
       });
		
      System.out.println(result.wasSuccessful());
   }
}  