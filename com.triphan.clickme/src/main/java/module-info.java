module com.triphan.clickme {
  requires javafx.controls;
  requires javafx.fxml;


  opens com.triphan.clickme to javafx.fxml;
  exports com.triphan.clickme;
  exports com.triphan.testing;
  opens com.triphan.testing to javafx.fxml;
}