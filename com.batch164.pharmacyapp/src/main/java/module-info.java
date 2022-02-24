module com.batch164.pharmacyapp {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.sql;

  opens com.batch164.pharmacyapp to javafx.fxml;
  exports com.batch164.pharmacyapp;

  opens com.batch164.pharmacyapp.model to javafx.base;

}