package POM;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage{
	
	//declare the elements
	@FindBy(xpath="//input[@placeholder='Email']")
	private WebElement unTB;
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement pwdTB;
	@FindBy(xpath="//button[@ng-click='vm.login()']")
	private WebElement loginButton;
	
	//initialize elements
	public LoginPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilize the elements
	public void setUsername(String un)
	{
		unTB.sendKeys(un);
	}
	public void setPassword(String pwd)
	{
		pwdTB.sendKeys(pwd);
	}
	public void clickLoginButton()
	{
		loginButton.sendKeys(Keys.ENTER);
	}
}
