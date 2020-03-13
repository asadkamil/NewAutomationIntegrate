package POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class UtilizationReviewPage {
	//declare the elements
	@FindBy(xpath="//option[contains(text(),'UR Review')]")
	private WebElement NewDropDownTb;
	@FindBy(xpath="//select[@ng-model='vmTrackingLog.currentTrackingLog.TimeSpentId']")
	private WebElement TimeSpentDropDown;
	@FindBy(xpath="//textarea[@ng-model='vmTrackingLog.currentTrackingLog.TrackingLogNotes']")
	private WebElement notesTB;
	@FindBy(xpath="//button[@ng-click='vmTrackingLog.saveTrackingLog()']")
	private WebElement saveButton;
		
	//initialize elements
	public UtilizationReviewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	//utilize the elements
	public void clickNewDropDown()
	{
		NewDropDownTb.click();
	}
	public void clickTimeSpentDropDown()
	{
		TimeSpentDropDown.click();
	}
	public void setNotes(String text)
	{
		notesTB.sendKeys(text);		
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}
}
