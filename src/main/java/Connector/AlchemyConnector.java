/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connector;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class AlchemyConnector {
	
	private String apiKey = "";
	
	public AlchemyConnector() {
		getConnection();
	}
		
    public void getConnection() {

		try {
            String envServices = System.getenv("VCAP_SERVICES");
            
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(envServices);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray vcapArray = (JSONArray) jsonObject.get("alchemy_api");
            JSONObject vcap = (JSONObject) vcapArray.get(0);
            JSONObject credentials = (JSONObject) vcap.get("credentials");
			apiKey = credentials.get("apikey").toString();
            
        } catch (ParseException ex) {
        }
	}
	
	public String getAPIKey() {
		return apiKey;
	}
}