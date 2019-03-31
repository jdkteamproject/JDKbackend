package com.cue.dao;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

@Component
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
				
				if(retrieved.get("_embedded") != null) {
					JSONObject embedded = (JSONObject) retrieved.get("_embedded");
					
					if(embedded.get("events") != null) {
						JSONArray jarr = (JSONArray) embedded.get("events");

						for(int i=0; i<jarr.size(); i++) {
							JSONObject loopObj = (JSONObject)jarr.get(i);
							this.removeInfo(loopObj);
						}
					}
				}
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return retrieved;
	}

	public JSONObject getAPIEvents(Integer page, String city, String category, String keyword, String id) {
		city = city.replace(" ", "%20");
		category = category.replace(" ", "%20");
		keyword = keyword.replace(" ", "%20");
		id = id.replace(" ", "%20");
		String url = "https://app.ticketmaster.com/discovery/v2/events.json?apikey=t63Al5tXuGHyxtiO6eDELpEGEnt45tg9&page=" + page + "&city=" + city + "&segmentName=" + category + "&keyword=" + keyword + "&id=" + id;
		
		return this.searchMore(url);
	}
	
}
