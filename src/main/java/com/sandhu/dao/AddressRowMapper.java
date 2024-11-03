package com.sandhu.dao;

import com.sandhu.Entities.Address;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AddressRowMapper implements RowMapper<Address> {
    @Override
    public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
        var addressId=rs.getInt(1);
        var houseNo = rs.getString(2);
        var streetNo = rs.getString(3);
        var streetName = rs.getString(4);
        return new Address(addressId,houseNo,streetNo,streetName);

    }
}
