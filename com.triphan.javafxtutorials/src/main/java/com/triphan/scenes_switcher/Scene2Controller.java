package com.triphan.scenes_switcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene2Controller
{
  @FXML
  private Label displayLabel;
  @FXML
  private Button addButton;
  @FXML
  private Button subtractButton;
  @FXML
  private Button switchSceneButton;

  int counter = 0;

  @FXML
  private void initialize()
  {
//    displayLabel.setText(Integer.toString(counter));
  }

  @FXML
  private void addButton_Click()
  {
    counter++;
    displayLabel.setText(Integer.toString(counter));
  }

  @FXML
  private void subtractButton_Click()
  {
    counter--;
    displayLabel.setText(Integer.toString(counter));
  }

  @FXML
  private void switchSceneButton_Click(ActionEvent event) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("scene1-view.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
  }
}






















