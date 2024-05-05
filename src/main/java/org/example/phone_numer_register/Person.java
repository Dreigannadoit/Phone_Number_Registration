package org.example.phone_numer_register;

import javafx.beans.property.SimpleStringProperty;
import java.math.BigInteger;

public class Person {
    private SimpleStringProperty firstName, lastName, phoneNum;

    public Person(String firstName, String lastName, String phoneNum) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.phoneNum = new SimpleStringProperty(phoneNum);
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

    public String getPhoneNum() {
        return phoneNum.get();
    }

    public void setPhoneNum(SimpleStringProperty phoneNum) {
        this.phoneNum = phoneNum;
    }


}