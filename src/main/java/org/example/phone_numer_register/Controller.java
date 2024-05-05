package org.example.phone_numer_register;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.math.BigInteger;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable, UserInputs {
    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> firstNameColumn;
    @FXML private TableColumn<Person, String> lastNameColumn;
    @FXML private TableColumn<Person, String> phoneNumColumn;

    //These instance variables are used to create new Person objects
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField phoneNumField;

    private Person selectedPerson; // To store the selected person for editing
    /**
     * Setting the table
     **/
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
    public void addColumn() {
        Person newPerson = new Person(firstNameTextField.getText(),
                lastNameTextField.getText(),
                phoneNumField.getText());

        //Get all the items from the table as a list, then add the new person to
        //the list
        tableView.getItems().add(newPerson);
    }

    @Override
    public void editColumn() {
        // get row
        ObservableList<Person> selectedRows = tableView.getSelectionModel().getSelectedItems();

        if (!selectedRows.isEmpty()) {
            selectedPerson = selectedRows.get(0); // Assuming only one row can be edited at a time
            firstNameTextField.setText(selectedPerson.getFirstName().toString());
            lastNameTextField.setText(selectedPerson.getLastName().toString());
            phoneNumField.setText(selectedPerson.getPhoneNum().toString());
        }
    }

    @Override
    public void deleteColumn() {
        ObservableList<Person> selectedRows, allPeople;
        allPeople = tableView.getItems();

        // this gives us the rows that were selected
        selectedRows = tableView.getSelectionModel().getSelectedItems();

        for (Person person: selectedRows) {
            allPeople.remove(person);
        }
    }

    @Override
    public void saveColumn() {
        // save new data into its respective column
        if (selectedPerson != null) {
            selectedPerson.setFirstName(new SimpleStringProperty(firstNameTextField.getText()));
            selectedPerson.setLastName(new SimpleStringProperty(lastNameTextField.getText()));
            selectedPerson.setPhoneNum(new SimpleStringProperty(phoneNumField.getText()));
            tableView.refresh(); // Refresh the table view to reflect changes
        }
    }

    @Override
    public void clearColumn() {
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        phoneNumField.setText("");
    }

    public ObservableList<Person> getPeople()
    {
        ObservableList<Person> people = FXCollections.observableArrayList();
        people.add(new Person("Rebecca", "Fergusson", "0502115825"));
        people.add(new Person("John", "Doe", "23904720345"));

        return people;
    }
}