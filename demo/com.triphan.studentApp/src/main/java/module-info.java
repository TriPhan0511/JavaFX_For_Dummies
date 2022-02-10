module com.example.com_triphan_student {
  requires javafx.controls;
  requires javafx.fxml;


  opens com.example.com_triphan_student to javafx.fxml;
  exports com.example.com_triphan_student;
}