package org.example.phone_numer_register;

import javafx.beans.property.SimpleStringProperty;
import java.math.BigInteger;

public class Person {
    private SimpleStringProperty firstName, lastName;
    private BigInteger phoneNum;

    public Person(String firstName, String lastName, String phoneNum) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.phoneNum = new BigInteger(phoneNum);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(SimpleStringProperty firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(SimpleStringProperty lastName) {
        this.lastName = lastName;
    }

    public BigInteger getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(BigInteger phoneNum) {
        this.phoneNum = phoneNum;
    }


}