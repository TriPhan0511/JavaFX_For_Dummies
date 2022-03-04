package com.triphan.data_transfering_between_controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene1Controller
{
  @FXML
  private TextField nameTextField;

  @FXML
  private Button goButton;
  @FXML
  void goButton_Click(ActionEvent event) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("scene2-view.fxml"));
    Parent root = loader.load();
    Scene2Controller scene2Controller = loader.getController();

////    scene2Controller.displayMessage(nameTextField.getText());

//    ----------------------------------------------------------------
//    scene2Controller.setName(nameTextField.getText());
//    scene2Controller.displayMessage2();

//    ----------------------------------------------------------------

//    scene2Controller.setEmployee(new Employee("Peter", 15));
//    scene2Controller.displayMessage3();

//    ----------------------------------------------------------------

    scene2Controller.setEmployee(new Employee("Hillary", 45));

    Scene scene2 = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene2);
    stage.show();
  }

}


























