import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\Documents\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int sheets = workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				
			Iterator<Row> rows = sheet.iterator();
			Row firstrow = rows.next();
			Iterator<Cell> ce = firstrow.cellIterator();
			int k = 0;
			int column = 0;
			while(ce.hasNext()) {
				Cell value = ce.next();
				if(value.getStringCellValue().equalsIgnoreCase("TestCase")) {
					column=k;
				}
				k++;
			}
			System.out.println(column);
			}
		}
		//We can also use excel with dataProvider Testng (notes+rahul shetty)
	}
}