package weatherApi;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class WeatherJSonParser {

	public static void main(String[] args) throws IOException{
		
		Map<String, String> queryMap = new HashMap<String,String>();  // APPID 0d76f30980b33edb4d4331fcc98d4c12  // q = 

		queryMap.put("APPID", "0d76f30980b33edb4d4331fcc98d4c12");
		
		queryMap.put("q", "San Francisco,us");
		// queryMap.put("", "");
		
		RestAssured.baseURI = "http://api.openweathermap.org/data/2.5/weather";
		
		Response response = given().formParams(queryMap).get(RestAssured.baseURI);
		        
        JsonObject weatherData= JsonParser.parseString(response.asPrettyString().toString()).getAsJsonObject();
                
        String temp = "temp";
        
        JsonObject jTemp = (JsonObject) weatherData.get("main");
        
        System.out.println(jTemp);
        
        String apiTemp = jTemp.get(temp).toString();
        System.out.println(apiTemp);
        
        
        
        
        
        
        
        
	}

}
