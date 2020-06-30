package com.opentext.bn.lens.cmd;


import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import org.testng.annotations.Test;

public class Postgres_Connection_lens {
	
	
	private static Connection connection;
    private static Statement statement;
    private static ResultSet rs;
    
    private static final String user = "readonly";
    private static final String password = "XtKkF2T8ILi7Lbgf";
    
 
    private static final String databaseURL = "jdbc:postgresql://10.9.200.183:9999/lens";
    
    
    
    @Test
    public static  List<String> getDataFromDataBase(String sqlQuery, String... columnNames) throws ClassNotFoundException {
                    List<String> resultSet = new ArrayList<String>();
                    try {
                                   // Class.forName("oracle.jdbc.driver.OracleDriver");
                                  //  System.out.println("Connecting to Database...");
                                    connection = DriverManager.getConnection(databaseURL, user, password);
                                    if (connection != null) {
                                                    System.out.println("Connected to the Database...");
                                    }
                                    
                                    Statement stmt = (Statement) connection.createStatement();
                                    
                                   /*
                                    try {
                                   	 Thread.sleep(10000);
                                   	 }
                                   	 catch (InterruptedException ex) {
                                   		 
                                   		 
                                   	 }
                                   	 
                                   	 */
                                    
                                    //  ResultSet rs=stmt.executeQuery("select * from IC where S_LOGNO=01535257684");
                                     ResultSet rs = stmt.executeQuery(sqlQuery);
                                     
                                    
                                     
                                 //    String[]  columnNames={"serviceref","status","s_correlationid","Routingtype","s_datafn"};
                                     
                                     
                                     while (rs.next()) {
                                                     for (String columnName1 : columnNames) {
                                                    	 
                                                    	 System.out.println("the Column name needed is ..."+columnName1);
                                                                     resultSet.add(rs.getString(columnName1));
                                                                     if (resultSet==null) {
                                                                    	 try {
                                                                    	 Thread.sleep(10000);
                                                                    	 }
                                                                    	 catch (InterruptedException ex) {
                                                                    		 
                                                                    		 
                                                                    	 }
                                                                     }                                                     }
                                     }
                                    
                                   
                                    if (connection != null) {
                                                    System.out.println("Closing Database Connection...");
                                                     connection.close();
                                    }
                    } catch (SQLException ex) {
                                    ex.printStackTrace();
                    }
                   return resultSet;

    }
    
    
	  

}
