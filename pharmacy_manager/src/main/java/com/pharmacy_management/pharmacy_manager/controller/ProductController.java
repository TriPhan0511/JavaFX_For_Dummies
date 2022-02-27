package com.pharmacy_management.pharmacy_manager.controller;

import com.pharmacy_management.pharmacy_manager.map.ImportOrderDetail;
import com.pharmacy_management.pharmacy_manager.map.Product;
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

public class ProductController implements Initializable {
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
    private TableView<Product> productTableView;
    @FXML
    private TableColumn<Product, String> columnProductId, columnProductName, columnPrice, columnExpirationDate,columnUnit,columnCategoryId;
    @FXML
    private TextField searchProductTextfield;
    private ObservableList<Product> productObservableList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Product> arr = new ArrayList<>();
        try {
            arr=new Product().products();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        productObservableList = FXCollections.observableArrayList(arr);
        columnProductId.setCellValueFactory(new PropertyValueFactory<>("product_id"));
        columnProductName.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        columnExpirationDate.setCellValueFactory(new PropertyValueFactory<>("expirationDate"));
        columnUnit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        columnCategoryId.setCellValueFactory(new PropertyValueFactory<>("category"));
        productTableView.setItems(productObservableList);

        FilteredList<Product> filteredList =   new FilteredList<>(productObservableList, b->true);
        searchProductTextfield.textProperty().addListener((observable,oldValue,newValue)->{
            filteredList.setPredicate(productObservableList->{
                if(newValue.isEmpty() || newValue.isBlank()){
                    return true;
                }
                String searchProduct=newValue.toLowerCase();
                if(productObservableList.getProduct_id().toLowerCase().indexOf(searchProduct)>-1){
                    return true;
                }
                if(productObservableList.getProduct_name().toLowerCase().indexOf(searchProduct)>-1){
                    return true;
                }
                if(productObservableList.getExpirationDate().toLowerCase().indexOf(searchProduct)>-1){
                    return true;
                }
                else return productObservableList.getCategory().toLowerCase().indexOf(searchProduct) > -1;
            });
        });
        SortedList<Product> sortedList=new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(productTableView.comparatorProperty());
        productTableView.setItems(sortedList);
    }
}
