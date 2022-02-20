package com.triphan.opening_a_new_window;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class OpeningANewWindowController
{
  @FXML
  Button newWindowButton;

//  Change stage (window)
  @FXML
  private void newWindowButton_Click(ActionEvent event) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("new-window-view.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.setTitle("New Window");
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.setMinWidth(1000);
    stage.setMaxWidth(1000);
    stage.setMinHeight(700);
    stage.setMaxHeight(700);
    stage.show();
  }

//  This method change only scene, not stage (window)
//  @FXML
//  private void newWindowButton_Click(ActionEvent event) throws IOException
//  {
//    FXMLLoader loader = new FXMLLoader(
//        getClass().getResource("new-window-view.fxml"));
//    Parent root = loader.load();
////    Scene scene = new Scene(root);
//    Scene scene = new Scene(root,1000,700);
//    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//    stage.setScene(scene);
//  }
}























