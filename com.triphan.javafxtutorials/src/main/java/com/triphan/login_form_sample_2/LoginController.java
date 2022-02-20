package com.triphan.login_form_sample_2;

import com.triphan.login_form_sample_2.DatabaseHandler.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController
{
  @FXML
  private TextField usernameTextField;
  @FXML
  private PasswordField passwordPasswordField;
  @FXML
  private Button loginButton;
  @FXML
  private Button cancelButton;
  @FXML
  private Label loginMessageLabel;

  @FXML
  private void loginButton_Click()
  {

    if (usernameTextField.getText().isBlank()
        || passwordPasswordField.getText().isBlank())
    {
      loginMessageLabel.setText(
          "Please enter username and password.");
    }
    else
    {
      String message = validateLogin(
          usernameTextField.getText().trim(),
          passwordPasswordField.getText().trim());
      loginMessageLabel.setText(message);
    }
  }

  @FXML
  private void cancelButton_Click(ActionEvent event)
  {
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.close();
  }

  private String validateLogin(String username, String password)
  {
    String message = "Invalid login. Please try again.";
    String sql = "SELECT COUNT(*) " +
        "FROM user_account " +
        "WHERE username = ? AND password = ?";
    try (Connection connection = DatabaseHandler.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql))
    {
      statement.setString(1, username);
      statement.setString(2, password);
      try (ResultSet resultSet = statement.executeQuery())
      {
        while (resultSet.next())
        {
          if (resultSet.getInt(1) == 1)
          {
            message = "Welcome!";
          }
        }
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return message;
  }
}





















