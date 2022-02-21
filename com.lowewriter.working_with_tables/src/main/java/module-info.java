module com.lowewriter.working_with_tables {
  requires javafx.controls;
  requires javafx.fxml;

  opens com.lowewriter.working_with_tables to javafx.fxml;
  exports com.lowewriter.working_with_tables;
  exports com.lowewriter.working_with_tables.model;
  opens com.lowewriter.working_with_tables.model to javafx.fxml;
}