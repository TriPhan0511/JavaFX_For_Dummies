package com.lowewriter.layoutpane_samples;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GridPaneSample extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  //  Class fields
  Stage stage;
  TextField nameTextField,phoneNumberTextField, addressTextField;
  RadioButton smallRadioButton,mediumRadioButton, largeRadioButton;
  RadioButton thinRadioButton, thickRadioButton;
  CheckBox pepperoniCheckBox,mushroomsCheckBox, olivesCheckBox;


  @Override
  public void start(Stage primaryStage)
  {
    stage = primaryStage;

//    Create the label and text field for "name"
    Label nameLabel = new Label("Name:");
    nameTextField = new TextField();
    nameTextField.setPromptText("Enter the name here");
    nameTextField.setMinWidth(100);
    nameTextField.setPrefWidth(200);
    nameTextField.setMaxWidth(300);

//    Create the label and text field for "phone number"
    Label phoneNumberLabel = new Label("Phone:");
     phoneNumberTextField = new TextField();
    phoneNumberTextField.setPromptText("Enter the phone number here");
    phoneNumberTextField.setMinWidth(60);
    phoneNumberTextField.setPrefWidth(120);
    phoneNumberTextField.setMaxWidth(180);

//    Create the label and text field for "address"
    Label addressLabel = new Label("Address:");
    addressTextField = new TextField();
    addressTextField.setPromptText("Enter the address here");
    addressTextField.setMinWidth(100);
    addressTextField.setPrefWidth(200);
    addressTextField.setMaxWidth(300);

//    Create a "size" pane
    Label sizeLabel = new Label("Size");
    smallRadioButton = new RadioButton("Small");
    mediumRadioButton = new RadioButton("Medium");
    largeRadioButton = new RadioButton("Large");
    ToggleGroup sizeToggleGroup = new ToggleGroup();
    smallRadioButton.setToggleGroup(sizeToggleGroup);
    mediumRadioButton.setToggleGroup(sizeToggleGroup);
    largeRadioButton.setToggleGroup(sizeToggleGroup);
    mediumRadioButton.setSelected(true);
    VBox sizePane = new VBox(10, sizeLabel,
        smallRadioButton, mediumRadioButton, largeRadioButton);

//    Create a "style" pane
    Label styleLabel = new Label("Style");
    thinRadioButton = new RadioButton("Thin");
    thickRadioButton = new RadioButton("Thick");
    ToggleGroup styleToggleGroup = new ToggleGroup();
    thinRadioButton.setToggleGroup(styleToggleGroup);
    thickRadioButton.setToggleGroup(styleToggleGroup);
    thinRadioButton.setSelected(true);
    VBox stylePane = new VBox(10, styleLabel,
        thinRadioButton, thickRadioButton);

//    Create a "toppings" pane
    Label toppingsLabel = new Label("Toppings");
    pepperoniCheckBox = new CheckBox("Pepperoni");
    mushroomsCheckBox = new CheckBox("Mushrooms");
    olivesCheckBox = new CheckBox("Olives");
    mushroomsCheckBox.setSelected(true);
    olivesCheckBox.setSelected(true);
    VBox toppingsPane = new VBox(10, toppingsLabel,
        pepperoniCheckBox, mushroomsCheckBox, olivesCheckBox);

//    Create a "buttons" pane
    Button okButton = new Button("OK");
    okButton.setPrefWidth(80);
    okButton.setOnAction(e -> okButton_Click());
    Button closeButton = new Button("Close");
    closeButton.setPrefWidth(80);
    closeButton.setOnAction(e -> closeButton_Click());
    HBox buttonsPane = new HBox(10, okButton, closeButton);

//    Create a GridPane
    GridPane root = new GridPane();
    root.setHgap(10);
    root.setVgap(10);
    root.setPadding(new Insets(10));
    root.setMinWidth(500);
    root.setPrefWidth(500);
    root.setMaxWidth(800);

//    Add the nodes to the root
    root.addRow(0, nameLabel, nameTextField);
    root.addRow(1, phoneNumberLabel, phoneNumberTextField);
    root.addRow(2, addressLabel, addressTextField);
    root.addRow(3, sizePane, stylePane, toppingsPane);
    root.add(buttonsPane, 2, 4);
    root.setBorder(new Border(new BorderStroke(Color.YELLOWGREEN,
        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

//    Set column widths
    ColumnConstraints col1 = new ColumnConstraints();
    col1.setPercentWidth(33);
    ColumnConstraints col2 = new ColumnConstraints();
    col2.setPercentWidth(33);
    ColumnConstraints col3 = new ColumnConstraints();
    col3.setPercentWidth(33);
    root.getColumnConstraints().addAll(col1, col2, col3);

//    Set spans
    GridPane.setColumnSpan(nameTextField,2);
    GridPane.setColumnSpan(phoneNumberTextField, 2);
    GridPane.setColumnSpan(addressTextField, 2);

//    Set alignments
    GridPane.setHalignment(nameLabel,HPos.RIGHT);
    GridPane.setHalignment(phoneNumberLabel, HPos.RIGHT);
    GridPane.setHalignment(addressLabel,HPos.RIGHT);

//    Finish
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setTitle("GridPane Sample");
    primaryStage.setMinWidth(500);
    primaryStage.setMaxWidth(900);
    primaryStage.show();
  }

  private void closeButton_Click()
  {
    stage.close();
  }

  private void okButton_Click()
  {
    StringBuilder builder = new StringBuilder();
    builder.append("You chose:");

    builder.append("\n\tSize: ");
    if (smallRadioButton.isSelected())
    {
      builder.append("small,");
    }
    if (mediumRadioButton.isSelected())
    {
      builder.append("medium,");
    }
    if (largeRadioButton.isSelected())
    {
      builder.append("large,");
    }

    builder.append("\n\tstyle: ");
    if (thinRadioButton.isSelected())
    {
      builder.append("thin,");
    }
    if (thickRadioButton.isSelected())
    {
      builder.append("thick,");
    }

    builder.append("\n\ttoppings: ");
    String toppings = "";
    toppings = buildToppings(pepperoniCheckBox, toppings);
    toppings = buildToppings(mushroomsCheckBox, toppings);
    toppings = buildToppings(olivesCheckBox, toppings);
    if (toppings.equals(""))
    {
      toppings = "You did not choose any toppings.";
    }
    else if (toppings.endsWith(", "))
    {
      toppings = toppings.substring(0, toppings.length() - 2);
      toppings += ".";
    }
    builder.append(toppings);

    Alert alert = new Alert(Alert.AlertType.INFORMATION, builder.toString());
    alert.showAndWait();
  }

  private String buildToppings(CheckBox checkBox, String toppings)
  {
    if (checkBox.isSelected())
    {
      toppings += checkBox.getText();
      toppings += ", ";
    }
    else
    {
      toppings += "";
    }
    return toppings;
  }
}





































