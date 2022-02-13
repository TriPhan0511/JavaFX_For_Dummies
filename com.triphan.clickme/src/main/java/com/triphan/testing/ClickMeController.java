package com.triphan.testing;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClickMeController implements Initializable
{
  //  Class fields for Click-Counter scene
  @FXML
  private Label displayLabel1;
  @FXML
  private Button clickMeButton, switchToScene2Button;
  private int counter1 = 0;

  //  Class fields for Add-Subtract scene
  @FXML
  private Label displayLabel2;
  @FXML
  private Button addButton, subtractButton, switchToScene1Button;
  @FXML
  private int counter2 = 0;

  @FXML
  private void clickMeButton_Click()
  {
    counter1++;
    if (counter1 == 1)
    {
      displayLabel1.setText("You have clicked once.");
    }
    else
    {
      displayLabel1.setText("You have clicked "+counter1+" times.");
    }
  }

  @FXML
  private void addButton_Click()
  {
    counter2++;
    displayLabel2.setText(Integer.toString(counter2));
  }

  @FXML
  private void subtractButton_Click()
  {
    counter2--;
    displayLabel2.setText(Integer.toString(counter2));
  }

  @FXML
  private void switchScenes(ActionEvent event) throws IOException
  {
    Stage stage;
    Parent root;
    if (event.getSource() == switchToScene2Button)
    {
      stage = (Stage) switchToScene2Button.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("add-subtract-view.fxml"));
    }
    else
    {
      stage = (Stage) switchToScene1Button.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("click-counter-view.fxml"));
    }
    Scene scene = new Scene(root, 320, 240);
    stage.setScene(scene);
    stage.show();
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle)
  {
    displayLabel1.setText("You have not clicked the button.");
//    displayLabel2.setText(Integer.toString(counter2));
  }

}

//public class ClickMeController
//{
////  Class fields for Click-Counter scene
//  @FXML
//  private Label displayLabel1;
//  @FXML
//  private Button clickMeButton, switchToScene2Button;
//  private int counter1 = 0;
//
//  //  Class fields for Add-Subtract scene
//  @FXML
//  private Label displayLabel2;
//  @FXML
//  private Button addButton, subtractButton, switchToScene1Button;
//  @FXML
//  private int counter2 = 0;
//
//  @FXML
//  public void initialize()
//  {
////    displayLabel1.setText("You have not clicked the button.");
////    displayLabel2.setText(Integer.toString(counter2));
//  }
//
//  @FXML
//  private void clickMeButton_Click()
//  {
//    counter1++;
//    if (counter1 == 1)
//    {
//      displayLabel1.setText("You have clicked once.");
//    }
//    else
//    {
//      displayLabel1.setText("You have clicked "+counter1+" times.");
//    }
//  }
//
//  @FXML
//  private void addButton_Click()
//  {
//    counter2++;
//    displayLabel2.setText(Integer.toString(counter2));
//  }
//
//  @FXML
//  private void subtractButton_Click()
//  {
//    counter2--;
//    displayLabel2.setText(Integer.toString(counter2));
//  }
//
//  @FXML
//  private void switchScenes(ActionEvent event) throws IOException
//  {
//    Stage stage;
//    Parent root;
//    if (event.getSource() == switchToScene2Button)
//    {
//      stage = (Stage) switchToScene2Button.getScene().getWindow();
//      root = FXMLLoader.load(getClass().getResource("add-subtract-view.fxml"));
//    }
//    else
//    {
//      stage = (Stage) switchToScene1Button.getScene().getWindow();
//      root = FXMLLoader.load(getClass().getResource("click-counter-view.fxml"));
//    }
//    Scene scene = new Scene(root, 320, 240);
//    stage.setScene(scene);
//    stage.show();
//  }
//}
























