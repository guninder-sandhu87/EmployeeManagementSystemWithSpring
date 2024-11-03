package com.sandhu.dao;

import com.sandhu.Entities.Address;
import com.sandhu.Entities.Employee;
import com.sandhu.Enums.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {



    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

        int empId = rs.getInt(1);
        String empName = rs.getString(2);
        var empAge= rs.getInt(3);
        var addressId= rs.getInt(4);
        var role= rs.getString(5);
        Role curentRole=null;
        if(role!=null){
           curentRole=Role.valueOf(role);
        }
        Address address = new Address();
        address.setAddressId(addressId);
        return new Employee(empId,empName,empAge,address,curentRole );

    }
}
