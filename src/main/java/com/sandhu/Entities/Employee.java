package com.sandhu.Entities;

import com.sandhu.Enums.Role;

public class Employee extends Person{

    private final String empId;

    private Role role;


    public Employee(String name, String age, Address address, String empId) {
        super(name, age, address);
        this.empId = empId;
    }

    public String getEmpId() {
        return empId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
