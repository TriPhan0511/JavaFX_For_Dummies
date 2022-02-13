module com.triphan.passing_parameters_to_fxml_controllers {
  requires javafx.controls;
  requires javafx.fxml;


  opens com.triphan.passing_parameters_to_fxml_controllers to javafx.fxml;
  exports com.triphan.passing_parameters_to_fxml_controllers;
}