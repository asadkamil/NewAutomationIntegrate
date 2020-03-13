package POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MemberSearch {
	//declare elements
	@FindBy(xpath="//span[contains(text(),'Member Search')]")
	private WebElement memSearchButton;
	@FindBy(xpath="//input[@id='labelFirstName']")
	private WebElement firstName;
	@FindBy(xpath="//input[@id='labelLastName']")
	private WebElement lastName;
	@FindBy(xpath="//button[text()='Search']")
	private WebElement searchButton;
	@FindBy(xpath="//span[text()='002229098-01']")
	private WebElement memberLink;
	@FindBy(xpath="//span[contains(text(),'Work Item Search')]")
	private WebElement workItemSearchTB;
	@FindBy(xpath="//span[contains(text(),'Care Management')]")
	private WebElement careManagementTB;
	@FindBy(xpath="//a[@ui-sref='app.pagecmdmdashboard']")
	private WebElement cmDashBoard;
	@FindBy(xpath="//a[@ui-sref='app.interventionplanentry']")
	private WebElement interventionPlanEntryTB;
	@FindBy(xpath="//span[contains(text(),'Utilization Review')]")
	private WebElement utilizationReviewTB;
	@FindBy(xpath="//a[@ui-sref='app.review']")
	private WebElement reviewSubTB;
	@FindBy(xpath="//a[@ui-sref='app.pageurdashboard']")
	private WebElement urDashboad;

	//initialize elements
	public MemberSearch (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}	

	//utilize elements
	public void setFirstName(String fName)
	{
		firstName.sendKeys(fName);
	}
	public void setLastName(String lName)
	{
		lastName.sendKeys(lName);
	}
	public void clickMemSearchButton()
	{
		memSearchButton.click();
	}
	public void clickSearchButton()
	{
		searchButton.click();
	}
	public void viewMember()
	{
		memberLink.click();
	}
	public void clickWorkItemSearchTB()
	{
		workItemSearchTB.click();
	}
	public void clickCareManagementTB()
	{
		careManagementTB.click();
	}
	public void clickCMDashBoard()
	{
		cmDashBoard.click();
	}
	public void clickInterventionPlanEntryTB()
	{
		interventionPlanEntryTB.click();
	}
	public void clickUtilizationReviewTB() 
	{
		utilizationReviewTB.click();	
	}
	public void clickReviewSubTab()
	{
		reviewSubTB.click();
	}
	public void clickURDashboad()
	{
		urDashboad.click();	
	}
}
