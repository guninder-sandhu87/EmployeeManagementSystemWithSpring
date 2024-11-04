package com.sandhu.dao;

import com.sandhu.Entities.Address;
import com.sandhu.Entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.stereotype.Component;

import java.util.List;


@Component()
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Integer insert(Employee employee) {

        Integer addressId = insertAddress(employee.getAddress());
        String query = " insert into employee(name,age,addressId,role) values (?,?,?,?)";
        this.jdbcTemplate.update(query,employee.getName(),employee.getAge(),addressId,employee.getRole().getCode());
        String sql = "SELECT empId FROM employee ORDER BY empId DESC LIMIT 1";
        Integer empId=jdbcTemplate.queryForObject(sql, Integer.class);

        employee.setEmpId(empId);
        return empId;
    }

    @Override
    public Integer insertAddress(Address address) {
        String query = " insert into address(houseNo,streetNo,streetName) values (?,?,?)";
        this.jdbcTemplate.update(query,address.getHouseNo(),address.getStreetNo(),address.getStreetName());
        String addressIdquery = "SELECT addressId FROM Address ORDER BY addressId DESC LIMIT 1";
        return jdbcTemplate.queryForObject(addressIdquery, Integer.class);
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(int empId) {
        String getAddress="select addressId from employee where empId=?";
        Integer addressId = this.jdbcTemplate.queryForObject(getAddress, Integer.class,empId);
        String deleteEmployee="delete from Employee where empId=?";
        this.jdbcTemplate.update(deleteEmployee,empId);
        System.out.println(empId+ " successfully deleted");

        System.out.println("Deleting corresponding address now with id "+ addressId);
        String deleteAddress ="delete from Address where addressId=?";
        this.jdbcTemplate.update(deleteAddress,addressId);

    }

    @Override
    public Employee retrieveEmployee(int empId) {
        String query ="select * from employee where empId=?";
        RowMapper<Employee> employeeRowMapper = new EmployeeRowMapper();
        return this.jdbcTemplate.queryForObject(query, employeeRowMapper, empId);
    }

    @Override
    public Address retrieveAddress(int addressId) {
        String query ="select * from address where addressId=?";
        RowMapper<Address> addressRowMapper = new AddressRowMapper();
        return this.jdbcTemplate.queryForObject(query, addressRowMapper, addressId);

    }

    @Override
    public List<Employee> retrieveAllEmployees() {
        String query ="select * from employee ";
        RowMapper<Employee> employeeRowMapper = new EmployeeRowMapper();
        return this.jdbcTemplate.query(query, employeeRowMapper);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
