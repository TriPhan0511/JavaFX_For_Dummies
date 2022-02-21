package com.triphan.master_detail_views_sample;

import com.triphan.master_detail_views_sample.model.Person;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController implements Initializable
{
  @FXML
  ListView<Person> listView;
  @FXML
  TextField firstnameTextField;
  @FXML
  TextField lastnameTextField;
  @FXML
  TextArea notesTextArea;

  @FXML
  Button removeButton;

  @FXML
  private void removeButtonAction()
  {

  }

  //  Class fields
  Person selectedPerson;


  @Override
  public void initialize(URL url, ResourceBundle resourceBundle)
  {
//    ListView selection change listener
    listView.getSelectionModel().selectedItemProperty().addListener(
        ((observableValue, oldValue, newValue) -> {
//          new value can be null if nothing is selected
          selectedPerson = newValue;
          if (newValue != null)
          {
//            Populate controls with selected Person
            firstnameTextField.setText(selectedPerson.getFirstName());
            lastnameTextField.setText(selectedPerson.getLastname());
            notesTextArea.setText(selectedPerson.getNotes());
          } else
          {
            firstnameTextField.setText("");
            lastnameTextField.setText("");
            notesTextArea.setText("");
          }
        })
    );

//    Set multiple selection for the ListView
//    listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

  }
}


























