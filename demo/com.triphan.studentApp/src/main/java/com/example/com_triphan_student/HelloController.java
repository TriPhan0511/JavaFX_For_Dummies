package com.example.com_triphan_student;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController
{
  @FXML
  private Label welcomeText;

  @FXML
  protected void onHelloButtonClick()
  {
    welcomeText.setText("Welcome to JavaFX Application!");
  }
}