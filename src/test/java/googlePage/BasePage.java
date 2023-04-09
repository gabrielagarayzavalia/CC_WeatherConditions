package googlePage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {
	
	protected static WebDriver driver;
	public WebDriverWait wait;
	
	
	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	
	public static void get(WebDriver driver, String url) {
		
		driver.get(url);
	}

 
    //Click Method
    public void click (By elementLocation) {
		driver.findElement(elementLocation).click();
    }
 
    //Write Text
    public  void writeText (By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }
    

	public void writeText(WebElement enterDataToSearchField2, Keys key) {
		enterDataToSearchField2.sendKeys(key);
		new Actions(driver).keyDown(key).perform();;
		
		
	}
 
	public void writeText(By cssSelector, Keys key) {
		driver.findElement(cssSelector).sendKeys(key);
		new Actions(driver).keyDown(key).perform();;
}
    
    //Read Text
    public String readText (WebElement enterDataToSearchField2) {
        return 	enterDataToSearchField2.getText();
    }
    
    //Read TextcssSelector
    public String readText (String element) {
        return driver.findElement(By.cssSelector(element)).getText();
    }
    
    public WebElement listElement (By elementLocation) {
    	return driver.findElement(elementLocation) ;
    }
	
    public WebElement listElement (String element ) {
    	return driver.findElement(By.cssSelector(element)) ;
    }

    public WebElement listElementByName (String element ) {
    	return driver.findElement(By.name(element)) ;
    }

}
