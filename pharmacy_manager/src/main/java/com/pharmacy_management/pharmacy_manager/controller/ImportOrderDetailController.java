package com.pharmacy_management.pharmacy_manager.controller;
import com.pharmacy_management.pharmacy_manager.map.ImportOrderDetail;
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

public class ImportOrderDetailController implements Initializable {
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
    private TableView<ImportOrderDetail> importOrderDetailTableView;
    @FXML
    private TableColumn<ImportOrderDetail, String> columnImportOrderId, columnProductId, columnQuantity, columnImportPrice;
    @FXML
    private TextField searchImpOrDeTextfield;
    private ObservableList<ImportOrderDetail> importOrderDetailObservableList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<ImportOrderDetail> arr = new ArrayList<>();
        try {
            arr=new ImportOrderDetail().importOrderDetails();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        importOrderDetailObservableList = FXCollections.observableArrayList(arr);
        columnImportOrderId.setCellValueFactory(new PropertyValueFactory<>("importOrder_id"));
        columnProductId.setCellValueFactory(new PropertyValueFactory<>("product_id"));
        columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columnImportPrice.setCellValueFactory(new PropertyValueFactory<>("import_price"));
        importOrderDetailTableView.setItems(importOrderDetailObservableList);

        FilteredList<ImportOrderDetail> filteredList =   new FilteredList<>(importOrderDetailObservableList, b->true);
        searchImpOrDeTextfield.textProperty().addListener((observable,oldValue,newValue)->{
            filteredList.setPredicate(importOrderDetailObservableList->{
                if(newValue.isEmpty() || newValue.isBlank()){
                    return true;
                }
                String searchImpOr=newValue.toLowerCase();
                if(importOrderDetailObservableList.getImportOrder_id().toLowerCase().indexOf(searchImpOr)>-1){
                    return true;
                }
                else return importOrderDetailObservableList.getProduct_id().toLowerCase().indexOf(searchImpOr) > -1;
            });
        });
        SortedList<ImportOrderDetail> sortedList=new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(importOrderDetailTableView.comparatorProperty());

        importOrderDetailTableView.setItems(sortedList);
    }
}
