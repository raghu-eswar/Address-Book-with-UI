package com.addressBook.jsonData;

public class PersonInfo {
    String firstName;
    String lastName;
    String phoneNumber;
    Address address;

    public PersonInfo(String firstName, String lastName, String phoneNumber, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonInfo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
                '}';
    }

    public void resetData(PersonDTO personDTO) {
        this.firstName = personDTO.firstName;
        this.lastName = personDTO.lastName;
        this.phoneNumber = personDTO.phoneNumber;
        this.address = new Address(personDTO.address);
    }
}
