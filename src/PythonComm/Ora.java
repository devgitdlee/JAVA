package PythonComm;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ora {
	//오라클 연결
   private static String user = "shopper"; 
   private static String pw = "shopper";
   private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
   private static Connection conn;
   private static Statement stmt;
   private PreparedStatement pstmt;
   private static CallableStatement pctmt; //프로시저 
   private static ResultSet rs;
   
   
   public String Procedure(String param)
   {
		try {
	        Class.forName("oracle.jdbc.driver.OracleDriver"); 
	    } catch (Exception e) {
	    	System.out.println("OraclePrivate DB 드라이버 로딩 실패 :"+ e);
		}
	    try {
	        conn = DriverManager.getConnection(url, user, pw);
	    } catch (SQLException e) {
			System.out.println("OraclePrivate DB 연결 실패: "+e);
		}
	    try {
	    	String ary[] = param.split("#");
			String E_DO_NM = ary[0];;
			String E_CT_NM = ary[1];;
			String E_B_DNG_NM = ary[2];;
			String E_LOT_MB = ary[3];;
			String E_LOT_SB = ary[4];;
			String E_BLD_NM = ary[5];;
			String E_HLD_CNT = ary[6];;
	        String sql = "{call Uploadlist(?,?,?,?,?)}";
	        pctmt = conn.prepareCall(sql);    
	        
	        pctmt.setString(1, E_DO_NM);
	        pctmt.setString(2, E_CT_NM);
	        pctmt.setString(3, E_B_DNG_NM);
	        pctmt.setString(4, E_LOT_MB);
	        pctmt.setString(5, E_LOT_SB);
	        pctmt.setString(6, E_BLD_NM);
	        pctmt.setString(7, E_HLD_CNT);
	        pctmt.registerOutParameter(8, java.sql.Types.VARCHAR);
	        pctmt.registerOutParameter(9, java.sql.Types.VARCHAR);
	        pctmt.registerOutParameter(10, java.sql.Types.VARCHAR);
	        pctmt.registerOutParameter(11, java.sql.Types.VARCHAR);
	        pctmt.registerOutParameter(12, java.sql.Types.VARCHAR);
	        pctmt.registerOutParameter(13, java.sql.Types.VARCHAR);
	        pctmt.registerOutParameter(14, java.sql.Types.VARCHAR);
	        
	        pctmt.execute();
	        String D_CPX_CD = pctmt.getString(8);
    		String D_build = pctmt.getString(9);      
    		String D_BLD_MVIN_DT = pctmt.getString(10);
    		String D_HLD_CNT = pctmt.getString(11);      
    		String D_ADDRR_BJ = pctmt.getString(12);	     
    		String D_BLD_NM = pctmt.getString(13);      
    		String D_HLD_CNT_INFO = pctmt.getString(14);   
    		String Send = "R"+D_CPX_CD+"#"+D_build+"#"+D_BLD_MVIN_DT+"#"+D_HLD_CNT+"#"+D_ADDRR_BJ+"#"+D_BLD_NM+"#"+D_HLD_CNT_INFO;
    		return Send;
	    }catch (Exception e) {
	    	System.out.println("오라클 프로시저 호출실패: "+e);
		} finally {
			try { rs.close();} catch (Exception e) {};
			try { stmt.close();} catch (Exception e) {};
			try { conn.close();} catch (Exception e) {};
		} 
		
		return null;
			
		
	    
	}
	
		
}
