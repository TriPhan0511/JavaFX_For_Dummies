package com.pharmacy_management.pharmacy_manager.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StaffController {
    @FXML
    private Label lblSetUseSf,lblStore;
//    public void logO(ActionEvent e){
//        LoginModel.logOut(e);
//    }
public void setUse(String user, String store) {
    lblSetUseSf.setText(user);
    lblStore.setText(store);
}

}
