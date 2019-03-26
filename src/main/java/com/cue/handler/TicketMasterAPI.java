package com.cue.handler;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TicketMasterAPI {
	
	private URL url = null;
	
	public JSONObject getAllAPIEvents() {
		JSONObject jobj = null;
		String inline = "";
		
		try {
			url = new URL("https://app.ticketmaster.com/discovery/v2/events.json?apikey=t63Al5tXuGHyxtiO6eDELpEGEnt45tg9");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " + responsecode);
			else {
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext()) {
					inline+=sc.nextLine();
				}

				sc.close();
				
				JSONParser parser = new JSONParser();
				jobj = (JSONObject) parser.parse(inline);
				jobj = (JSONObject) jobj.get("_embedded");
				JSONArray jarr = (JSONArray) jobj.get("events");

				for(int i=0; i<jarr.size(); i++) {
					//Store the JSON objects in an array
					//Get the index of the JSON object and print the values as per the index
					JSONObject jsonobj_1 = (JSONObject)jarr.get(i);

					System.out.println("\nEvents");
					System.out.println("Name: " + jsonobj_1.get("name"));
					
				}
				
				System.out.println("got here");
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return jobj;
	}
	
	
}
