package generic;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class BaseTest implements IAutoConstant 
{
	public static WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		//set the path of chromedriver
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		//Launch the ChromeBrowser
		driver = new ChromeDriver();
		//enter the Project URL
		driver.get(Library.getPropertyValue("PROJECT_URL"));
		//driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		//set implicit time period to launch fully for 10 secomds.
		String ito = Library.getPropertyValue("IMPLICIT_WAIT");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(ito), TimeUnit.SECONDS);
		//for Firefox driver
		/*	System.setProperty(GECKO_KEY, GECKO_VALUE);
		driver = new FirefoxDriver();
		driver.get(Utilities.getPropertyValue("URL"));*/	
	}
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		//capture screenshot if @TestMethod fails
		if(ITestResult.FAILURE==result.getStatus()) 
		{
			Library.captureScreenshot(driver, result.getName());	
		}
		//close the Browser
		driver.quit();
	}
}

