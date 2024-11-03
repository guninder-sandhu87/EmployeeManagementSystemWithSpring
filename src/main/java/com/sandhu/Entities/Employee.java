package com.sandhu.Entities;

import com.sandhu.Enums.Role;

public class Employee extends Person {

    private int empId;

    private Role role;


    public Employee(int empId, String name, int age, Address address,Role role) {
        super(name, age, address);
        this.empId = empId;
        this.role = role;

    }

    public Employee() {
        super();

    }


    public int getEmpId() {
        return empId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }


    @Override
    public String toString() {
        return "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n" +
                "empId='" + empId + '\'' +
                ", role=" + role + '\'' + super.toString();
    }
}
