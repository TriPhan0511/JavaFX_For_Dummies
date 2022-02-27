package com.pharmacy_management.pharmacy_manager.models;

import com.pharmacy_management.pharmacy_manager.LoginApplication;
import com.pharmacy_management.pharmacy_manager.controller.*;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Border;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangeGUI {
    //change Scene
    public  void changeScene(Event event, String title, String FxmlFile, String User, String store) {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource(FxmlFile));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = null;
        if (root != null) {
            scene = new Scene(root);
        }
        if(FxmlFile.equals("suppervisor.fxml")){
            SuppervisorController controller=fxmlLoader.getController();
            controller.setUse(User,store);

        }
        if(FxmlFile.equals("employeeManagement.fxml")){
            EmployeeManagementController controller=fxmlLoader.getController();
            controller.setUse(User,store);

        }
//        if(FxmlFile.equals("importsystem.fxml")){
//            ImportSystemController controller=fxmlLoader.getController();
//            controller.setUse(User,store);
//
//        }
        if(FxmlFile.equals("employeeList.fxml")){
            EmployeeListController controller=fxmlLoader.getController();
            controller.setUse(User,store);

        }
        if(FxmlFile.equals("supplierList.fxml")){
            SupplierController controller=fxmlLoader.getController();
            controller.setUse(User,store);

        }
        if(FxmlFile.equals("categoryList.fxml")){
            CategoryController controller=fxmlLoader.getController();
            controller.setUse(User,store);
        }
        if(FxmlFile.equals("productList.fxml")){
            ProductController controller=fxmlLoader.getController();
            controller.setUse(User,store);

        }

        if(FxmlFile.equals("importOrderList.fxml")){
            ImportOrderController controller=fxmlLoader.getController();
            controller.setUse(User,store);

        }
        if(FxmlFile.equals("customerList.fxml")){
            CustomerController controller=fxmlLoader.getController();
            controller.setUse(User,store);

        }
        if(FxmlFile.equals("stockList.fxml")){
            StockController controller=fxmlLoader.getController();
            controller.setUse(User,store);

        }
        if(FxmlFile.equals("storeList.fxml")){
            StoreController controller=fxmlLoader.getController();
            controller.setUse(User,store);

        }
        if(FxmlFile.equals("importOrderDetailList.fxml")){
            ImportOrderDetailController controller=fxmlLoader.getController();
            controller.setUse(User,store);

        }
        if(FxmlFile.equals("manager.fxml")){
            ManagerController controller=fxmlLoader.getController();
            controller.setUse(User,store);
        }
        if(FxmlFile.equals("staff.fxml")){
            StaffController controller=fxmlLoader.getController();
            controller.setUse(User,store);
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
    //Change Combobox
    public void comboboxChange(ComboBox cbx){
        cbx.getValue();
    }


    //change property Button
    public  void changeProButton(Button btn){
        btn.setBorder(Border.EMPTY);
    }

    //setLogOutButton
    public void SetBtnLogout(Event event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("log_in.fxml"));
        Parent root= null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = null;
        if (root != null) {
            scene = new Scene(root);
        }
        stage.setTitle("PharmacyManagement Login System!");
        stage.setScene(scene);
        stage.show();
    }
}