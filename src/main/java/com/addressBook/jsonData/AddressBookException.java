package com.addressBook.jsonData;

public class AddressBookException extends Throwable {
   enum  ExceptionType {
       NO_ADDRESS_BOOK,FILE_PROBLEM, DUEPLICATE_NAME;
   }
    ExceptionType type;
    public AddressBookException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
