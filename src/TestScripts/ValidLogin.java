package TestScripts;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import POM.LoginPage;
import generic.BaseTest;
import generic.Library;

public class ValidLogin extends BaseTest{
	@Test
	void testValidLogin() throws Exception {
		LoginPage login = new LoginPage(driver);
		//enter valid username from excelfile
		String username = Library.getCellData("TestData", "ValidLogin", 1, 0);
		String password = Library.getCellData("TestData", "ValidLogin", 1, 1);
		//enter username
		login.setUsername(username);
		//enter valid password
		login.setPassword(password);
		//click on login button
		login.clickLoginButton();
		//Wait till the home page is loaded -- using Explicit wait
		Thread.sleep(4000);		
		//String ito = Library.getPropertyValue("IMPLICIT_WAIT");
		//driver.manage().timeouts().implicitlyWait(Long.parseLong(ito), TimeUnit.SECONDS);
		String actHPTitle = driver.getTitle();
		System.out.println("The title is "+actHPTitle);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleIs("VRx Integrate | Integrate"));
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actHPTitle, "VRx Integrate | Integrate");
		System.out.println("The title matched hence Login is successful");
		//validate that home page is displayed or not
		//Assert.assertEquals(driver.getTitle(),"I dont know....");
		//Assert.fail("forcibly failing this testcase...");
	}
}