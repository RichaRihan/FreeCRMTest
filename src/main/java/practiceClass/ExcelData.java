
package practiceClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {

	public static String userDir = System.getProperty("user.dir");
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		FileInputStream file=new FileInputStream(userDir+"/src/main/java/com/crm/qa/testdata/MyExcelData.xlsx");
		
		Workbook book=WorkbookFactory.create(file);
		Sheet sheet=book.getSheet("Sheet1");
		
		Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			
			String runValue=sheet.getRow(i+1).getCell(2).toString();
			System.out.println(runValue);
			if(runValue.equals("Y")) {
			
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {				
				//String runValue=sheet.getRow(i+1).getCell(2).toString();
				//System.out.println(runValue);
				data[i][j]= sheet.getRow(i+1).getCell(j).toString();
				System.out.println(data[i][j]);
				}
			
			}
		}
		
		
		
		
	}

}
