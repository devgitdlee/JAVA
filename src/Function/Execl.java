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
	//sql = 데이터, dir = 경로, file = 파일이름
    public void ExeclInsert(String dir, String file) {
        
    	HSSFWorkbook workbook = new HSSFWorkbook(); // 새 엑셀 생성
    	HSSFSheet sheet = workbook.createSheet("시트명"); // 새 시트(Sheet) 생성
        HSSFRow row = sheet.createRow(0); // 엑셀의 행은 0번부터 시작
        HSSFCell cell = row.createCell(0); // 행의 셀은 0번부터 시작
        cell.setCellValue("테스트 데이터"); //생성한 셀에 데이터 삽입
        try {
            FileOutputStream fileoutputstream = new FileOutputStream(dir+"/"+file+".xlsx");
            workbook.write(fileoutputstream);
            fileoutputstream.close();
            System.out.println("엑셀파일생성성공");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("엑셀파일생성실패");
        }
    	
    }
    public void Execlout(String dir, String file) {
    	 try {
             FileInputStream fis = new FileInputStream(dir+"/"+file+".xls");
             HSSFWorkbook workbook = new HSSFWorkbook(fis);
             HSSFSheet sheet = workbook.getSheetAt(0); // 해당 엑셀파일의 시트(Sheet) 수
             int rows = sheet.getPhysicalNumberOfRows(); // 해당 시트의 행의 개수
             for (int rowIndex = 1; rowIndex < rows; rowIndex++) {
                 HSSFRow row = sheet.getRow(rowIndex); // 각 행을 읽어온다
                 if (row != null) {
                     int cells = row.getPhysicalNumberOfCells();
                     for (int columnIndex = 0; columnIndex <= cells; columnIndex++) {
                         HSSFCell cell = row.getCell(columnIndex); // 셀에 담겨있는 값을 읽는다.
                         String value = "";
                         switch (cell.getCellType()) { // 각 셀에 담겨있는 데이터의 타입을 체크하고 해당 타입에 맞게 가져온다.
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
