package com.sandhu.logic;

import com.sandhu.Entities.Department;
import com.sandhu.Entities.Employee;
import com.sandhu.Entities.Address;
import com.sandhu.Enums.Role;
import com.sandhu.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Scanner;

public class AppLogic {

    @Autowired
    private EmployeeDao employeeDao;


    public Employee AddEmployee(ApplicationContext applicationContext, Scanner scan){
        System.out.println("You are going to add new Employee. We will need few details:");
        var employee = applicationContext.getBean("employee", Employee.class);
        System.out.println("Enter employee name");

        employee.setName(scan.nextLine());

        System.out.println("Enter employee age");
        employee.setAge(scan.nextInt());
        scan.nextLine();
        var address = employee.getAddress();
        System.out.println("Enter employee address - house No");
        address.setHouseNo(scan.nextLine());
        System.out.println("Enter employee address - streetNo");
        address.setStreetNo(scan.nextLine());
        System.out.println("Enter employee address - streetName");
        address.setStreetName(scan.nextLine());
        address.setAddressId(employee.getEmpId());
        employee.setAddress(address);
        System.out.print("Whats the designation of Employee.Choose from one of the below options: \n");
        for(Role r : Role.values()){
            System.out.println(r.getCode());
        }
        employee.setRole(Role.valueOf(scan.nextLine()));
        employeeDao.insert(employee);
        System.out.println("SuccessFully added Employee. The emp id is : "+employee.getEmpId());
        return employee;
    }

    public void addEmployeeToDepartment(ApplicationContext applicationContext, Scanner scan){
        var department = applicationContext.getBean("department", Department.class);

    }

    public Employee retrieveEmployeeById(int id){
        Employee employee = employeeDao.retrieveEmployee(id);
        int addressId = employee.getAddress().getAddressId();
        Address address =employeeDao.retrieveAddress(addressId);
        employee.setAddress(address);
        return employee;
    }
    public List<Employee> retrieveAllEmployees(){
        List<Employee> employee = employeeDao.retrieveAllEmployees();
        employee.forEach(emp->{
            int addressId = emp.getAddress().getAddressId();
            Address address =employeeDao.retrieveAddress(addressId);
            emp.setAddress(address);
        });
        return employee;
    }

    public Department createDepartment(ApplicationContext applicationContext, Scanner scan){
        var department = applicationContext.getBean("department", Department.class);
        System.out.println("You are trying to create the department. We need some details");
        System.out.println("Enter the department name");
        department.setDepartmentName(scan.nextLine());
        System.out.println("Department created ");
        return department;
    }
}
