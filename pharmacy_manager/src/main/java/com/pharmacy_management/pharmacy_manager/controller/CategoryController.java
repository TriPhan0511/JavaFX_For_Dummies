package com.pharmacy_management.pharmacy_manager.controller;

import com.pharmacy_management.pharmacy_manager.map.Category;
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

public class CategoryController implements Initializable {
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
    private TableView<Category> categoryTableView;
    @FXML
    private TableColumn<Employee, String> columnId, columnName;
    @FXML
    private TextField searchCatTextfield;
    private ObservableList<Category> categoryObservableList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Category> arr = new ArrayList<>();
        try {
            arr=new Category().categories();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        categoryObservableList = FXCollections.observableArrayList(arr);
        columnId.setCellValueFactory(new PropertyValueFactory<>("categoryID"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        categoryTableView.setItems(categoryObservableList);

        FilteredList<Category> filteredList =   new FilteredList<>(categoryObservableList, b->true);
        searchCatTextfield.textProperty().addListener((observable,oldValue,newValue)->{
            filteredList.setPredicate(categoryObservableList->{
                if(newValue.isEmpty() || newValue.isBlank()){
                    return true;
                }
                String searchCus=newValue.toLowerCase();
                if(categoryObservableList.getCategoryID().toLowerCase().indexOf(searchCus)>-1){
                    return true;
                }
                else return categoryObservableList.getCategoryName().toLowerCase().indexOf(searchCus) > -1;
            });
        });
        SortedList<Category> sortedList=new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(categoryTableView.comparatorProperty());

        categoryTableView.setItems(sortedList);
    }
}
