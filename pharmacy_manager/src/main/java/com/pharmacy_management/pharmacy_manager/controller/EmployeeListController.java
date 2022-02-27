package com.pharmacy_management.pharmacy_manager.controller;

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

public class EmployeeListController implements Initializable {
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
    private TableView<Employee> employeeListTableview;
    @FXML
    private TableColumn<Employee, String> columnId, columnFisrtname, columnLastname, columnGender, columnEmail, columnPhone, columnAdderss;
    @FXML
    private TextField searchEmpTextfield;
    private ObservableList<Employee> employeeObservableList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Employee> arr = new ArrayList<>();
        try {
            arr=new Employee().employees();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        employeeObservableList = FXCollections.observableArrayList(arr);
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnFisrtname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        columnLastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        columnGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        columnAdderss.setCellValueFactory(new PropertyValueFactory<>("address"));
        employeeListTableview.setItems(employeeObservableList);

        FilteredList<Employee> filteredList =   new FilteredList<>(employeeObservableList, b->true);
        searchEmpTextfield.textProperty().addListener((observable,oldValue,newValue)->{
            filteredList.setPredicate(employeeObservableList->{
                if(newValue.isEmpty() || newValue.isBlank()){
                    return true;
                }
                String searchEmp=newValue.toLowerCase();
                if(employeeObservableList.getId().toLowerCase().indexOf(searchEmp)>-1){
                    return true;
                }
                if(employeeObservableList.getFirstName().toLowerCase().indexOf(searchEmp)>-1){
                    return true;
                }
                else return employeeObservableList.getLastName().toLowerCase().indexOf(searchEmp) > -1;
            });
        });
        SortedList<Employee> sortedList=new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(employeeListTableview.comparatorProperty());

        employeeListTableview.setItems(sortedList);
    }
}
