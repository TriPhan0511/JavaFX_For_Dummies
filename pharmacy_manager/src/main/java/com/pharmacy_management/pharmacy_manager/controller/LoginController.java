package com.pharmacy_management.pharmacy_manager.controller;

import com.pharmacy_management.pharmacy_manager.models.ChangeGUI;
import com.pharmacy_management.pharmacy_manager.models.LoginModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class LoginController {
    @FXML
    private TextField txtUse;
    @FXML
    private PasswordField pwdPas;
    @FXML
    private Label lblShoUse;
    @FXML
    private Label lblShoPas;
    @FXML
    private CheckBox cbxSho;
    @FXML
    private TextField txtPas;
    @FXML
    private Button btnLog;
    @FXML
    private Button btnRes;
    public void login(ActionEvent event){
        String use=txtUse.getText();
        String pas=pwdPas.getText();
        if (cbxSho.isSelected()) {pas=txtPas.getText();}
        if(use.isEmpty()){lblShoUse.setText("* Username is not empty!\n");
                            txtUse.requestFocus();                        }
            else {  lblShoUse.setText("");}
        if(pas.isEmpty()){lblShoPas.setText("* Password is not empty!\n");
                            pwdPas.requestFocus();                          }
            else {lblShoPas.setText("");}
        if(!use.equals("")&!pas.equals("")){
            LoginModel.loginUser(event,use,pas,lblShoUse,lblShoPas,txtUse,txtPas);
        }

    }
    public void showPas(){
        if(cbxSho.isSelected()){
            txtPas.setDisable(false);
            pwdPas.setDisable(true);
            txtPas.setText(pwdPas.getText());
            pwdPas.setText("");


        }
        if(!cbxSho.isSelected()){
            pwdPas.setText(txtPas.getText());
            txtPas.setText("");
            pwdPas.setDisable(false);
            txtPas.setDisable(true);
        }

    }
    public void change(MouseEvent m){
        if(m.getSource()==btnLog){ new ChangeGUI().changeProButton(btnLog);}
        if(m.getSource()==btnRes){ new ChangeGUI().changeProButton(btnRes);}

    }
    public void reset(){
        new LoginModel().setEmtyTextfield(txtUse,txtPas,pwdPas);
        txtUse.requestFocus();
    }
    public void keyE(KeyEvent e){
        if(e.getCode().toString().equals("ENTER")) {
            btnLog.getOnAction();
            btnRes.getOnAction();
        }
    }
    public void key(KeyEvent e){
        if(e.getCode().equals(KeyCode.ENTER)) {

            String use=txtUse.getText();
            String pas=pwdPas.getText();
            if (cbxSho.isSelected()) {pas=txtPas.getText();}
            if(use.isEmpty()){lblShoUse.setText("* Username is not empty!\n");
                txtUse.requestFocus();                        }
            else {  lblShoUse.setText("");}
            if(pas.isEmpty()){lblShoPas.setText("* Password is not empty!\n");
                pwdPas.requestFocus();                          }
            else {lblShoPas.setText("");}
            if(!use.equals("")&!pas.equals("")){
                lblShoPas.setText("");
                lblShoUse.setText("");
                LoginModel.loginUser(e,use,pas,lblShoUse,lblShoPas,txtUse,txtPas);
            }
       }
    }

}
