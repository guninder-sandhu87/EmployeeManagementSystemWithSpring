package com.sandhu.Entities;

import com.sandhu.Enums.Role;

public class Employee extends Person{

    private static int empId=0;

    private Role role;


    public Employee(String name, int age, Address address) {
        super(name, age, address);
    }

    public Employee(){
        super();
        empId++;
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

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", role=" + role + '\'' + super.toString();
    }
}
