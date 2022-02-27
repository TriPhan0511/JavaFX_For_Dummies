package com.pharmacy_management.pharmacy_manager.controller;

import com.pharmacy_management.pharmacy_manager.map.Customer;
import com.pharmacy_management.pharmacy_manager.map.Employee;
import com.pharmacy_management.pharmacy_manager.models.ChangeGUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {
    @FXML
    private Label userEmpLabel,store_idEmpLabel;

    public void setUse(String user, String store) {
        userEmpLabel.setText(user);
        store_idEmpLabel.setText(store);
    }
    public void  setLogOutButton(ActionEvent event){
        new ChangeGUI().SetBtnLogout(event);
    }

    public void setBackButton(ActionEvent event) {
        new ChangeGUI().changeScene(event, "Welcome to the BETTER LIFE PHARMACY Application", "suppervisor.fxml", userEmpLabel.getText(), store_idEmpLabel.getText());
    }
    @FXML
    private TableView<Customer> customerTableView;
    @FXML
    private TableColumn<Employee, String> columnId, columnFisrtname, columnLastname, columnGender, columnEmail, columnPhone, columnAdderss,columnZipcode;
    @FXML
    private TextField searchCusTextfield;
    private ObservableList<Customer> customerObservableList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Customer> arr = new ArrayList<>();
        try {
            arr=new Customer().customers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        customerObservableList = FXCollections.observableArrayList(arr);
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnFisrtname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        columnLastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        columnGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        columnAdderss.setCellValueFactory(new PropertyValueFactory<>("address"));
        columnZipcode.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        customerTableView.setItems(customerObservableList);

        FilteredList<Customer> filteredList =   new FilteredList<>(customerObservableList, b->true);
        searchCusTextfield.textProperty().addListener((observable,oldValue,newValue)->{
            filteredList.setPredicate(customerObservableList->{
                if(newValue.isEmpty() || newValue.isBlank()){
                    return true;
                }
                String searchCus=newValue.toLowerCase();
                if(customerObservableList.getId().toLowerCase().indexOf(searchCus)>-1){
                    return true;
                }
                if(customerObservableList.getFirstName().toLowerCase().indexOf(searchCus)>-1){
                    return true;
                }
                else return customerObservableList.getLastName().toLowerCase().indexOf(searchCus) > -1;
            });
        });
        SortedList<Customer> sortedList=new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(customerTableView.comparatorProperty());

        customerTableView.setItems(sortedList);
    }
}
