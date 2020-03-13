package generic;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.google.common.io.Files;
public class Library implements IAutoConstant{
	public static WebDriver driver;
	public static Workbook wb;

	//get propertyvalue from property file
	public static String getPropertyValue(String propertyName)
	{
		String getPropertyValue = "";
		try {
			Properties prop = new Properties();
			//load the property file
			prop.load(new FileInputStream(CONFIG_FILE_PATH));
			getPropertyValue = prop.getProperty(propertyName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getPropertyValue;
	}
	//capture Screenshot method
	public static void captureScreenshot(WebDriver driver, String testMethodName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			String currentDateAndTime = new Date().toString().replaceAll(":", "_");
			File destFile = new File(SCREENSHOTS_FILE_PATH+testMethodName+"_"+currentDateAndTime+".png");
			Files.copy(srcFile, destFile);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	//getexcelsheet data

	public static String getCellData(String excelFileName, String sheetName, int rowNum, int colNum)
	{
		String cellVale = " ";
		try {
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_FILE_PATH +excelFileName+".xlsx"));
			cellVale = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).toString();
		}		
		catch (Exception e) {
			e.printStackTrace();
		}
		return cellVale;
	}

	//getRowCount for excelsheet
	public static int getRowCount(String excelFileName, String sheetName)
	{
		int rowCount = 0;

		try {
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_FILE_PATH+excelFileName+ ".xlsx"));
			Sheet sh = wb.getSheet(sheetName);
			rowCount = sh.getLastRowNum();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
		return rowCount;		
	}
}
