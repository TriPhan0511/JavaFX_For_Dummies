package com.batch164.pharmacyapp.utils.dao;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection
{
  /**
   * Gets a connection from the properties specified in the file database.properties.
   * @return The database connection.
   * @throws SQLException Throws an exception which type is SQLException.
   * @throws IOException Throws an exception which type is IOException.
   */
  public static Connection getConnection(String user, String password)
      throws SQLException, IOException
  {
    Properties props = new Properties();
    String drivers;
    String url;

    try (InputStream in = Files.newInputStream(Paths.get("database.properties")))
    {
      props.load(in);
    }

//    Get drivers and url from the file database.properties
    drivers = props.getProperty("jdbc.drivers");
    if (drivers != null)
    {
      System.setProperty("jdbc.drivers", drivers);
    }
    url = props.getProperty("jdbc.url");

    return DriverManager.getConnection(url, user, password);
  }
}
