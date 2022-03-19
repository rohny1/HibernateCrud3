package com.crudexample.HibernateCURD3;

import java.util.List;

import com.HibernateCRUD.DAO.EmployeeDAO;
import com.HibernateCRUD.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EmployeeDAO employeedao= new EmployeeDAO();
//        Employee employee = new Employee(201,"Rohan",500000,"rohandewang8483@gmail.com");
//        employeedao.saveEmployee(employee);
        
        Employee employee2 = employeedao.getEmployeeById(201);
        System.out.println(employee2);
   //     List<Employee>employees = employeedao.getAllEmployees();
        
  //      employees.forEach(employee1-> System.out.println(employee1.getEid()));
//        employeedao.deEmployee(employee.getEid());
    }
}
