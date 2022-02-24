module com.batch164.pharmarcyapplication.com_batch164_pharmacyapplication {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.sql;


//  opens com.batch164.pharmarcyapplication.com_batch164_pharmacyapplication to javafx.fxml;
//  exports com.batch164.pharmarcyapplication.com_batch164_pharmacyapplication;

//  opens com.batch164.pharmarcyapplication to javafx.fxml;
//  exports com.batch164.pharmarcyapplication;

  opens com.batch164.pharmarcyapplication to javafx.fxml;
  exports com.batch164.pharmarcyapplication;
  exports com.batch164.pharmarcyapplication.controller;
  opens com.batch164.pharmarcyapplication.controller to javafx.fxml;

  opens com.batch164.pharmarcyapplication.model to javafx.base;

}