module com.batch164.pharmacyapp {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.sql;

  opens com.batch164.pharmacyapp.testing_login_form to javafx.fxml;
  exports com.batch164.pharmacyapp.testing_login_form;

}