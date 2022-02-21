package com.lowewriter.choosing_from_a_list.listview_samples_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonController implements Initializable
{

  @FXML
  private TextField firstnameTextField;
  @FXML
  private TextField lastnameTextField;
  @FXML
  private ListView<Person> personListView;
  @FXML
  private TextArea notesTextArea;
  @FXML
  private Button removeButton;
  @FXML
  private Button addButton;
  @FXML
  private Button updateButton;
  @FXML
  Label errorMessageLabel;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle)
  {

//    Set data for the personListView
    personListView.setItems(SampleData.initializeData());

//    Set selection changes listener for the personListView
    personListView.getSelectionModel().selectedItemProperty()
        .addListener( (observable, oldValue, newValue) -> {
          firstnameTextField.setText(newValue.getFirstname());
          lastnameTextField.setText(newValue.getLastname());
          notesTextArea.setText(newValue.getNotes());
        } );
  }

  @FXML
  private void addButton_Click()
  {
    boolean hasExisted = false;
    Person tempPerson = null;
    String tempFirstName = firstnameTextField.getText().trim();
    String tempLastName = lastnameTextField.getText().trim();
    String tempNotes = notesTextArea.getText();
    for (Person item : personListView.getItems())
    {
      if (item.getFirstname().equalsIgnoreCase(tempFirstName)
          && item.getLastname().equalsIgnoreCase(tempLastName))
      {
        errorMessageLabel.setText("The full name has existed.");
        hasExisted = true;
      }
    }
    if (!hasExisted)
    {
      tempPerson = new Person(tempFirstName, tempLastName, tempNotes);
      personListView.getItems().add(tempPerson);
      errorMessageLabel.setText("");
    }
  }

  @FXML
  private void removeButton_Click(ActionEvent event)
  {

  }



  @FXML
  private void updateButton_Click()
  {

  }


}
