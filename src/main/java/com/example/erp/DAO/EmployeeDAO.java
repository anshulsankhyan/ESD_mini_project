package com.example.erp.DAO;

import com.example.erp.Bean.Employee;

public interface EmployeeDAO {

    Employee login(Employee emp);

    boolean createEmployee(Employee emp);
}
