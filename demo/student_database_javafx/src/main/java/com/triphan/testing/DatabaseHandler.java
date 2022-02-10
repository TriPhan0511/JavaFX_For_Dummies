package com.triphan.testing;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseHandler
{
  /**
   * Gets a connection from the properties specified in the file database.properties.
   * @return The database connection.
   * @throws SQLException
   * @throws IOException
   */
  public static Connection getConnection()
      throws SQLException, IOException
  {
    Properties props = new Properties();
    String drivers;
    String url;
    String user;
    String password;

    try (InputStream in = Files.newInputStream(Paths.get("database.properties")))
    {
      props.load(in);
    }

    drivers = props.getProperty("jdbc.drivers");
    if (drivers != null)
    {
      System.setProperty("jdbc.drivers", drivers);
    }

    url = props.getProperty("jdbc.url");
    user = props.getProperty("jdbc.user");
    password = props.getProperty("jdbc.password");

    return DriverManager.getConnection(url, user, password);
  }
}























