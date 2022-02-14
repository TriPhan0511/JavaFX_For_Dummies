module com.triphan.javafxtutorials {
  requires javafx.controls;
  requires javafx.fxml;

  opens com.triphan.javafxtutorials to javafx.fxml;
  exports com.triphan.javafxtutorials;

  opens com.triphan.testing2 to javafx.fxml;
  exports com.triphan.testing2;

  exports com.triphan.anchorpane_sample;

  opens com.triphan.scenes_switcher to javafx.fxml;
  exports com.triphan.scenes_switcher;

}