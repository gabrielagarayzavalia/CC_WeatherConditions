package testSteps;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
	
	public WebDriver driver;

    public WebDriverWait wait;
    
    public static String googleURL = "https://www.google.com/";
    
    public static String weatherApi = "";
	
	@BeforeClass
	public void setup() throws Exception {
		
		 System.setProperty("webdriver.http.factory", "jdk-http-client");
    	
		System.setProperty("webdriver.chrome.driver","C:\\autoM_Tools\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		/*
		 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		 * .withTimeout(Duration.ofSeconds(30L)) .pollingEvery(Duration.ofSeconds(5L))
		 * .ignoring(NoSuchElementException.class);
		 */
	
        //Maximize Window
        driver.manage().window().maximize();
        
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30L));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30L));

	}
	
	
	public Wait<WebDriver> wait(WebDriver driver) {
		
		  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		  .withTimeout(Duration.ofSeconds(50L))
		  .pollingEvery(Duration.ofSeconds(5L))
		  .ignoring(NoSuchElementException.class);
		return wait;
		
	}
	
	
	public void waitPageLoadComplete(WebDriver driver) {
		
		wait(driver).until((ExpectedCondition<Boolean>) wd -> 
						((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
	}
	
	// conversor from celcius to kelvin
	public static Long calcCtoK(Long c) {
		
		Long result = (long) (c + 273.15);
		
		return result;
	}
	
	// conversor from kelvin to celsius
	public static Long calcKtoC(Long k) {
		
		Long result = (long) (k - 273.15);
		
		return result;
	}
	
	// conversor from kelvin to farenheit 
	public static Long calcKtoF(Long k) {
		
		Long result = (long) ((((k - 273.15) * 9) /5) + 32) ;
		
		return result;
	}
	
	// conversor from farenheit to kelvin
	public static Long calcFtoK(Long fh) {
		
		Long result = (long) ((((fh - 32) * 5) /9) + 273.15) ;
		
		return result;
	}
	
	public static Long calcFtoC(Long fh) {
		
		Long result = ((fh - 32) * 5) /9 ;
		
		return result;
	}
	
	
	public static Long calcCtoF(Long cg) {
		
		Long result = ((cg * 9)/5) +32 ;
		
		return result;
	}
	
    @AfterClass
    public void teardown () {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
      
    }


}
