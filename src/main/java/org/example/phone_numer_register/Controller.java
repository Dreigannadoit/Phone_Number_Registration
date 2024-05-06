package org.example.phone_numer_register;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigInteger;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable, UserInputs {
    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> firstNameColumn;
    @FXML private TableColumn<Person, String> lastNameColumn;
    @FXML private TableColumn<Person, BigInteger> phoneNumColumn;

    //These instance variables are used to create new Person objects
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField phoneNumField;

    private Person selectedPerson; // To store the selected person for editing
    private final CustumeAlerts alertMsg = new CustumeAlerts();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // set up columns in the tables
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneNumColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));

        // load dummy data
        tableView.setItems(getPeople());
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // allow user to select multiple rows
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @Override
    public void addUserInput() {
        alertMsg.checkEmptyInput(selectedPerson, firstNameTextField, lastNameTextField, phoneNumField);
        alertMsg.checkInvalidMobileNum(phoneNumField);

        // Create new instance of Person object with user input arguments
        Person newPerson = new Person(firstNameTextField.getText(),
                lastNameTextField.getText(),
                phoneNumField.getText());

        // Get all the items from the table as a list, then add the new person to the list
        tableView.getItems().add(newPerson);
    }

    @Override
    public void editRow() {
        // get selected row
        ObservableList<Person> selectedRows = tableView.getSelectionModel().getSelectedItems();

        if (!selectedRows.isEmpty()) {
            selectedPerson = selectedRows.get(0); // Assuming only one row can be edited at a time
            firstNameTextField.setText(selectedPerson.getFirstName());
            lastNameTextField.setText(selectedPerson.getLastName());
            phoneNumField.setText(selectedPerson.getPhoneNum().toString());
        }
    }

    @Override
    public void deleteRow() {
        // Get the selected rows
        ObservableList<Person> selectedRows = tableView.getSelectionModel().getSelectedItems();
        // Remove the selected rows from the table view's items
        tableView.getItems().removeAll(selectedRows);
        // Clear the selection to avoid confusion
        tableView.getSelectionModel().clearSelection();
    }


    @Override
    public void saveAsUpdatedRow() {
        alertMsg.checkEmptyInput(selectedPerson, firstNameTextField, lastNameTextField, phoneNumField);
        alertMsg.checkInvalidMobileNum(phoneNumField);

        // Update selected person's data
        selectedPerson.setFirstName(new SimpleStringProperty(firstNameTextField.getText()));
        selectedPerson.setLastName(new SimpleStringProperty(lastNameTextField.getText()));
        selectedPerson.setPhoneNum(new BigInteger(phoneNumField.getText()));

        // Refresh the table view to reflect changes
        tableView.refresh();
    }

    @Override
    public void clearUserInput() {
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        phoneNumField.setText("");
    }

    public ObservableList<Person> getPeople() {
        // adding test data to the list
        ObservableList<Person> people = FXCollections.observableArrayList();
        people.add(new Person("TestFirstName", "TestLastName", "0502115825"));
        people.add(new Person("John", "Doe", "23904720345"));

        return people;
    }
}