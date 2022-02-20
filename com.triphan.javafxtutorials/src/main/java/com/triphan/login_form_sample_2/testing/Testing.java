package com.triphan.login_form_sample_2.testing;

import com.triphan.login_form_sample_2.DatabaseHandler.DatabaseHandler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Testing
{
  public static void main(String[] args)
  {
    showAccounts();
  }

  private static void showAccounts()
  {
    String sql = "SELECT username, first_name, last_name FROM user_account";
    try (Connection connection = DatabaseHandler.getConnection();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(sql))
    {
      while (resultSet.next())
      {
        System.out.println(resultSet.getString("username"));
        System.out.println(resultSet.getString("first_name"));
        System.out.println(resultSet.getString("last_name"));
        System.out.println();
      }

    } catch (SQLException e)
    {
      e.printStackTrace();
    } catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
