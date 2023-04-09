package googlePage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResultsPage extends BasePage{

	public GoogleSearchResultsPage(WebDriver driver) throws Exception {
    	super(driver);
    	
	}
	
	public  GoogleSearchResultsPage go(String url) {
		
		get(getDriver(), url);
		return PageFactory.initElements(getDriver(), GoogleSearchResultsPage.class);
		
	}
	
	public GoogleSearchResultsPage visitPage(String url) throws Exception {
		
		GoogleSearchResultsPage page = new GoogleSearchResultsPage( getDriver());
		
		get(getDriver(), url);
		 
        PageFactory.initElements(getDriver(), page);
			
		return page;
	
	}
	
		public String findFieldEl =".gLFyf";
	
		// 
	   @FindBy(name = "q") 
	    public WebElement enterDataToSearchField;
	   
	   @FindBy(name = "q") 
	    public WebElement buscarSearchField;
	   
	   @FindBy(tagName = "input")
	   public WebElement inputEl;
	   
	   @FindBy(css = ".gm7Ysb")
	   public WebElement resultEl;
	
	   @FindBy(xpath = "//span[@id='wob_tm']")
	   public WebElement tempSearched;
	   
	   
	public  void enterTextToSearch(WebElement enterDataToSearchField2,Keys enter) {
				
		writeText(enterDataToSearchField2, enter);
		
	} 
	
	
	public  String getTextToSearch(String elem) {
		
		String result = listElement(elem).getText();
		
		return result;
		
	} 
	
	public String elName() {
		String result = inputEl.getText();
		return 		 result ;
		
	}
	
	public String elsName() {
		String result = driver.getTitle();
		return 		 result ;
		
	}
	public String resName() {
		String result = resultEl.getText();
		return 		 result ;
		
	}
	
	public String tempSearch() {
		String result = tempSearched.getText();
		return result ;
		
	}
	
	
	public String locationGoo(String spanText) {
		
		String spanToSearch = "//span[contains(text(),'"+ spanText + "')]";
		String result = driver.findElement(By.xpath(spanToSearch)).getText(); 
		
		return result ;
	}
	
	
}
