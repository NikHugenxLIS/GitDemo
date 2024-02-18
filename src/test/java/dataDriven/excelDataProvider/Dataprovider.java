package dataDriven.excelDataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider 
{
	//multiple sets of dat to our tests
	//Array public
	//Sets of data as 5 arrays from data provider to your tests
	//then your tests will run 5 times with separate sets of data (arrays)
	
	
	DataFormatter formatter = new DataFormatter();
	@Test(dataProvider="driveTest")
	public void testCaseData(String Greeting,String Communication,String Id)
	{
		System.out.println(Greeting+Communication+Id);
		
	}
	
	@DataProvider(name="driveTest")
	public Object[][] getData() throws IOException
	{
		//Object[][] data = { {"hello","text","1"},{"bye","message","143"},{"solo","call","143"} };
		//every row of excel should be sent to Array
		//return data;
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\excelDriven.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		Object data[][] = new Object[rowCount-1][colCount];
		for(int i=0;i<rowCount-1;i++)
		{
			row= sheet.getRow(i+1);
			for(int j=0;j<colCount;j++)
			{
				XSSFCell cell = row.getCell(j);
				
				data[i][j]= formatter.formatCellValue(cell);
			}
		}
		return data;
		
	}

}
