package TestScripts;
import org.testng.annotations.Test;
import POM.LoginPage;
import POM.MemberSearch;
import POM.UtilizationReviewPage;
import generic.BaseTest;
import generic.Library;
public class UR_Review extends BaseTest{
	@Test
	public void testUtilizationReview() throws Exception
	{
		String userName = Library.getCellData("TestData", "ValidLogin", 1, 0);
		String passWord = Library.getCellData("TestData", "ValidLogin", 1, 1);
		//enter username
		LoginPage login = new LoginPage(driver); //creating object for POM
		login.setUsername(userName);
		//enter valid password
		login.setPassword(passWord);
		//click on login button
		login.clickLoginButton();
		Thread.sleep(1000);	
		MemberSearch mbrSearch = new MemberSearch(driver);//creating object for POM
		mbrSearch.clickMemSearchButton();
		mbrSearch.setFirstName("Smith");
		mbrSearch.setLastName("Hopkinson");
		mbrSearch.clickSearchButton();
		mbrSearch.viewMember();
		Thread.sleep(1000);
		mbrSearch.clickCareManagementTB();
		mbrSearch.clickCMDashBoard();
		Thread.sleep(2000);
		mbrSearch.clickUtilizationReviewTB();
		mbrSearch.clickURDashboad();
		Thread.sleep(1000);
		mbrSearch.clickReviewSubTab();
		//Thread.sleep(1000);
		UtilizationReviewPage utR = new UtilizationReviewPage(driver); //creating object for POM
		utR.clickNewDropDown();
		Thread.sleep(1000);
		driver.quit();
	}
}