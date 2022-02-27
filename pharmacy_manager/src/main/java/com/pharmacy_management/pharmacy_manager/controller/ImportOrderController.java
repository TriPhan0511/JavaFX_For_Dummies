package com.pharmacy_management.pharmacy_manager.controller;

import com.pharmacy_management.pharmacy_manager.map.Employee;
import com.pharmacy_management.pharmacy_manager.map.ImportOrder;
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

public class ImportOrderController implements Initializable {
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
    private TableView<ImportOrder> importOrderTableView;
    @FXML
    private TableColumn<ImportOrder, String> columnImportOrderId, columnSupplierId, columnStoreId, columnEmployeeId, columnCreateDate;
    @FXML
    private TextField searchImpOrTextfield;
    private ObservableList<ImportOrder> importOrderObservableList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<ImportOrder> arr = new ArrayList<>();
        try {
            arr=new ImportOrder().importOrders();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        importOrderObservableList = FXCollections.observableArrayList(arr);
        columnImportOrderId.setCellValueFactory(new PropertyValueFactory<>("importOrder_id"));
        columnSupplierId.setCellValueFactory(new PropertyValueFactory<>("supplier_id"));
        columnStoreId.setCellValueFactory(new PropertyValueFactory<>("store_id"));
        columnEmployeeId.setCellValueFactory(new PropertyValueFactory<>("employee_id"));
        columnCreateDate.setCellValueFactory(new PropertyValueFactory<>("create_date"));
        importOrderTableView.setItems(importOrderObservableList);

        FilteredList<ImportOrder> filteredList =   new FilteredList<>(importOrderObservableList, b->true);
        searchImpOrTextfield.textProperty().addListener((observable,oldValue,newValue)->{
            filteredList.setPredicate(importOrderObservableList->{
                if(newValue.isEmpty() || newValue.isBlank()){
                    return true;
                }
                String searchImpOr=newValue.toLowerCase();
                if(importOrderObservableList.getImportOrder_id().toLowerCase().indexOf(searchImpOr)>-1){
                    return true;
                }
                if(importOrderObservableList.getSupplier_id().toLowerCase().indexOf(searchImpOr)>-1){
                    return true;
                }
                if(importOrderObservableList.getStore_id().toLowerCase().indexOf(searchImpOr)>-1){
                    return true;
                }
                if(importOrderObservableList.getEmployee_id().toLowerCase().indexOf(searchImpOr)>-1){
                    return true;
                }
                else return importOrderObservableList.getCreate_date().toLowerCase().indexOf(searchImpOr) > -1;
            });
        });
        SortedList<ImportOrder> sortedList=new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(importOrderTableView.comparatorProperty());

        importOrderTableView.setItems(sortedList);
    }
}
