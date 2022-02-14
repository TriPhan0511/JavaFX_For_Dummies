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

public class Scene1Controller
{
  @FXML
  Label displayLabel;
  @FXML
  Button clickMeButton;
  @FXML
  Button switchSceneButton;

  int counter = 0;

  @FXML
  private void initialize()
  {
//    displayLabel.setText("You have not clicked the button.");
  }

  @FXML
  private void clickMeButton_Click()
  {
    counter++;
    if (counter == 1)
    {
      displayLabel.setText("You have clicked once.");
    }
    else
    {
      displayLabel.setText("You have clicked " + counter + " times.");
    }
  }

  @FXML
  private void switchSceneButton_Click(ActionEvent event) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("scene2-view.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
  }
}























