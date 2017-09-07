
package com.metacube.webservice;

import org.json.simple.JSONObject;

/**
 * Utility Class
 * @author Gaurav
 */
public class Utils {
    /**
     * Convert the JSON object to Employee object
     * @param object JSON Object
     * @return Employee Object
     */
    public static Employee jsonToEmployee(JSONObject object){
        
        Employee employee = new Employee();
        int empId = ((Number)object.get("id")).intValue();
        String empName = (String)object.get("name");
        int empAge = ((Number)object.get("age")).intValue();
        employee.setId(empId);
        employee.setName(empName);
        employee.setAge(empAge);
        return employee;
        
    }
    
    /**
     * Convert the Employee object to JSON object
     * @param employee Employee Object
     * @return JSON Object
     */
    public static JSONObject employeeToJson(Employee employee){
        JSONObject empObj = new JSONObject();
        empObj.put("id", employee.getId());
        empObj.put("name", employee.getName());
        empObj.put("age", employee.getAge());
        return empObj;
    }
}
