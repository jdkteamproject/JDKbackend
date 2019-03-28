package com.cue.handler;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TicketMasterAPI {
	
	private URL url = null;
	
	private void removeInfo(JSONObject object) {
		object.remove("type");
		object.remove("test");
		object.remove("sales");
		object.remove("promoter");
		object.remove("promoters");
		object.remove("pleaseNote");
		object.remove("products");
		object.remove("seatmap");
		object.remove("outlets");
		object.remove("locale");
		object.remove("ticketLimit");
		object.remove("_links");
		JSONObject object2 = (JSONObject) object.get("_embedded");
		object2.remove("attractions");
	}
	
	private JSONObject searchMore(String searchUrl) {
		JSONObject retrieved = null;
		String inline = "";
		
		try {
			url = new URL(searchUrl);
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
				
				retrieved = (JSONObject) parser.parse(inline);
				
				retrieved.remove("_links");
				
				JSONObject embedded = (JSONObject) retrieved.get("_embedded");
				
				JSONArray jarr = (JSONArray) embedded.get("events");

				for(int i=0; i<jarr.size(); i++) {
					JSONObject loopObj = (JSONObject)jarr.get(i);
					this.removeInfo(loopObj);
				}
				
				System.out.println(retrieved);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return retrieved;
	}
	
	private JSONObject searchOne(String searchUrl) {
		JSONObject retrieved = null;
		String inline = "";
		
		try {
			url = new URL(searchUrl);
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
				
				retrieved = (JSONObject) parser.parse(inline);
				
				retrieved.remove("_links");
				retrieved.remove("page");
				
				JSONObject embedded = (JSONObject) retrieved.get("_embedded");
				
				JSONArray jarr = (JSONArray) embedded.get("events");

				for(int i=0; i<jarr.size(); i++) {
					JSONObject loopObj = (JSONObject)jarr.get(i);
					this.removeInfo(loopObj);
				}
				
				System.out.println(retrieved);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return retrieved;
	}
	
	public JSONObject getAPIEvents(int page, String city, String category) {
		city = city.replace(" ", "%");
		category = category.replace(" ", "%");
		String url = "https://app.ticketmaster.com/discovery/v2/events.json?apikey=t63Al5tXuGHyxtiO6eDELpEGEnt45tg9&sort=date,desc&page=" + page + "&city=" + city + "&segmentName=" + category;
		
		return this.searchMore(url);
	}
	
}
