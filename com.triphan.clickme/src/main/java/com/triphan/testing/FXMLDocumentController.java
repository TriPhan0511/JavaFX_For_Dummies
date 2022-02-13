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

//public class FXMLDocumentController
//{
//  @FXML
//  private Label lbl1, lbl2;
//  @FXML
//  private Button btn1, btn2;
//
//  @FXML
//  private void handleActionButton()
//  {
//
//  }
//
//  @FXML
//  private void handleActionButton(ActionEvent event) throws IOException
//  {
//    Stage stage;
//    Parent root;
//
//    if (event.getSource() == btn1)
//    {
//      stage = (Stage) btn1.getScene().getWindow();
//      root = FXMLLoader.load(getClass().getResource("FXML2.fxml"));
//    }
//    else
//    {
//      stage = (Stage) btn2.getScene().getWindow();
//      root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
//    }
//
//    Scene scene = new Scene(root);
//    stage.setScene(scene);
//    stage.show();
//  }
//
//}

public class FXMLDocumentController implements Initializable
{
  @FXML
  private Label lbl1, lbl2;
  @FXML
  private Button btn1, btn2;

  @FXML
  private void handleActionButton(ActionEvent event) throws IOException
  {
    Stage stage;
    Parent root;

    if (event.getSource() == btn1)
    {
      stage = (Stage) btn1.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("FXML2.fxml"));
    }
    else
    {
      stage = (Stage) btn2.getScene().getWindow();
      root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
    }

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle)
  {

  }
}























