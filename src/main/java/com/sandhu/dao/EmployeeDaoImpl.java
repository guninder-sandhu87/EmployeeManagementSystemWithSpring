package com.sandhu.dao;

import com.sandhu.Entities.Address;
import com.sandhu.Entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component()
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void insert(Employee employee) {
        insertAddress(employee.getAddress());
        String query = " insert into employee(empId,name,age,addressId) values (?,?,?,?)";
        this.jdbcTemplate.update(query,employee.getEmpId(),employee.getName(),employee.getAge(),employee.getAddress().getAddressId());

    }

    @Override
    public void insertAddress(Address address) {
        String query = " insert into address(addressId,houseNo,streetNo,streetName) values (?,?,?,?)";
        this.jdbcTemplate.update(query,address.getAddressId(),address.getHouseNo(),address.getStreetNo(),address.getStreetName());
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Employee employee) {

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
