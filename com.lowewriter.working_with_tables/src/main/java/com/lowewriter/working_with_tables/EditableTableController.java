package com.lowewriter.working_with_tables;

import com.lowewriter.working_with_tables.model.Movie;
import com.lowewriter.working_with_tables.model.SampleData;
import com.lowewriter.working_with_tables.utils.TextFieldValidation;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class EditableTableController implements Initializable
{


  @FXML
  private TableView<Movie> movieTable;
  @FXML
  private TableColumn<Movie, String> titleColumn;
  @FXML
  private TableColumn<Movie, Integer> yearColumn;
  @FXML
  private TableColumn<Movie, Double> priceColumn;

  @FXML
  private TextField titleTextField;
  @FXML
  private TextField yearTextField;
  @FXML
  private TextField priceTextField;

  @FXML
  Label titleErrorLabel;
  @FXML
  Label yearErrorLabel;
  @FXML
  Label priceErrorLabel;

  @FXML
  private Button addButton;
  @FXML
  private Button deleteButton;

  @FXML
  Button showButton;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle)
  {
//    Set data for the movieTable
    movieTable.setItems(SampleData.loadData());

//    Set Multiple Selection Mode for the movie table
    movieTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

//    Set properties from the table's collection to the columns
//    And create text fields in  table columns (for editing purpose)
    titleColumn.setCellValueFactory(
        new PropertyValueFactory<Movie, String>("title"));
    titleColumn.setCellFactory(
        TextFieldTableCell.forTableColumn());

    yearColumn.setCellValueFactory(
        new PropertyValueFactory<Movie, Integer>("year"));
    yearColumn.setCellFactory(
        TextFieldTableCell.forTableColumn(
            new IntegerStringConverter()));

    priceColumn.setCellValueFactory(
        new PropertyValueFactory<Movie, Double>("price"));
    priceColumn.setCellFactory(
        TextFieldTableCell.forTableColumn(
            new DoubleStringConverter()));
  }

  @FXML
  private void showButton_Click()
  {
    for (Movie item : movieTable.getItems())
    {
      System.out.println(item);
    }
    System.out.println("-----------------------------------------");
    System.out.println();
  }

  @FXML
  private void titleColumn_OnEditCommit(Event event)
  {
    TableColumn.CellEditEvent<Movie, String> cellEditEvent;
    cellEditEvent = (TableColumn.CellEditEvent<Movie, String>) event;
    Movie tempMovie = cellEditEvent.getRowValue();
    tempMovie.setTitle(cellEditEvent.getNewValue());
  }

  @FXML
  private void yearColumn_OnEditCommit(Event event)
  {
    TableColumn.CellEditEvent<Movie, Integer> cellEditEvent;
    cellEditEvent = (TableColumn.CellEditEvent<Movie, Integer>) event;
    Movie tempMovie = cellEditEvent.getRowValue();
    tempMovie.setYear(cellEditEvent.getNewValue());
  }

  @FXML
  private void priceColumn_OnEditCommit(Event event)
  {
    TableColumn.CellEditEvent<Movie, Double> cellEditEvent;
    cellEditEvent = (TableColumn.CellEditEvent<Movie, Double>) event;
    Movie tempMovie = cellEditEvent.getRowValue();
    tempMovie.setPrice(cellEditEvent.getNewValue());
  }

  @FXML
  private void addButton_Click()
  {
    TextFieldValidation textFieldValidation = new TextFieldValidation();
    String blankErrorMessage = " This field is required.";
    String integerErrorMessage = "This field requires an integer.";
    String doubleErrorMessage = "This field requires a double.";
    String dateErrorMessage = "Invalid date.";

//    Validate the text fields
    if (!textFieldValidation.isBlank(
        titleTextField, titleErrorLabel, blankErrorMessage))
    {
      titleErrorLabel.setText("");
    }

    if (!textFieldValidation.isBlank(
        yearTextField, yearErrorLabel, blankErrorMessage)
        && textFieldValidation.isInteger(
            yearTextField, yearErrorLabel, integerErrorMessage))
    {
      yearErrorLabel.setText("");
    }

    if (!textFieldValidation.isBlank(
        priceTextField, priceErrorLabel, blankErrorMessage)
        && textFieldValidation.isDouble(
            priceTextField, priceErrorLabel, doubleErrorMessage))
    {
      priceErrorLabel.setText("");

    }

//    Create a new Movie object and add it to the table's collection
    if (titleErrorLabel.getText().equals("")
        && yearErrorLabel.getText().equals("")
        && priceErrorLabel.getText().equals(""))
    {
      Movie tempMovie = new Movie(
          titleTextField.getText().trim(),
          Integer.parseInt(yearTextField.getText().trim()),
          Double.parseDouble(priceTextField.getText().trim()));
      movieTable.getItems().add(tempMovie);
      titleTextField.clear();
      yearTextField.clear();
      priceTextField.clear();
    }
  }

  @FXML
  private void deleteButton_Click()
  {
    ObservableList<Movie> selectedItems =
        movieTable.getSelectionModel().getSelectedItems();
    String message = "";
    if (selectedItems.size() == 0)
    {
      message = "Please select the items you want to delete.";
      Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
      alert.show();
    }
    else
    {
      message = selectedItems.size() == 1 ?
          "Are you sure you want to delete this item?" :
          "Are you sure you want to delete these item?";
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
          message,
          ButtonType.YES, ButtonType.NO);
      Optional<ButtonType> response = alert.showAndWait();
      if (response.isPresent()
          && response.get() == ButtonType.YES)
      {
        movieTable.getItems().removeAll(selectedItems);
      }
    }
  }
}






















