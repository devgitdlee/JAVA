package Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import sun.misc.*;
import java.sql.*;

public class MSsqlConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Declare the JDBC Object
        String ip = "localhost";
        String db = "shopping";
        String connectionUrl = "jdbc:sqlserver://"+ip+";databaseName="+db+";";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
	      // Establish the connection.
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          System.out.println("Driver okay");
          con = DriverManager.getConnection(connectionUrl,"sa","ms1234");
          System.out.println("Connection Made");
		
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
	}

}
