package com.example.erp.Controller;

import com.example.erp.Bean.Employee;
import com.example.erp.Bean.Organisation_HR;
import com.example.erp.DAO.DAOImplementation.EmployeeDAOImpl;
import com.example.erp.DAO.EmployeeDAO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/employee")
public class EmployeeController {

    EmployeeDAO empDAO = new EmployeeDAOImpl();

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Employee emp) {
        Employee loggedInEmployee = empDAO.login(emp);

        if (loggedInEmployee == null)
            return Response.status(401).build();
        else
            return Response.status(202).entity(loggedInEmployee).build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_employee(Employee emp){
        System.out.printf(String.valueOf(emp));
        if(empDAO.createEmployee(emp)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(400).entity("Failure while adding Employee").build();
    }


}
