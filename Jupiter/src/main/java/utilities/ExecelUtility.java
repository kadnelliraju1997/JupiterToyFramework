package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExecelUtility {

	public String readDataFromExcel(String sheet,int rowNum,int cellNum) throws Throwable {
		FileInputStream fis =new FileInputStream("./src/test/resources/contactData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		String data=book.getSheet(sheet).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}
	
}
