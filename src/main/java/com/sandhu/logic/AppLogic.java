package com.sandhu.logic;

import com.sandhu.Entities.Employee;
import com.sandhu.Enums.Role;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

public class AppLogic {


    public Employee AddEmployee(ApplicationContext applicationContext, Scanner scan){
        System.out.println("You are going to add new Employee. We will need few details:");
        var employee = applicationContext.getBean("employee", Employee.class);
        System.out.println("Enter employee name");
        scan.nextLine();
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
        employee.setAddress(address);
        System.out.print("Whats the designation of Employee.Choose from one of the below options: \n");
        for(Role r : Role.values()){
            System.out.println(r.getCode());
        }
        employee.setRole(Role.valueOf(scan.nextLine()));
        return employee;
    }
}
