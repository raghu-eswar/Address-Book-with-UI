package com.addressBook.jsonData;

public class Address {
    String city;
    String state;
    String zip;

    public Address(String city, String state, String zip) {
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Address(AddressDTO address) {
        this(address.city, address.state, address.zip);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
