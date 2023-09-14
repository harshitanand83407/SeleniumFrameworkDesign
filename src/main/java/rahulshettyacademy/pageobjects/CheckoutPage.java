package rahulshettyacademy.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//@FindBy(css = "a[class='.action__submit ng-star-inserted']")
	// private WebElement submit;
    
	//driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
	@FindBy(css = "[placeholder='Select Country']")
	private WebElement country;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	private WebElement selectCountry;

	private By results = By.cssSelector(".ta-results");

	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}
	
	public ConfirmationPage submitOrder()
	{
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
        //for scrolling windows
        js.executeScript("window.scrollBy(0,600)");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
        driver.findElement(By.cssSelector("a[class='btnn action__submit ng-star-inserted']")).click();
        }catch(Exception e) {
        	e.printStackTrace();
        }
		//submit.click();
		return new ConfirmationPage(driver);
		
		
	}

}
