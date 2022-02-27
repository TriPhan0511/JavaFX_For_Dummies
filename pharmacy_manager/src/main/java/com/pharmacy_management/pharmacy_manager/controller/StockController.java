package com.pharmacy_management.pharmacy_manager.controller;

import com.pharmacy_management.pharmacy_manager.map.Product;
import com.pharmacy_management.pharmacy_manager.map.Stock;
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

public class StockController implements Initializable {
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
    private TableView<Stock> stockTableView;
    @FXML
    private TableColumn<Stock, String> columnStoreId, columnProductId, columnQuantity;
    @FXML
    private TextField searchStockTextfield;
    private ObservableList<Stock> stockObservableList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Stock> arr = new ArrayList<>();
        try {
            arr=new Stock().stocks();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        stockObservableList = FXCollections.observableArrayList(arr);
        columnStoreId.setCellValueFactory(new PropertyValueFactory<>("store_id"));
        columnProductId.setCellValueFactory(new PropertyValueFactory<>("product_id"));
        columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        stockTableView.setItems(stockObservableList);

        FilteredList<Stock> filteredList =   new FilteredList<>(stockObservableList, b->true);
        searchStockTextfield.textProperty().addListener((observable,oldValue,newValue)->{
            filteredList.setPredicate(stockObservableList->{
                if(newValue.isEmpty() || newValue.isBlank()){
                    return true;
                }
                String searchStock=newValue.toLowerCase();
                if(stockObservableList.getStore_id().toLowerCase().indexOf(searchStock)>-1){
                    return true;
                }
                if(stockObservableList.getProduct_id().toLowerCase().indexOf(searchStock)>-1){
                    return true;
                }
                else return String.valueOf(stockObservableList.getQuantity()).toLowerCase().indexOf(searchStock) > -1;
            });
        });
        SortedList<Stock> sortedList=new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(stockTableView.comparatorProperty());
        stockTableView.setItems(sortedList);
    }
}
