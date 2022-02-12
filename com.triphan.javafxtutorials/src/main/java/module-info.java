module com.triphan.javafxtutorials {
  requires javafx.controls;
  requires javafx.fxml;


  opens com.triphan.javafxtutorials to javafx.fxml;
  exports com.triphan.javafxtutorials;
}