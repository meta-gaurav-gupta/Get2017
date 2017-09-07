package com.metacube.webservice;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Gaurav
 */

@Path("/controller")
public class EmployeeController {
    EmployeeDao employeeDaoObject=EmployeeDao.getInstance();
    
    //create operation
    @POST
    @Path("/employee")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Result addEmployee(Employee employee) {
        Result response;
        System.out.println(employee.getName());
        response = employeeDaoObject.addEmployee(employee);
        return response;
    }
    
    //retrieve operations
    @GET
    @Path("/employee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployeeById(@PathParam("id") int id) {
        return (Employee)employeeDaoObject.getEmployee(id);
    }
    
    @GET
    @Path("/employee/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployeeByName(@PathParam("name") String name){
        return (List<Employee>)employeeDaoObject.getEmployeesByName(name);
    }
    
    @GET
    @Path("/employee")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getAllEmployee(){
        return (List<Employee>)employeeDaoObject.getAllEmployees();
    }
    
    //delete operation
    @DELETE
    @Path("/employee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Result deleteEmployeeById(@PathParam("id") int id){
        return employeeDaoObject.deleteEmployee(id);
    }
}
