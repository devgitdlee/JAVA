package Function;

import java.sql.Statement;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.SystemOutLogger;

import com.oracle.tools.packager.RelativeFileSet.Type;



/*
 * 오라클 전용 
 * 2018.08.13 오라클 연결 
 * 추가로 필요한 기능 : 조회 추가 수정 삭제
 * 추가로 필요한 기능 : 프로시저 
 * 추가로 필요한 기능 : 조회 데이터 반환
 * 추가로 필요한 기능 : 추가 수정 삭제 해당하는 액션이 제대로 실행됐는지 반환값 
 * 추가로 필요한 기능 : 반환값에서 해당하는 메세지 출력(다른 클래스 정의)
 */

public class OraclePrivate {
	//오라클 연결
   private static String user = "shopper"; 
   private static String pw = "shopper";
   private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
   private static Connection conn;
   private static Statement stmt;
   private PreparedStatement pstmt;
   private static CallableStatement pctmt; //프로시저 
   private static ResultSet rs;
	
   //오라클 insert, update, delete 제대로 실행됐는지 반환값 
   public void OracleInUpDe(String sql) {
	    try {
	        Class.forName("oracle.jdbc.driver.OracleDriver"); 
	    } catch (Exception e) {
	    	System.out.println("OraclePrivate DB 드라이버 로딩 실패 :"+ e);
		}
	    try {
	        conn = DriverManager.getConnection(url, user, pw);
	        
	        System.out.println("Database에 연결되었습니다.\n");
	    
	    } catch (SQLException e) {
			System.out.println("OraclePrivate DB 연결 실패: "+e);
			return;
		}
	    try {
	    	pstmt = conn.prepareStatement(sql); 
	    	
	    	int cnt = pstmt.executeUpdate();
	    } catch (Exception e) {
	    	System.out.println("OraclePrivate DB 쿼리 실패 :"+ e);// TODO: handle exception
	    } finally {
			try { rs.close();} catch (Exception e) {};
			try { stmt.close();} catch (Exception e) {};
			try { conn.close();} catch (Exception e) {};
		}
	}
	
	//오라클 select 리스트 다시 반환기능 추가
	public static List<HashMap<String,String>> oracleSelect(String sql) {
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		
		
		try {
	        Class.forName("oracle.jdbc.driver.OracleDriver"); 
	    } catch (Exception e) {
	    	System.out.println("OraclePrivate DB 드라이버 로딩 실패 :"+ e);
		}
	    try {
	        conn = DriverManager.getConnection(url, user, pw);
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql);
	        if (rs!=null) {
	        	ResultSetMetaData rsm = rs.getMetaData();
	        	while(rs.next()) {
		        	HashMap<String, String> row = new HashMap<String, String>();
		        	
		        	for(int i=0; i<rsm.getColumnCount(); i++) {
		        		String key = rsm.getColumnName(i+1);
		        		String val = rs.getString(key);
		        		
		        		row.put(key, val);
		        	}
		        	list.add(row);
		        	
		        }
	      
	        }
	        
	    } catch (SQLException e) {
			System.out.println("OraclePrivate DB 연결 실패: "+e);
		} finally {
			try { rs.close();} catch (Exception e) {};
			try { stmt.close();} catch (Exception e) {};
			try { conn.close();} catch (Exception e) {};
		}
		return list;
        
	}
	
	//오라클 execl 기능
	public void productExecl(String sql, String dir, String file) {			
		
		try {
	        Class.forName("oracle.jdbc.driver.OracleDriver"); 
	    } catch (Exception e) {
	    	System.out.println("OraclePrivate DB 드라이버 로딩 실패 :"+ e);
		}
	    try {
	    	HSSFWorkbook workbook = new HSSFWorkbook(); // 새 엑셀 생성
        	HSSFSheet sheet = workbook.createSheet("시트명"); // 새 시트(Sheet) 생성
	        conn = DriverManager.getConnection(url, user, pw);
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql);
	        if (rs!=null) {
	        	ResultSetMetaData rsm = rs.getMetaData();
	        	while(rs.next()) {
		        	for(int i=0; i<rsm.getColumnCount(); i++) {
		        		HSSFRow row = sheet.createRow(i); // 엑셀의 행은 0번부터 시작
			            HSSFCell cell = row.createCell(i); // 행의 셀은 0번부터 시작
		        		String key = rsm.getColumnName(i+1);
		        		String val = rs.getString(key);
		        		cell.setCellValue(val); //생성한 셀에 데이터 삽입
		        	}
		        	
		        	
		        }
	        	
	      
	            try {
	                FileOutputStream fileoutputstream = new FileOutputStream(dir+"/"+file+".xls");
	                workbook.write(fileoutputstream);
	                fileoutputstream.close();
	                System.out.println("엑셀파일생성성공");
	            } catch (IOException e) {
	            	e.printStackTrace();
	                System.out.println("엑셀파일생성실패");
	            } finally {
	            	try { rs.close();} catch (Exception e) {};
					try { stmt.close();} catch (Exception e) {};
					try { conn.close();} catch (Exception e) {};
	            }
	        }
	        
	    } catch (SQLException e) {
			System.out.println("OraclePrivate DB 연결 실패: "+e);
		} finally {
			try { rs.close();} catch (Exception e) {};
			try { stmt.close();} catch (Exception e) {};
			try { conn.close();} catch (Exception e) {};
		}
        
	}
	//제품등록 프로시저
	public static List<HashMap<String,String>> ShoppingProductinsert(String partname, String partcd, String price) {
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> row = new HashMap<String, String>();
    	
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
	        String sql = "{call product_c01(?,?,?,?,?)}";
	        pctmt = conn.prepareCall(sql);    
	        
	        pctmt.setString(1, partname);
	        pctmt.setString(2, partcd);
	        pctmt.setInt(3, Integer.parseInt(price));
	        pctmt.registerOutParameter(4, java.sql.Types.INTEGER);
	        pctmt.registerOutParameter(5, java.sql.Types.VARCHAR);
	        
	        pctmt.execute();
	        
	        int retcod = pctmt.getInt(4); // 리턴값
	        String errmsg = pctmt.getString(5); //리턴 메세지
	        row.put(Integer.toString(retcod), errmsg);
	        list.add(row);
	    }catch (Exception e) {
	    	System.out.println("오라클 프로시저 호출실패: "+e);
		} finally {
			try { rs.close();} catch (Exception e) {};
			try { stmt.close();} catch (Exception e) {};
			try { conn.close();} catch (Exception e) {};
		} 
		
		return list;
			
		
	    
	}
	
		
}
