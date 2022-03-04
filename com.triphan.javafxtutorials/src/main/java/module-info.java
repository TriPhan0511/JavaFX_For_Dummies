module com.triphan.javafxtutorials {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.sql;

  opens com.triphan.javafxtutorials to javafx.fxml;
  exports com.triphan.javafxtutorials;

  opens com.triphan.testing2 to javafx.fxml;
  exports com.triphan.testing2;

  exports com.triphan.anchorpane_sample;

  opens com.triphan.scenes_switcher to javafx.fxml;
  exports com.triphan.scenes_switcher;

  opens com.triphan.scenes_communication to javafx.fxml;
  exports com.triphan.scenes_communication;

  opens com.triphan.login_form_sample to javafx.fxml;
  exports com.triphan.login_form_sample;

  opens com.triphan.opening_a_new_window to javafx.fxml;
  exports com.triphan.opening_a_new_window;

  opens com.triphan.login_form_sample_2 to javafx.fxml;
  exports com.triphan.login_form_sample_2;

  opens com.triphan.searchbar to javafx.fxml;
  exports com.triphan.searchbar;

  opens com.triphan.searchbar_and_tableview to javafx.fxml;
  exports com.triphan.searchbar_and_tableview;

  opens com.triphan.data_transfering_between_controllers to javafx.fxml;
  exports com.triphan.data_transfering_between_controllers;

}