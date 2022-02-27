package com.pharmacy_management.pharmacy_manager.controller;
import com.pharmacy_management.pharmacy_manager.model.DB_DAO;
import com.pharmacy_management.pharmacy_manager.model.Employee;
import com.pharmacy_management.pharmacy_manager.model.LoginModels;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class SupervisorController implements Initializable {
    @FXML
    private Label lblSetUseS;
    @FXML
    private Button btnSta;
    @FXML
    private Button btnSup;
    @FXML
    private Button btnCat;
    @FXML
    private Button btnPro;
    @FXML
    private Button btnImp;
    @FXML
    private Button btnCus;
    @FXML
    private Button btnSal;
    @FXML
    private Button btnSalS;
    @FXML
    private Button btnMan;
    @FXML
    private Button btnWar;
    @FXML
    private Button btnRep;

    @FXML
    private Button btnBack;

    @FXML
    private TableView tableEmployee;

    @FXML
    private TableColumn columnId,columnFisrtname,columnLastname,columnGender,columnEmail,columnPhone,columnAdderss;

    @FXML
    private Pane uiPane,employeePane,supplierPane,paneEmployeeTable,showEmplyeepane,centerPane;

    public void changepane(Pane pan) {
            pan.setVisible(true);
    }
    public void setPane(ActionEvent actionEvent){
        if(actionEvent.getSource()==btnSta)  {changepane(employeePane);txtEmployeeId.requestFocus();}
        if(actionEvent.getSource()==btnBack) employeePane.setVisible(false);
    }
    private ObservableList<Employee> employeeObservableList;
    private Employee employee;
    public static void changePro(Button btn){
        btn.setBorder(Border.EMPTY);
    }
     public void comboboxChange(ComboBox cbx){
        cbx.getValue();
     }

    public void setUse(String user){
        lblSetUseS.setText(user +" - Supervisor");
    }
    public void changecol(MouseEvent me){
        if(me.getSource()==btnSta) {changePro(btnSta);}
        if(me.getSource()==btnSup) changePro(btnSup);
        if(me.getSource()==btnCat) changePro(btnCat);
        if(me.getSource()==btnPro) changePro(btnPro);
        if(me.getSource()==btnImp) changePro(btnImp);
        if(me.getSource()==btnCus) changePro(btnCus);
        if(me.getSource()==btnSal) changePro(btnSal);
        if(me.getSource()==btnSalS) changePro(btnSalS);
        if(me.getSource()==btnMan) changePro(btnMan);
        if(me.getSource()==btnWar) changePro(btnWar);
        if(me.getSource()==btnRep) changePro(btnRep);

        if(me.getSource()==btnBack) changePro(btnBack);

        if(me.getSource()==btnAdd) changePro(btnAdd);

        if(me.getSource()==btnDelete) changePro(btnDelete);
        if(me.getSource()==btnCancel) changePro(btnCancel);


    }

    public void logO(ActionEvent e){
        LoginModels.logOut(e);
    }

    @FXML
    private ComboBox<String> genderCombobox;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> listGender= FXCollections.observableArrayList("Male","Female");
        genderCombobox.setItems(listGender);


        employeeObservableList=showEmployee();
        columnId.setCellValueFactory(new PropertyValueFactory<Employee,String>("id"));
        columnFisrtname.setCellValueFactory(new PropertyValueFactory<Employee,String>("firstName"));
        columnLastname.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastName"));
        columnGender.setCellValueFactory(new PropertyValueFactory<Employee,String>("gender"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<Employee,String>("email"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Employee,String>("phoneNumber"));
        columnAdderss.setCellValueFactory(new PropertyValueFactory<Employee,String>("address"));
        tableEmployee.setItems(employeeObservableList);

   }

    public void comboboxChange(ActionEvent e){
        if(e.getSource()==genderCombobox) comboboxChange(genderCombobox);

    }

    public ObservableList<Employee> showEmployee() {
        ArrayList<Employee> arrEm = new ArrayList<>();
        DB_DAO db = new DB_DAO();
        Connection con = db.getConn();
        String sql = "select employee_id,first_name,last_name,gender,email,phone_number,address\n" +
                "from employee";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String employee_id = rs.getString("employee_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String gender = rs.getString("gender");
                String email = rs.getString("email");
                String phone_number = rs.getString("phone_number");
                String address = rs.getString("address");
                employee = new Employee(employee_id, first_name, last_name, gender, email, phone_number, address);
                arrEm.add(employee);

            }
            employeeObservableList= FXCollections.observableArrayList(arrEm);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return employeeObservableList;
    }
        @FXML
        private TextField txtEmployeeId,txtEmployeeFirstname,txtEmployeeLastname,txtEmployeeEmail,txtEmployeePhonenumber,txtEmployeeAddress;
        @FXML
        private Button btnAdd,btnDelete,btnCancel;
        @FXML
        private Label lblValidateId,lblValidateEmail,lblValidatePhone;

        public void addObj(ActionEvent event){
         Employee newE  = new Employee();
         while (true) {
             for (Employee emp:employeeObservableList
                  ) {
                 if( emp.getId().equals(txtEmployeeId.getText().trim()) ) {
                     txtEmployeeId.requestFocus();
                     lblValidateId.setText("* Not valid");
                     return;
                 }
             }
             newE.setId(txtEmployeeId.getText());
             newE.setFirstName(txtEmployeeFirstname.getText());
             newE.setLastName(txtEmployeeLastname.getText());
             newE.setGender(genderCombobox.getValue());
             if (txtEmployeeEmail.getText().matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$")) {
                 newE.setEmail(txtEmployeeEmail.getText());
             } else {
                 txtEmployeeEmail.requestFocus();
                 lblValidateEmail.setText("* Not valid");
                 return;
             }

             if (txtEmployeePhonenumber.getText().matches("(0|\\\\+d{2})\\d{9}")) {
                 newE.setPhoneNumber(txtEmployeePhonenumber.getText());


             } else {
                 txtEmployeePhonenumber.requestFocus();
                 lblValidatePhone.setText("* Not valid");
                 return;
             }
             newE.setAddress(txtEmployeeAddress.getText());
             employeeObservableList.add(newE);
             lblValidateEmail.setText("");
             lblValidatePhone.setText("");
             break;
         }

        }

        public void deleteObj(ActionEvent event){
            ObservableList  selected   =  tableEmployee.getSelectionModel().getSelectedItems();
            employeeObservableList.removeAll(selected);
        }

        public void setBtnCancel(ActionEvent event){
            new LoginModels().setEmtyTextfield(txtEmployeeId,txtEmployeeFirstname,txtEmployeeLastname,txtEmployeeEmail,txtEmployeePhonenumber,txtEmployeeAddress);
            txtEmployeeId.requestFocus();
        }
    }

