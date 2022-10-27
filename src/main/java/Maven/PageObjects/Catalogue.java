package Maven.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Abstractcomponents.AbstractComponents;

public class Catalogue  extends AbstractComponents{
	WebDriver driver;
	//Creating Constructor class for driver
	public  Catalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//finding list of webelement products from catalogue page
	@FindBy(css=".mb-3")
	List<WebElement> products;
	@FindBy(css=".-ng-animating")
	WebElement blink;
	
	//explicit wait 
	By productsLis =By.cssSelector(".mb-3");
	//filtering the product name
	By productName=By.cssSelector("b");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector(".toast-container");
	
	// getting products list from list of webelements 
       public List<WebElement> getProductsList()
       {
    	waitForElement(productsLis);   
    	return products;
       }
       //getting product name by filtering with streams
       public WebElement getProductName(String productName)
       {
    	   WebElement prod =   getProductsList().stream().filter(p->p.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
   		return prod;
       }
       //adding product to cart
       public void addingToCart(String productName){
    	   WebElement prod = getProductName(productName);
    	   prod.findElement(addToCart);
    	   waitForElement(toastMessage);
    	   waitForElementToVanish(blink);
    	    		
       }
	
	
}
