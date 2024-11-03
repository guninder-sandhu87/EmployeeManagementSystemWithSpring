package com.sandhu.dao;
import com.sandhu.Entities.Employee;
import com.sandhu.Entities.Address;

public interface EmployeeDao {

 void insert(Employee employee);

 void insertAddress(Address address);
 void update(Employee employee);
 void delete(Employee employee);


}
