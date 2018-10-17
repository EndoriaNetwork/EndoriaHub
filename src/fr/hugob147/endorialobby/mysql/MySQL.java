package fr.hugob147.endorialobby.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL
{
  private static Connection conn;
  
  public void connect(String host, String database, int port, String user, String password)
  {
    if (!isConnected()) {
      try
      {
        conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);
        System.out.println("Connexion etablie avec la base de donnees");
      }
      catch (SQLException e)
      {
        e.printStackTrace();
        System.out.println("Connexion refuse avec la base de donnees");
      }
    }
  }
  
  public void disconnect()
  {
    if (isConnected()) {
      try
      {
        conn.close();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public boolean isConnected()
  {
    try
    {
      if ((conn == null) || (conn.isClosed()) || (conn.isValid(5))) {
        return false;
      }
      return true;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return false;
  }
  
  public static Connection getConnection()
  {
    return conn;
  }
}
