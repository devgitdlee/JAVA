package DataInsert;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import Function.Execl;
import Function.OraclePrivate;

public class OraSqlData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		OraclePrivate ora = new OraclePrivate();
		//Execl exe = new Execl();
		String sql = "select * from product where partname is not null";
		//String dir = "C:\\Users\\LSJ\\Documents\\�ڵ�\\�׽�Ʈ";
		//String file = "Test3";
		//ora.productExecl(sql, dir, file);
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		list = ora.oracleSelect(sql);
		System.out.println(ora.oracleSelect(sql));
		
		//exe.ExeclInsert(dir, file); 
		/*
		String partname = "������1800";
		String partcd = "RZ18";
		String pri = "270000";
		
		System.out.println(ora.ShoppingProductinsert(partname, partcd, pri));
		*/
		/*
        int max = 3500000;
        int min = 150000;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date;
	
        Calendar cal = Calendar.getInstance();
        */
        
        /*�ǹ� ���̺� ����� ���� ������ ����
         *������ ���� ���� 150000~3500000 ���̷� ������ ���� ����
         *�ش� ��¥�� ���ؼ� �ش� �⵵ 1��1�Ϻ��� 200�ϱ��� �Է�
        */
        /*
        for(int i=0; i<200; i++) {
        	Random ran = new Random();
        	int price = ran.nextInt(max - min + 1) + min;
        	try {
        		date = df.parse("2018-01-01");
				cal.setTime(date);
				cal.add(Calendar.DATE, i);
				//System.out.println("��¥ Ȯ��"+df.format(cal.getTime()));
				//String day = df.format(cal.getTime());
				//System.out.println(day);
			} catch (ParseException e) {
				System.out.println("��¥ ��ȯ�� ����"+e);
			}  
        	
        	String sql = "INSERT INTO "+
			             "Product("+
        			     "price, pdate) "+
			             "values("+Integer.toString(price)+","+
			             "'"+df.format(cal.getTime())+"')";
        	
        	
        	String sql = "update product"+
        				 "   set price = 2000000"+
        			     " where price <=2500000";
        	
        	
        	//String sql = "select * from product";
        	
        	
        	System.out.println(ora.oracleSelect(sql));
        	//System.out.println(sql);
        	
        	//ora.OracleInUpDe(sql);
        	
        		
        }
        
        */
    	
        
	}
	

}
