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
 
public class Embeddable {
	
	private String url = "";
	private String password = "";
	private String userid = "";
	
	public Embeddable() {
		getConnection();
	}
		
    public void getConnection() {

		try {
            String envServices = System.getenv("VCAP_SERVICES");
            
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(envServices);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray vcapArray = (JSONArray) jsonObject.get("erservice");
            JSONObject vcap = (JSONObject) vcapArray.get(0);
            JSONObject credentials = (JSONObject) vcap.get("credentials");
			url = credentials.get("url").toString();
			password = credentials.get("password").toString();
			userid = credentials.get("userid").toString();
            
        } catch (ParseException ex) {
        }
	}
	
	public String getURL() {
		return url;
	}
}