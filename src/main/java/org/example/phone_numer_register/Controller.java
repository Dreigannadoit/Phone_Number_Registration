package org.example.phone_numer_register;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.math.BigInteger;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> firstNameColumn;
    @FXML private TableColumn<Person, String> lastNameColumn;
    @FXML private TableColumn<Person, String> phoneNumColumn;

    //These instance variables are used to create new Person objects
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField phoneNumField;

    /**
     * Setting up table
     **/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // set up columns in the tables
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        phoneNumColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("phoneNum"));

        // load dummy data
        tableView.setItems(getPeople());
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public ObservableList<Person> getPeople()
    {
        ObservableList<Person> people = FXCollections.observableArrayList();
        people.add(new Person("Rebecca", "Fergusson", "0502115825"));
        people.add(new Person("John", "Doe", "23904720345"));
        people.add(new Person("John", "Mary", "3453453454"));
        people.add(new Person("Rebecca", "Fergusson", "0502115825"));
        people.add(new Person("John", "Doe", "23904720345"));
        people.add(new Person("John", "Mary", "3453453454"));

        return people;
    }
}