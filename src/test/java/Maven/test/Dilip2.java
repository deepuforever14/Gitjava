package Maven.test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Maven.PageObjects.Loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dilip2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		String productName = "ZARA COAT 3";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       //Importing Login details to Login page (page object Model)
        Loginpage loginpage = new Loginpage(driver);
        loginpage.goTo();
        loginpage.loginPageDetails("deepupinky1429@gmail.com","Deepupinky1429@");
        
        
        
         WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        //adding explicit wait to Catalogue page ,Explicit wait will go into abstract components method bcz it is reusable data
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        //it is giving product list
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        //it is giving product name
        WebElement prod =   products.stream().filter(p->
        p.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
        //adding item to cart
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	   //after clicking on the cart we will get buffering and item added to cart message 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		//clicking on the cart
		driver.findElement(By.cssSelector("[routerlink*=cart]")).click(); 
		//
		List<WebElement> cartItems = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartItems.stream().anyMatch(cartItem->cartItem.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		Actions a = new Actions(driver);
		 a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		//driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
		//driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
		driver.close();

	}

}
