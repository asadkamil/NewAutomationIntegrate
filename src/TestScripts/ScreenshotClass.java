package TestScripts;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.google.common.io.Files;
public class ScreenshotClass{
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://integratedev.myvrx.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TakesScreenshot ts = (TakesScreenshot) driver; 
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		System.out.println(srcFile);
		File destFile = new File("D:\\Screenshots\\asad.png");
		System.out.println(destFile);
		Files.copy(srcFile, destFile);
		driver.quit();
	}
}