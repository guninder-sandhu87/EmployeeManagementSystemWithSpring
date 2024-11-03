package com.sandhu.dao;
import com.sandhu.Entities.Employee;
import com.sandhu.Entities.Address;

import java.util.List;

public interface EmployeeDao {

 Integer insert(Employee employee);

 Integer insertAddress(Address address);
 void update(Employee employee);
 void delete(Employee employee);
 Employee retrieveEmployee(int empId);


 Address retrieveAddress(int addressId);

 List<Employee> retrieveAllEmployees();
}
