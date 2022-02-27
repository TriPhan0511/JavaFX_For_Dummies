package com.pharmacy_management.pharmacy_manager.controller;

import com.pharmacy_management.pharmacy_manager.models.ChangeGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class SuppervisorController {
    @FXML
    private Button profileButton,logOutButton,employeeButton,superlierButton,categoryButton,productButton,importOrderButton,
                    customerButton,stockButton,storeButton,importOderDetailButton,importSystemButton,employeeSystemButton;
    @FXML
    Label store_idLabel,userLabel;

    public void setUse(String user,String store){
        userLabel.setText(user);
        store_idLabel.setText(store);
    }

    public void setHoverButton(MouseEvent me){
        if(me.getSource()==profileButton) new ChangeGUI().changeProButton(profileButton);
        if(me.getSource()==logOutButton) new ChangeGUI().changeProButton(logOutButton);
        if(me.getSource()==employeeButton) new ChangeGUI().changeProButton(employeeButton);
        if(me.getSource()==superlierButton) new ChangeGUI().changeProButton(superlierButton);
        if(me.getSource()==categoryButton) new ChangeGUI().changeProButton(categoryButton);
        if(me.getSource()==productButton) new ChangeGUI().changeProButton(productButton);
        if(me.getSource()==importOrderButton) new ChangeGUI().changeProButton(importOrderButton);
        if(me.getSource()==customerButton) new ChangeGUI().changeProButton(customerButton);
        if(me.getSource()==stockButton) new ChangeGUI().changeProButton(stockButton);
        if(me.getSource()==storeButton) new ChangeGUI().changeProButton(storeButton);
        if(me.getSource()==importOderDetailButton) new ChangeGUI().changeProButton(importOderDetailButton);
        if(me.getSource()==importSystemButton) new ChangeGUI().changeProButton(importSystemButton);
        if(me.getSource()==employeeSystemButton) new ChangeGUI().changeProButton(employeeSystemButton);
    }

    public void  setLogOutButton(ActionEvent event){
        new ChangeGUI().SetBtnLogout(event);
    }

    public void setChangeSceneButton(ActionEvent event){
        if (event.getSource()==employeeSystemButton) new ChangeGUI().changeScene(event,"Welcome to the BETTER LIFE PHARMACY Application","employeeManagement.fxml",userLabel.getText().trim(),store_idLabel.getText().trim());
        if (event.getSource()==importSystemButton) new ChangeGUI().changeScene(event,"Welcome to the BETTER LIFE PHARMACY Application","importsystem.fxml",userLabel.getText().trim(),store_idLabel.getText().trim());
        if (event.getSource()==employeeButton) new ChangeGUI().changeScene(event,"Welcome to the BETTER LIFE PHARMACY Application","employeeList.fxml",userLabel.getText().trim(),store_idLabel.getText().trim());
        if (event.getSource()==superlierButton) new ChangeGUI().changeScene(event,"Welcome to the BETTER LIFE PHARMACY Application","supplierList.fxml",userLabel.getText().trim(),store_idLabel.getText().trim());
        if (event.getSource()==categoryButton) new ChangeGUI().changeScene(event,"Welcome to the BETTER LIFE PHARMACY Application","categoryList.fxml",userLabel.getText().trim(),store_idLabel.getText().trim());
        if (event.getSource()==productButton) new ChangeGUI().changeScene(event,"Welcome to the BETTER LIFE PHARMACY Application","productList.fxml",userLabel.getText().trim(),store_idLabel.getText().trim());
        if (event.getSource()==importOrderButton) new ChangeGUI().changeScene(event,"Welcome to the BETTER LIFE PHARMACY Application","importOrderList.fxml",userLabel.getText().trim(),store_idLabel.getText().trim());
        if (event.getSource()==customerButton) new ChangeGUI().changeScene(event,"Welcome to the BETTER LIFE PHARMACY Application","customerList.fxml",userLabel.getText().trim(),store_idLabel.getText().trim());
        if (event.getSource()==stockButton) new ChangeGUI().changeScene(event,"Welcome to the BETTER LIFE PHARMACY Application","stockList.fxml",userLabel.getText().trim(),store_idLabel.getText().trim());
        if (event.getSource()==storeButton) new ChangeGUI().changeScene(event,"Welcome to the BETTER LIFE PHARMACY Application","storeList.fxml",userLabel.getText().trim(),store_idLabel.getText().trim());
        if (event.getSource()==importOderDetailButton) new ChangeGUI().changeScene(event,"Welcome to the BETTER LIFE PHARMACY Application","importOrderDetailList.fxml",userLabel.getText().trim(),store_idLabel.getText().trim());
    }

}



