package com.sandhu.Entities;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String departmentName;
    private String managerId;

    private List<Employee> departmentEmployees;

    public Department(){
        departmentEmployees = new ArrayList<>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public List<Employee> getDepartmentEmployees() {
        return departmentEmployees;
    }

    public void setDepartmentEmployees(List<Employee> departmentEmployees) {
        this.departmentEmployees = departmentEmployees;
    }

    public void addEmployeeToDepartment(Employee employee) {
        departmentEmployees.add(employee);
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", managerId='" + managerId + '\'' +
                ", departmentEmployees=" + departmentEmployees +
                '}';
    }
}
