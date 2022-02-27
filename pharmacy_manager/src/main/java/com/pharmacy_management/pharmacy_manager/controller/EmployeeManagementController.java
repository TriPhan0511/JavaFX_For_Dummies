package com.pharmacy_management.pharmacy_manager.controller;
import com.pharmacy_management.pharmacy_manager.DBUtils.EmployeeUtil;
import com.pharmacy_management.pharmacy_manager.map.Employee;
import com.pharmacy_management.pharmacy_manager.models.ChangeGUI;
import com.pharmacy_management.pharmacy_manager.models.LoginModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;
public class EmployeeManagementController implements Initializable {
    private ObservableList<Employee> employeeObservableList;
    private Employee employee;
    @FXML
    private Label userEmpLabel, store_idEmpLabel;


    @FXML
    private Button backButton;

    @FXML
    private Button logoutEmpButton;

    @FXML
    private TableView<Employee> tableEmployee;

    @FXML
    private TableColumn<Employee, String> columnId, columnFisrtname, columnLastname, columnGender, columnEmail, columnPhone, columnAdderss;

    public void setUse(String user, String store) {
        userEmpLabel.setText(user);
        store_idEmpLabel.setText(store);
    }

    public void setLogOutButton(ActionEvent event) {
        new ChangeGUI().SetBtnLogout(event);
    }

    public void setBackButton(ActionEvent event) {
        new ChangeGUI().changeScene(event, "Welcome to the BETTER LIFE PHARMACY Application", "suppervisor.fxml", userEmpLabel.getText(), store_idEmpLabel.getText());
    }

    public void changecol(MouseEvent me) {

        if (me.getSource() == backButton) new ChangeGUI().changeProButton(backButton);

        if (me.getSource() == addEmpButton) new ChangeGUI().changeProButton(addEmpButton);

        if (me.getSource() == deleteEmpButton) new ChangeGUI().changeProButton(deleteEmpButton);
        if (me.getSource() == cancelEmpButton) new ChangeGUI().changeProButton(cancelEmpButton);

        if (me.getSource() == logoutEmpButton) new ChangeGUI().changeProButton(logoutEmpButton);
        if (me.getSource() == updateEmpButton) new ChangeGUI().changeProButton(updateEmpButton);
        if (me.getSource() == listEmpButton) new ChangeGUI().changeProButton(listEmpButton);



    }


    @FXML
    private ComboBox<String> genderCombobox;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> listGender = FXCollections.observableArrayList("m", "f");
        genderCombobox.setItems(listGender);

        tableEmployee.setEditable(true);
        ArrayList<Employee> arr = new ArrayList<>();
        employeeObservableList = FXCollections.observableArrayList(arr);

        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnId.setCellFactory(TextFieldTableCell.forTableColumn());

        columnFisrtname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        columnFisrtname.setCellFactory(TextFieldTableCell.forTableColumn());
        columnFisrtname.setOnEditCommit(cellEditEvent -> {
            Employee employee = cellEditEvent.getRowValue();
            employee.setFirstName(cellEditEvent.getNewValue());
        });

        columnLastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        columnLastname.setCellFactory(TextFieldTableCell.forTableColumn());
        columnLastname.setOnEditCommit(cellEditEvent -> {
            Employee employee = cellEditEvent.getRowValue();
            employee.setLastName(cellEditEvent.getNewValue());
        });

        columnGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        columnGender.setCellFactory(TextFieldTableCell.forTableColumn());
        columnGender.setOnEditCommit(cellEditEvent -> {
            Employee employee = cellEditEvent.getRowValue();
            employee.setGender(cellEditEvent.getNewValue());

            if (!employee.getGender().equals("m")) {
                lblNotification.setText("Gender is m or f");
            } else if (!employee.getGender().equals("f")) {
                lblNotification.setText("Gender is m or f");
            }

        });

        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnEmail.setCellFactory(TextFieldTableCell.forTableColumn());
        columnEmail.setOnEditCommit(cellEditEvent -> {
            Employee employee = cellEditEvent.getRowValue();
            employee.setEmail(cellEditEvent.getNewValue());
            if (!employee.getEmail().matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$")) {
                lblNotification.setText("Wrong Format !");
            }
        });

        columnPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        columnPhone.setCellFactory(TextFieldTableCell.forTableColumn());
        columnPhone.setOnEditCommit((TableColumn.CellEditEvent<Employee, String> cellEditEvent) -> {
            Employee employee = cellEditEvent.getRowValue();
            employee.setPhoneNumber(cellEditEvent.getNewValue());
            if (!employee.getPhoneNumber().matches("(0|\\\\+d{2})\\d{9}")) {
                lblNotification.setText("Wrong Format !");
            }
        });

        columnAdderss.setCellValueFactory(new PropertyValueFactory<>("address"));
        columnAdderss.setCellFactory(TextFieldTableCell.forTableColumn());
        columnAdderss.setOnEditCommit(cellEditEvent -> {
            Employee employee = cellEditEvent.getRowValue();
            employee.setAddress(cellEditEvent.getNewValue());
        });

        tableEmployee.setItems(employeeObservableList);


    }

    public void comboboxChange(ActionEvent e) {
        if (e.getSource() == genderCombobox) new ChangeGUI().comboboxChange(genderCombobox);

    }


    @FXML
    private TextField txtEmployeeId, txtEmployeeFirstname, txtEmployeeLastname, txtEmployeeEmail, txtEmployeePhonenumber, txtEmployeeAddress;
    @FXML
    private Button listEmpButton, addEmpButton, deleteEmpButton, cancelEmpButton, updateEmpButton;
    @FXML
    private Label lblValidateId, lblValidateEmail, lblValidatePhone, lblValidate, lblNotification;

    public void setBtnAdd(ActionEvent event) {
        employeeObservableList = tableEmployee.getItems();
        employee = new Employee();
        while (true) {
            if (txtEmployeeId.getText().isBlank() || txtEmployeeFirstname.getText().isBlank() || txtEmployeeLastname.getText().isBlank()
                    || txtEmployeeEmail.getText().isBlank() || txtEmployeePhonenumber.getText().isBlank() || txtEmployeeAddress.getText().isBlank()) {
                lblValidate.setText("* Not enough information !");
                return;
            }
            for (Employee em : employeeObservableList
            ) {
                if (em.getId().trim().equals(txtEmployeeId.getText().trim())) {
                    lblValidateId.setText("ID is exist");
                    txtEmployeeId.requestFocus();
                    return;
                } else employee.setId(txtEmployeeId.getText());

            }
            employee.setFirstName(txtEmployeeFirstname.getText());
            employee.setLastName(txtEmployeeLastname.getText());
            employee.setGender(genderCombobox.getValue());
            if (txtEmployeeEmail.getText().matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$")) {
                employee.setEmail(txtEmployeeEmail.getText());
            } else {
                txtEmployeeEmail.requestFocus();
                lblValidateEmail.setText("* Not valid");
                return;
            }

            if (txtEmployeePhonenumber.getText().matches("(0|\\\\+d{2})\\d{9}")) {
                employee.setPhoneNumber(txtEmployeePhonenumber.getText());


            } else {
                txtEmployeePhonenumber.requestFocus();
                lblValidatePhone.setText("* Not valid");
                return;
            }
            employee.setAddress(txtEmployeeAddress.getText());
//            employeeObservableList.add(employee);
            lblValidateId.setText("");
            lblValidateEmail.setText("");
            lblValidatePhone.setText("");
            lblValidate.setText("");
            break;
        }
        Dialog<Object> dialog = new Dialog<>();
        dialog.setTitle("Save Employee");
        dialog.setHeaderText("Do you want to save ?");
        ButtonType Save = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(Save, ButtonType.CANCEL);
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == Save) {
                new EmployeeUtil().addEmployee(employee, store_idEmpLabel.getText(), lblNotification);
            }
            return null;
        });
        dialog.show();
    }

    public void setDeleteEmpButton(ActionEvent event) {
        Employee selected = tableEmployee.getSelectionModel().getSelectedItem();
        employeeObservableList.removeAll(selected);
    }

    public void setCancelEmpButton(ActionEvent event) {
        new LoginModel().setEmtyTextfield(txtEmployeeId, txtEmployeeFirstname, txtEmployeeLastname, txtEmployeeEmail, txtEmployeePhonenumber, txtEmployeeAddress);
        genderCombobox.setValue("");
        txtEmployeeId.requestFocus();
    }

    public void setUpdateEmpButton(ActionEvent event) {
        employee = tableEmployee.getSelectionModel().getSelectedItem();
        if(employee==null) {lblNotification.setText("please choise");return;}
        Dialog dialog = new Dialog<>();
        dialog.setTitle("Update Employee");
        dialog.setHeaderText("Do you want to update ?");
        ButtonType Update = new ButtonType("Update", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(Update, ButtonType.CANCEL);
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == Update) {
                try {
                    new EmployeeUtil().updateEmployee(employee, lblNotification);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return null;
        });
        dialog.show();

    }

    public void setListEmpButton(ActionEvent event) {
        ArrayList<Employee> arrayList = new EmployeeUtil().showEmployee(store_idEmpLabel);
        employeeObservableList = FXCollections.observableArrayList(arrayList);
        tableEmployee.setItems(employeeObservableList);


        FilteredList<Employee> filteredList =   new FilteredList<>(employeeObservableList,b->true);
        searchEmpTextfield.textProperty().addListener((observable,oldValue,newValue)->{
            filteredList.setPredicate(employeeObservableList->{
                if(newValue.isEmpty() || newValue.isBlank()){
                    return true;
                }
                String searchEmp=newValue.toLowerCase();
                if(employeeObservableList.getId().toLowerCase().indexOf(searchEmp)>-1){
                    return true;
                }
                if(employeeObservableList.getFirstName().toLowerCase().indexOf(searchEmp)>-1){
                    return true;
                }
                else return employeeObservableList.getLastName().toLowerCase().indexOf(searchEmp) > -1;
            });
        });
        SortedList<Employee> sortedList=new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(tableEmployee.comparatorProperty());

        tableEmployee.setItems(sortedList);

    }
    @FXML
    private TextField searchEmpTextfield;
//    public  void setSearchButton(ActionEvent event){
//        ArrayList<Employee> arr= findBook(searchEmpTextfield.getText().trim(),lblNotification);
//        employeeObservableList=FXCollections.observableArrayList(arr);
//        tableEmployee.set
//
//
//    }
//    public ArrayList<Employee> findBook(String lastName,Label lbl) {
//        ArrayList<Employee> arrayList = null;
//       employeeObservableList=tableEmployee.getItems();
//        for (Employee emp:employeeObservableList
//             ) {
//            if(emp.getLastName().trim().equalsIgnoreCase(lastName))  arrayList.add(emp);
//            else lbl.setText("Khong tim thay");
//        }
//        return  arrayList;
//    }
}

