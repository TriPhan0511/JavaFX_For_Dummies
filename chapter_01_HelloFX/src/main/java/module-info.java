module com.example.chapter_01_hellofx {
  requires javafx.controls;
  requires javafx.fxml;


  opens com.example.chapter_01_hellofx to javafx.fxml;
  exports com.example.chapter_01_hellofx;

  exports com.triphan.testing;

}