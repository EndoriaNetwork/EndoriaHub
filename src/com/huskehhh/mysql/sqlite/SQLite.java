package com.huskehhh.mysql.sqlite;

import com.huskehhh.mysql.Database;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLite
  extends Database
{
  private final String dbLocation;
  
  public SQLite(String dbLocation)
  {
    this.dbLocation = dbLocation;
  }
  
  public Connection openConnection()
    throws SQLException, ClassNotFoundException
  {
    if (checkConnection()) {
      return this.connection;
    }
    File dataFolder = new File("sqlite-db/");
    if (!dataFolder.exists()) {
      dataFolder.mkdirs();
    }
    File file = new File(dataFolder, this.dbLocation);
    if (!file.exists()) {
      try
      {
        file.createNewFile();
      }
      catch (IOException e)
      {
        System.out.println("Unable to create database!");
      }
    }
    Class.forName("org.sqlite.JDBC");
    
    this.connection = DriverManager.getConnection("jdbc:sqlite:" + dataFolder + "/" + this.dbLocation);
    
    return this.connection;
  }
}
