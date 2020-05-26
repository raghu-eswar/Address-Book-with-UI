package com.addressBook.jsonData;

import java.util.LinkedHashMap;
import java.util.Map;

public class AddressBook {
    public String bookName;
    public Map<String, PersonInfo> personsData;

    public AddressBook(String bookName) {
        this.bookName = bookName;
        this.personsData = new LinkedHashMap<>();
    }
    public AddressBook(String bookName, AddressBook addressBook) {
        this.bookName = bookName;
        this.personsData = addressBook.personsData;
    }

    public void addNewPerson(PersonInfo personInfo) {
        this.personsData.put(personInfo.phoneNumber, personInfo);
    }

    public void editPersonInfo(String personPhoneNo, PersonDTO personDTO) {
        personsData.get(personPhoneNo).resetData(personDTO);
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "bookName='" + bookName + '\'' +
                ", personsData=" + personsData +
                '}';
    }

    public void remove(String phoneNo) {
        this.personsData.remove(phoneNo);
    }
}
