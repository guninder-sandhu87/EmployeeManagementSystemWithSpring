package com.sandhu.Entities;

public class Address {
    private int addressId;
    private String houseNo;
    private String streetNo;
    private String streetName;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Override
    public String toString() {
        return  "houseNo='" + houseNo + '\'' +
                ", streetNo='" + streetNo + '\'' +
                ", streetName='" + streetName + '\'' +
                '}';
    }
}
