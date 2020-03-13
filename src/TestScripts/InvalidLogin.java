package TestScripts;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import POM.LoginPage;
import generic.BaseTest;
import generic.Library;
public class InvalidLogin extends BaseTest {
	@Test
	public void testInvalidLogin() throws Exception
	{
		LoginPage login = new LoginPage(driver);
		int rowCount = Library.getRowCount("TestData", "InvalidLogin");
		System.out.println("The total active rows in the InvalidLogin sheet are "+rowCount);
		for (int row=1; row<=rowCount; row++)
		{
			String userName= Library.getCellData("TestData", "InvalidLogin", row, 0);
			String passWord= Library.getCellData("TestData", "InvalidLogin", row, 1);
			login.setUsername(userName);
			login.setPassword(passWord);
			login.clickLoginButton();
			String ito = Library.getPropertyValue("IMPLICIT_WAIT");
			driver.manage().timeouts().implicitlyWait(Long.parseLong(ito), TimeUnit.SECONDS);
			driver.navigate().refresh();
			//Thread.sleep(2000);
		}
		Assert.fail();
	}
}