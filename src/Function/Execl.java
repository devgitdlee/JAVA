package Function;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class Execl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//sql = ������, dir = ���, file = �����̸�
    public void ExeclInsert(String dir, String file) {
        
    	HSSFWorkbook workbook = new HSSFWorkbook(); // �� ���� ����
    	HSSFSheet sheet = workbook.createSheet("��Ʈ��"); // �� ��Ʈ(Sheet) ����
        HSSFRow row = sheet.createRow(0); // ������ ���� 0������ ����
        HSSFCell cell = row.createCell(0); // ���� ���� 0������ ����
        cell.setCellValue("�׽�Ʈ ������"); //������ ���� ������ ����
        try {
            FileOutputStream fileoutputstream = new FileOutputStream(dir+"/"+file+".xlsx");
            workbook.write(fileoutputstream);
            fileoutputstream.close();
            System.out.println("�������ϻ�������");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("�������ϻ�������");
        }
    	
    }
    public void Execlout(String dir, String file) {
    	 try {
             FileInputStream fis = new FileInputStream(dir+"/"+file+".xls");
             HSSFWorkbook workbook = new HSSFWorkbook(fis);
             HSSFSheet sheet = workbook.getSheetAt(0); // �ش� ���������� ��Ʈ(Sheet) ��
             int rows = sheet.getPhysicalNumberOfRows(); // �ش� ��Ʈ�� ���� ����
             for (int rowIndex = 1; rowIndex < rows; rowIndex++) {
                 HSSFRow row = sheet.getRow(rowIndex); // �� ���� �о�´�
                 if (row != null) {
                     int cells = row.getPhysicalNumberOfCells();
                     for (int columnIndex = 0; columnIndex <= cells; columnIndex++) {
                         HSSFCell cell = row.getCell(columnIndex); // ���� ����ִ� ���� �д´�.
                         String value = "";
                         switch (cell.getCellType()) { // �� ���� ����ִ� �������� Ÿ���� üũ�ϰ� �ش� Ÿ�Կ� �°� �����´�.
                         case HSSFCell.CELL_TYPE_NUMERIC:
                             value = cell.getNumericCellValue() + "";
                             break;
                         case HSSFCell.CELL_TYPE_STRING:
                             value = cell.getStringCellValue() + "";
                             break;
                         case HSSFCell.CELL_TYPE_BLANK:
                             value = cell.getBooleanCellValue() + "";
                             break;
                         case HSSFCell.CELL_TYPE_ERROR:
                             value = cell.getErrorCellValue() + "";
                             break;
                         }
                         System.out.println(value);
                     }
                 }
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
}
