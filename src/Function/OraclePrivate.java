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
 * ����Ŭ ���� 
 * 2018.08.13 ����Ŭ ���� 
 * �߰��� �ʿ��� ��� : ��ȸ �߰� ���� ����
 * �߰��� �ʿ��� ��� : ���ν��� 
 * �߰��� �ʿ��� ��� : ��ȸ ������ ��ȯ
 * �߰��� �ʿ��� ��� : �߰� ���� ���� �ش��ϴ� �׼��� ����� ����ƴ��� ��ȯ�� 
 * �߰��� �ʿ��� ��� : ��ȯ������ �ش��ϴ� �޼��� ���(�ٸ� Ŭ���� ����)
 */

public class OraclePrivate {
	//����Ŭ ����
   private static String user = "shopper"; 
   private static String pw = "shopper";
   private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
   private static Connection conn;
   private static Statement stmt;
   private PreparedStatement pstmt;
   private static CallableStatement pctmt; //���ν��� 
   private static ResultSet rs;
	
   //����Ŭ insert, update, delete ����� ����ƴ��� ��ȯ�� 
   public void OracleInUpDe(String sql) {
	    try {
	        Class.forName("oracle.jdbc.driver.OracleDriver"); 
	    } catch (Exception e) {
	    	System.out.println("OraclePrivate DB ����̹� �ε� ���� :"+ e);
		}
	    try {
	        conn = DriverManager.getConnection(url, user, pw);
	        
	        System.out.println("Database�� ����Ǿ����ϴ�.\n");
	    
	    } catch (SQLException e) {
			System.out.println("OraclePrivate DB ���� ����: "+e);
			return;
		}
	    try {
	    	pstmt = conn.prepareStatement(sql); 
	    	
	    	int cnt = pstmt.executeUpdate();
	    } catch (Exception e) {
	    	System.out.println("OraclePrivate DB ���� ���� :"+ e);// TODO: handle exception
	    } finally {
			try { rs.close();} catch (Exception e) {};
			try { stmt.close();} catch (Exception e) {};
			try { conn.close();} catch (Exception e) {};
		}
	}
	
	//����Ŭ select ����Ʈ �ٽ� ��ȯ��� �߰�
	public static List<HashMap<String,String>> oracleSelect(String sql) {
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		
		
		try {
	        Class.forName("oracle.jdbc.driver.OracleDriver"); 
	    } catch (Exception e) {
	    	System.out.println("OraclePrivate DB ����̹� �ε� ���� :"+ e);
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
			System.out.println("OraclePrivate DB ���� ����: "+e);
		} finally {
			try { rs.close();} catch (Exception e) {};
			try { stmt.close();} catch (Exception e) {};
			try { conn.close();} catch (Exception e) {};
		}
		return list;
        
	}
	
	//����Ŭ execl ���
	public void productExecl(String sql, String dir, String file) {			
		
		try {
	        Class.forName("oracle.jdbc.driver.OracleDriver"); 
	    } catch (Exception e) {
	    	System.out.println("OraclePrivate DB ����̹� �ε� ���� :"+ e);
		}
	    try {
	    	HSSFWorkbook workbook = new HSSFWorkbook(); // �� ���� ����
        	HSSFSheet sheet = workbook.createSheet("��Ʈ��"); // �� ��Ʈ(Sheet) ����
	        conn = DriverManager.getConnection(url, user, pw);
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql);
	        if (rs!=null) {
	        	ResultSetMetaData rsm = rs.getMetaData();
	        	while(rs.next()) {
		        	for(int i=0; i<rsm.getColumnCount(); i++) {
		        		HSSFRow row = sheet.createRow(i); // ������ ���� 0������ ����
			            HSSFCell cell = row.createCell(i); // ���� ���� 0������ ����
		        		String key = rsm.getColumnName(i+1);
		        		String val = rs.getString(key);
		        		cell.setCellValue(val); //������ ���� ������ ����
		        	}
		        	
		        	
		        }
	        	
	      
	            try {
	                FileOutputStream fileoutputstream = new FileOutputStream(dir+"/"+file+".xls");
	                workbook.write(fileoutputstream);
	                fileoutputstream.close();
	                System.out.println("�������ϻ�������");
	            } catch (IOException e) {
	            	e.printStackTrace();
	                System.out.println("�������ϻ�������");
	            } finally {
	            	try { rs.close();} catch (Exception e) {};
					try { stmt.close();} catch (Exception e) {};
					try { conn.close();} catch (Exception e) {};
	            }
	        }
	        
	    } catch (SQLException e) {
			System.out.println("OraclePrivate DB ���� ����: "+e);
		} finally {
			try { rs.close();} catch (Exception e) {};
			try { stmt.close();} catch (Exception e) {};
			try { conn.close();} catch (Exception e) {};
		}
        
	}
	//��ǰ��� ���ν���
	public static List<HashMap<String,String>> ShoppingProductinsert(String partname, String partcd, String price) {
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> row = new HashMap<String, String>();
    	
		try {
	        Class.forName("oracle.jdbc.driver.OracleDriver"); 
	    } catch (Exception e) {
	    	System.out.println("OraclePrivate DB ����̹� �ε� ���� :"+ e);
		}
	    try {
	        conn = DriverManager.getConnection(url, user, pw);
	    } catch (SQLException e) {
			System.out.println("OraclePrivate DB ���� ����: "+e);
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
	        
	        int retcod = pctmt.getInt(4); // ���ϰ�
	        String errmsg = pctmt.getString(5); //���� �޼���
	        row.put(Integer.toString(retcod), errmsg);
	        list.add(row);
	    }catch (Exception e) {
	    	System.out.println("����Ŭ ���ν��� ȣ�����: "+e);
		} finally {
			try { rs.close();} catch (Exception e) {};
			try { stmt.close();} catch (Exception e) {};
			try { conn.close();} catch (Exception e) {};
		} 
		
		return list;
			
		
	    
	}
	
		
}
