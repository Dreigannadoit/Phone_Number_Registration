package org.example.phone_numer_register;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.math.BigInteger;

public class CustumeAlerts {
    public Alert checkEmptyInput(Person selectedPerson,  TextField firstNameTextField, TextField lastNameTextField, TextField phoneNumField) {
        // Check if selectedPerson is null or any of the text fields are empty
        if (
                ( selectedPerson == null && firstNameTextField.getText().isEmpty() ) ||
                ( selectedPerson == null && lastNameTextField.getText().isEmpty() ) ||
                ( selectedPerson == null && phoneNumField.getText().isEmpty() ) ||
                ( firstNameTextField.getText().isEmpty() ) ||
                ( lastNameTextField.getText().isEmpty() )||
                ( phoneNumField.getText().isEmpty() )
        ) {
            // Show an alert for incomplete data
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incomplete Data");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return alert; // Exit the method
        }

        return null;
    }

    public Alert checkInvalidMobileNum(TextField phoneNumField) {
        // Check if the phone number is a valid BigInteger
        try {
            new BigInteger(phoneNumField.getText());
        } catch (NumberFormatException e) {
            // If it's not a valid number, show an alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Phone number must be a valid number.");
            alert.showAndWait();
            return alert;// Exit the method
        }

        return null;
    }
}
