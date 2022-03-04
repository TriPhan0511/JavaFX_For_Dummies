package com.batch164.pharmacyapp.utils.filehandler;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHandler
{
  public static void writeToFile(String fileName, String url, String user, String password)
  {
    url = "jdbc.url=jdbc:sqlserver://localhost:1433;databaseName=" + url;
    user = "jdbc.user=" + user;
    password = "jdbc.password=" + password;
    try (FileWriter file = new FileWriter(fileName);
         PrintWriter stream = new PrintWriter(file))
    {
      stream.println(url);
      stream.println(user);
      stream.println(password);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
