
package com.metacube.angularwebapi.spring;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * 
 * @author Gaurav
 */
public class Factory {
    
    static ApplicationContext applicationContext;

	static {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	static public ApplicationContext getApplicationContext()
        {
		return applicationContext;
        }
    
}
