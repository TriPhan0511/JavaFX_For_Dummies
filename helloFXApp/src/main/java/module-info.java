module com.triphan.hellofxapp {
  requires javafx.controls;
  requires javafx.fxml;


  opens com.triphan.hellofxapp to javafx.fxml;
  exports com.triphan.hellofxapp;
}