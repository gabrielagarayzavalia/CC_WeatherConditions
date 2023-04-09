package testSteps;


import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Keys;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import googlePage.ActionsOnGoogle;
import googlePage.GoogleSearchResultsPage;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class webApiTempComparison extends BaseTest{
	
	
	
    public ActionsOnGoogle googleMainPage;
	
	public GoogleSearchResultsPage searchPage;
	
	public String searchUrl;


	
	@Test  (priority = 1)
	public void WeatherContiditionsTest() throws Exception {
		
		googleMainPage = new ActionsOnGoogle(driver);
		
		// 1. Open Google homepage using Selenium 
		
		googleMainPage.visitPage(googleURL);

		super.wait(driver).until(ExpectedConditions.urlContains(googleURL));
		
		String cUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(cUrl, googleURL);
		
		super.wait(driver).until(ExpectedConditions.titleIs("Google"));
		

		Assert.assertEquals(driver.getTitle(), "Google");		
		
		String textToSearch = "Weather in San Francisco, California";
		
		// 2. Enter the search "Weather in a selected location" in the search bar
		
		googleMainPage.enterTextToSearch(ActionsOnGoogle.findFieldEl, textToSearch);
			
		googleMainPage.enterTextToSearch(ActionsOnGoogle.enterDataToSearchField, Keys.ENTER);
		
		searchUrl = driver.getCurrentUrl();
		
		// System.out.println(searchUrl);
		
	}

	@Test  (priority = 2)
	public void searchPageActions() throws Exception
	{	
		String textToSearch = "Weather in San Francisco, California";
		
		searchPage = googleMainPage.go(driver, searchUrl);
				
		String sUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(sUrl, searchUrl);
		
		// 3. Submit the search and wait for the results page to load
		
		waitPageLoadComplete(driver);

		wait(this.searchPage.getDriver()).until(ExpectedConditions.urlContains(searchUrl));
				
		Assert.assertTrue((searchPage.getDriver().getTitle().contains(textToSearch)), " title not matching search text");
		
		
		// String resultFieldTxt = "Resultados para";
				// NOTE: My computer is set in Spanish
		
		
		// 4. Extract the Temperature in the selected location from the results and store the value in an object
		
		String location = "San Francisco, California";
		
		Assert.assertTrue(searchPage.locationGoo(location).contains(location));
				
		String tempGoo = searchPage.tempSearch();
		
		/**
		 * 
		 * 5. Make a call to the OpenWeatherMap API to retrieve weather data for the same specific location 
		 *    and deserialize the result into an object
		 * @throws Exception
		 */
		
		Map<String, String> queryMap = new HashMap<String,String>();  // APPID 0d76f30980b33edb4d4331fcc98d4c12  // q = 

		// NOTE: APPID should be hidden but for the purpose of this test/example it is exposed.
		queryMap.put("APPID", "0d76f30980b33edb4d4331fcc98d4c12"); 
		queryMap.put("q", "San Francisco,us");
	
		
		RestAssured.baseURI = "http://api.openweathermap.org/data/2.5/weather";
		
		Response response = given().formParams(queryMap).get(RestAssured.baseURI);
		        
        JsonObject weatherData= JsonParser.parseString(response.asPrettyString().toString()).getAsJsonObject();
                
        String temp = "temp";
        
        JsonObject jTemp = (JsonObject) weatherData.get("main");
        
        // System.out.println(jTemp);
        
        Long apiTemp = jTemp.get(temp).getAsLong();
        Long gooTem = Long.parseLong(tempGoo);
        

		/***
        
        6. Print the temperature difference between the results in 4 and 5
        
        ****/
		
        Long apiTKtoC = calcKtoC(apiTemp);
        Long apiTKtoF = calcKtoF(apiTemp);
        
        System.out.println("Location Temp at Google = " + gooTem); 
        System.out.println("Location Temp at API (Kelvin)= " + apiTemp);
		
		
		Long gooTFh = calcCtoF(gooTem); 
		
		System.out.println("Google Temp from Celsius to Farenheit = " +  gooTFh);
		
		System.out.println("If your browser shows temp in Farenheit then: ");
		System.out.println("Temperature difference between google and weatherapi is: F " + (gooTFh - apiTKtoF));
        
     // NOTE: My computer is set in Spanish and in Celsius
		
		System.out.println("Api Temp from Kelvin to Celsius = " +  apiTKtoC);
		System.out.println("Api Temp from Kelvin to Farenheit = " +  apiTKtoF);
		
		System.out.println("If your browser shows temp in Celcius then: ");
		System.out.println("Temperature difference between google and weatherapi is: C " + (gooTem -apiTKtoC));

		
	
		
		
	}
	
	
	
	
	
	
	
	

}
