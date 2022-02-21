package com.lowewriter.working_with_tables;

import com.lowewriter.working_with_tables.model.Movie;
import com.lowewriter.working_with_tables.model.SampleData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ReadOnlyTableController implements Initializable
{

  @FXML
  private TableView<Movie> movieTable;
  @FXML
  private TableColumn<Movie, String> titleColumn;
  @FXML
  private TableColumn<Movie, Integer> yearColumn;
  @FXML
  private TableColumn<Movie, Double> priceColumn;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle)
  {
//    Set data for the movieTable
    movieTable.setItems(SampleData.loadData());

//    Set properties from the table's collection with the columns
      titleColumn.setCellValueFactory(
          new PropertyValueFactory<Movie, String>("title"));
    yearColumn.setCellValueFactory(
        new PropertyValueFactory<Movie, Integer>("year"));
    priceColumn.setCellValueFactory(
        new PropertyValueFactory<Movie, Double>("price"));
  }
}





























