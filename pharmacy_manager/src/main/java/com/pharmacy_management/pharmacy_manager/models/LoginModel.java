package com.pharmacy_management.pharmacy_manager.models;

import com.pharmacy_management.pharmacy_manager.DBUtils.DB_DAO;
import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;
public class LoginModel {
    public static String store;
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

        String sql               = "select password ,employee.store_id from employee where employee_id=?";
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
                            store            = rsS.getString("store_id");
                            if (retrievePassword.equals(passWord)) {
                                new ChangeGUI().changeScene(event, "Welcome to the BETTER LIFE PHARMACY Application " , "suppervisor.fxml",userName,store);
                            } else {
                                lblPas.setText("Incorrect password!");
                                txtPas.requestFocus();
                            }
                        }
                    }
                    else  while (rs.next()) {
                        String retrievePassword = rs.getString("password");
                        store            = rs.getString("store_id");
                        if (retrievePassword.equals(passWord)) {
                            new ChangeGUI().changeScene(event, "\"Welcome to the BETTER lIFE PHARMACY Application  ", "staff.fxml",userName,store);

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
                        store            = rsMan.getString("store_id");
                        if (retrievePassword.equals(passWord)) {
                            new ChangeGUI().changeScene(event, "\"Welcome to the BETTER lIFE PHARMACY Application  " , "manager.fxml",userName,store);
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
