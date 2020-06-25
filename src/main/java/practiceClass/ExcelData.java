
package practiceClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelData {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		FileInputStream file=new FileInputStream("/FreeCRMTest/src/main/java/com/crm/qa/testdata/MyExcelData.xlsx");
		
		Workbook book=WorkbookFactory.create(file);
		Sheet sheet=book.getSheet("Sheet1");
		
		Object data[][]=new Object[sheet.getRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]= sheet.getRow(i+1).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}
		
		
		
		
	}

}
