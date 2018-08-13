package Function;

import java.sql.*;

public class DbConnect {
	
	
	//오라클 연결
	public void OracleConnection() {
		Connection conn = null;
        try {
            String user = "shopper"; 
            String pw = "shopper";
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            
            Class.forName("oracle.jdbc.driver.OracleDriver");        
            conn = DriverManager.getConnection(url, user, pw);
            
            System.out.println("Database에 연결되었습니다.\n");
            
        } catch (ClassNotFoundException cnfe) {
            System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
        } catch (SQLException sqle) {
            System.out.println("DB 접속실패 : "+sqle.toString());
        } catch (Exception e) {
            System.out.println("Unkonwn error");
            e.printStackTrace();
        }
	}
	
	//MS-SQL 연결
	public void MssqlConnection() {
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
		
		} catch (ClassNotFoundException cnfe) {
	        System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
	    } catch (SQLException sqle) {
	        System.out.println("DB 접속실패 : "+sqle.toString());
	    } catch (Exception e) {
	        System.out.println("Unkonwn error");
	        e.printStackTrace();
	    }
	}
	
	//MY-SQL 연결
	public void MysqlConnection() {
				
	}

}
