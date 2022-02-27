package com.pharmacy_management.pharmacy_manager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ManagerController {
    @FXML
    private Label lblSetUseMr,lblStoreId;
//    public void logO(ActionEvent e){
//        LoginModel.logOut(e);
//
//    }

    public void setUse(String user, String store) {
        lblSetUseMr.setText(user);
        lblStoreId.setText(store);
    }
}
