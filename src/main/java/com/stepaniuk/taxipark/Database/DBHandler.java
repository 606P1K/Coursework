package com.stepaniuk.taxipark.Database;

import com.stepaniuk.taxipark.API.LogClass;

import java.sql.*;

public class DBHandler extends Configs{
   static Connection dbConnection;

   public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
      LogClass.logger.info("Use the getDbConnection method");
      String connectionString = "jdbc:sqlserver://" + dbHost + ":" + dbPort + ";databaseName=" + dbName+";encrypt=true;" +
              "trustServerCertificate=true;allowMultiQueries=true";
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
      return dbConnection;
   }
}
