package TestScripts;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import POM.LoginPage;
import POM.MemberSearch;
import generic.BaseTest;
import generic.Library;

public class PatientSnapshotNotes extends BaseTest {
	@Test
	void testpatientSnapshotNotes() throws Exception
	{
		String userName = Library.getCellData("TestData", "ValidLogin", 1, 0);
		String passWord = Library.getCellData("TestData", "ValidLogin", 1, 1);
		//enter username
		LoginPage login = new LoginPage(driver);
		login.setUsername(userName);
		//enter valid password
		login.setPassword(passWord);
		//click on login button
		login.clickLoginButton();
		Thread.sleep(2000);	
		MemberSearch mbrSearch = new MemberSearch(driver);
		mbrSearch.clickMemSearchButton();
		mbrSearch.setFirstName("Smith");
		mbrSearch.setLastName("Hopkinson");
		mbrSearch.clickSearchButton();
		mbrSearch.viewMember();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@ng-model='vmNote.noteModel.NoteContents']")).sendKeys("hello World");
        driver.findElement(By.xpath("//button[@ng-click='vmNote.createMemberNote(vmNote.noteModel)']")).click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		System.out.println("The notes has been created successfully");
	}
}
