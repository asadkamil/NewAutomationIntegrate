package TestScripts;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.BaseTest;

public class FindElementsInIRCTC extends BaseTest {

	@Test
	public static void findElements()
	{
		driver.get("https://www.irctc.co.in/nget/train-search");
		List <WebElement> allElements =  driver.findElements(By.id("M"));
		System.out.println("number of elements are :"+allElements.size());
	}
}
