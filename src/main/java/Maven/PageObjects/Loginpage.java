package Maven.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.AbstractComponents;



public class Loginpage extends AbstractComponents {
	WebDriver driver;
	
	public Loginpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    @FindBy(id="userEmail")
    WebElement userEmail;
    @FindBy(id="userPassword")
    WebElement userPassword;
    @FindBy(id="login")
    WebElement submit;
    public void loginPageDetails(String email,String password)
    {
    	userEmail.sendKeys(email);
    	userPassword.sendKeys(password);
    	submit.click();
    }
    public void goTo()
    {
    	driver.get("https://rahulshettyacademy.com/client/");  
    }
	
}
