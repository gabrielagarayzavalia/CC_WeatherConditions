package googlePage;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class ActionsOnGoogle extends BasePage{

	public ActionsOnGoogle(WebDriver driver) {
		super(driver);
		
	}
	
	
	public GoogleSearchResultsPage go(WebDriver driver,String url) {
		
		get(driver, url);
		return PageFactory.initElements(driver, GoogleSearchResultsPage.class);
		
		
	}

	public ActionsOnGoogle visitPage(String url) throws Exception {
		
		ActionsOnGoogle page = new ActionsOnGoogle(getDriver());
		
		get(getDriver(), url);
				
        PageFactory.initElements(getDriver(), page);
			
		return page;
	
	}
	
		public static String findFieldEl =".gLFyf";
	
		
	    @FindBy(css = ".gLFyf") 
	    public static WebElement enterDataToSearchField;
	
	public void enterTextToSearch(WebElement enterDataToSearchField2,Keys enter) {
				
		writeText(enterDataToSearchField2, enter);
		
	} 
	

	public  void enterTextToSearch(String findFieldEl2, String textToSearch) {
		writeText(By.cssSelector(findFieldEl2), textToSearch);
		
	}



	public  void enterTextToSearch(String findFieldEl2, Keys key) {
		writeText(By.cssSelector(findFieldEl2), key);
		
	}
	


	public  Wait<WebDriver> wait(WebDriver driver) {
		
		  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		  .withTimeout(Duration.ofSeconds(50L))
		  .pollingEvery(Duration.ofSeconds(5L))
		  .ignoring(NoSuchElementException.class);
		return wait;
	}


	
	
}
