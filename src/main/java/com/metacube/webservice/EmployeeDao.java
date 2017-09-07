package com.metacube.webservice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author Gaurav
 */
public class EmployeeDao {
    
    private static final String JSON_FILE_LOCATION = "C:\\Users\\User\\Documents\\RestWebService\\src\\main\\java\\com\\metacube\\webservice\\data.json";
    
     /*making EmployeeDao Singleton*/
    public static EmployeeDao employeeDao;
   
    private EmployeeDao(){
    }
    
    /**
     * Returns the single instance of EmployeeDao
     * @return EmployeeDao
     */
    public static EmployeeDao getInstance(){
        if(employeeDao==null){
            synchronized (EmployeeDao.class) {
                if(employeeDao==null){
                    employeeDao = new EmployeeDao();
                }
           }
       }
       return employeeDao;
    }
    
    /**
     * Add the employee to the local JSON file
     * @param newEmployee Employee to be added
     * @return Result FAILED in case of error, Success on successful creation
     */
    public Result addEmployee(Employee newEmployee){
        Result result = Result.FAILED;
        List<Employee> employees = getAllEmployees();
        employees.add(newEmployee);
        JSONObject rootJsonObj = new JSONObject();
        JSONArray list = new JSONArray();
        for(Employee emp : employees){
            list.add(Utils.employeeToJson(emp));
        }
        rootJsonObj.put("Employee", list);
        try (FileWriter file = new FileWriter(JSON_FILE_LOCATION)) {

            file.write(rootJsonObj.toJSONString());
            file.flush();
            result = Result.SUCCESS;

        } catch (IOException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        return result;
    }
    
    /**
     * Returns the employee associated with the employee id
     * @param employeeId employee id 
     * @return Employee 
     */
    public Employee getEmployee(int employeeId){
        JSONParser parser = new JSONParser();
        JSONObject obj;
        Employee employee = null;
        try {
            obj = (JSONObject)parser.parse(new FileReader(JSON_FILE_LOCATION));
            JSONArray employeeList = (JSONArray) obj.get("Employee");
            Iterator<JSONObject> iterator = employeeList.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObject = iterator.next();
                employee = Utils.jsonToEmployee(jsonObject);
                if(employeeId == employee.getId()){
                    break;
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, ex.getMessage());
        } catch (IOException | ParseException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        return employee;
    }
    
    /**
     * Returns the list of all the employees stored in file
     * @return List of Employees
     */
    public List<Employee> getAllEmployees(){
        JSONParser parser = new JSONParser();
        JSONObject obj;
        List<Employee> employees = new ArrayList<>();
        try {
            obj = (JSONObject)parser.parse(new FileReader(JSON_FILE_LOCATION));
            JSONArray employeeList = (JSONArray) obj.get("Employee");
            for (Object jsonObject : employeeList) {
                employees.add(Utils.jsonToEmployee((JSONObject)jsonObject));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, ex.getMessage());
        } catch (IOException | ParseException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        return employees;
    }
    
    /**
     * Returns the list of employee having the same first name
     * @param employeeName name of the employee
     * @return List of Employees
     */
    public List<Employee> getEmployeesByName(String employeeName){
        JSONParser parser = new JSONParser();
        JSONObject obj;
        List<Employee> employees = new ArrayList<>();
        try {
            obj = (JSONObject)parser.parse(new FileReader(JSON_FILE_LOCATION));
            JSONArray employeeList = (JSONArray) obj.get("Employee");
            Iterator<JSONObject> iterator = employeeList.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObject = iterator.next();
                Employee employee = Utils.jsonToEmployee(jsonObject);
                if(employeeName.equalsIgnoreCase(employee.getName())){
                    employees.add(employee);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, ex.getMessage());
        } catch (IOException | ParseException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        
        return employees;
    }
    
    /**
     * Removes the employee associated with given employee id
     * @param empId Employee Id
     * @return Result FAILED in case of error, SUCCESS on successful creation, NOT_FOUND in case employee not found
     */
    public Result deleteEmployee(int empId){
        Result result = Result.NOT_FOUND;
        List<Employee> employees = getAllEmployees();
        JSONObject obj = new JSONObject();
        for(Employee employee : employees){
            if(empId == employee.getId()){
                result = Result.FOUND;
                employees.remove(employee);
                break;
            }
        }
        JSONArray list = new JSONArray();
        if(result.equals(Result.FOUND)){
            for(Employee employee : employees){
                list.add(Utils.employeeToJson(employee));
            }
            result = Result.SUCCESS;
        }
        obj.put("Employee", list);
        try (FileWriter file = new FileWriter(JSON_FILE_LOCATION)) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, ex.getMessage());
            result = Result.FAILED;
        }
        
        return result;
    }
}
