package com.pharmacy_management.pharmacy_manager.model;

import com.pharmacy_management.pharmacy_manager.LoginApplication;
import com.pharmacy_management.pharmacy_manager.controller.StaffController;
import com.pharmacy_management.pharmacy_manager.controller.SupervisorController;
import com.pharmacy_management.pharmacy_manager.model.DB_DAO;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.pharmacy_management.pharmacy_manager.controller.ManagerController;

import java.io.IOException;
import java.sql.*;

public class LoginModels {

    public static void changeScene(Event event, String title, String FxmlFile,String User) {
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
        if(FxmlFile.equals("supervisor.fxml")){
            SupervisorController controller=fxmlLoader.getController();
            controller.setUse(User);
        }
        if(FxmlFile.equals("manager.fxml")){
            ManagerController controller=fxmlLoader.getController();
            controller.setUse(User);
        }
        if(FxmlFile.equals("staff.fxml")){
            StaffController controller=fxmlLoader.getController();
            controller.setUse(User);
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
    public static void logOut(Event event){
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
   public void setEmtyTextfield(TextField...textFields){
       for (TextField txt:textFields) {
           txt.setText("");
       }
   }

    public static void loginUser(Event event, String userName, String passWord, Label lblUse, Label lblPas, TextField txtUse,TextField txtPas) {
        DB_DAO db                = new DB_DAO();
        Connection con           = db.getConn();
        PreparedStatement pstm   = null;
        ResultSet rs             = null;
        CallableStatement stmt   = null;
        ResultSet rsMan          = null;
        CallableStatement stmtS  = null;
        ResultSet rsS            = null;

        String sql               = "select password from employee where employee_id=?";
        try {
            pstm                 = con.prepareStatement(sql);
            pstm.setString(1, userName);
            rs                   = pstm.executeQuery();
            if (!rs.isBeforeFirst()) {
                System.out.println("user not found is the database!");
                lblUse.setText("User is incorrect!");
                txtUse.requestFocus();
            }
            else {
                String queryCal  = "{call sp_getManager_Id(?)}";
                stmt             = con.prepareCall(queryCal);
                stmt.setString(1, userName);
                rsMan            = stmt.executeQuery();
                if (!rsMan.isBeforeFirst()) {
                    String queryCalS = "{call sp_getSupervisor_Id(?)}";
                    stmtS            = con.prepareCall(queryCalS);
                    stmtS.setString(1, userName);
                    rsS              = stmtS.executeQuery();
                    if (rsS.isBeforeFirst()) {
                        while (rsS.next()) {
                            String retrievePassword = rsS.getString("password");
                            if (retrievePassword.equals(passWord)) {
                                changeScene(event, "Welcome to the BETTER lIFE PHARMACY Application " , "supervisor.fxml",userName);
                            } else {
                                lblPas.setText("Incorrect password!");
                                txtPas.requestFocus();
                            }
                        }
                    }
                    else  while (rs.next()) {
                        String retrievePassword = rs.getString("password");
                        if (retrievePassword.equals(passWord)) {
                            changeScene(event, "\"Welcome to the BETTER lIFE PHARMACY Application  ", "staff.fxml",userName);

                        }

                        else {
                            lblPas.setText("Incorrect password!");
                            txtPas.requestFocus();
                        }
                    }
                }
                else {
                    while (rsMan.next()) {
                        String retrievePassword = rsMan.getString("password");
                        if (retrievePassword.equals(passWord)) {
                            changeScene(event, "\"Welcome to the BETTER lIFE PHARMACY Application  " , "manager.fxml",userName);
                        } else {
                            lblPas.setText("Incorrect password!");
                            txtPas.requestFocus();
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(rsMan !=null) {
                try {
                    rsMan.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if( rsS !=null) {
                try {
                    rsS.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if( stmtS !=null) {
                    try {
                        stmtS.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
