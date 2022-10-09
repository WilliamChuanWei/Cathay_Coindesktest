package com.william.function;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import com.william.bean.Dollar;

public class JSONParser {
	
	// Not following the naming convention
	
	private final static String datePattern = "yyyy-MM-dd'T'HH:mm:ssXXX";
	
	private final static String time = "time";
	
	private final static String updatedISO = "updatedISO";
	
	private final static String bpi = "bpi";
	
	private final static String code = "code";
	
	private final static String symbol = "symbol";
	
	private final static String rate = "rate";
	
	private final static String description = "description";
	
	private final static String rate_float = "rate_float";

	public static Map<String, Object> parseJSON(String json) {

		Map<String, Object> map = new HashMap<>();

		JSONObject jo = new JSONObject(json);

		String joArray[] = JSONObject.getNames(jo);

		for (int i = 0; i < joArray.length; i++) {

			JSONArray optJsonArray = jo.optJSONArray(joArray[i]);

			if (optJsonArray != null) {

				map.put(joArray[i], optJsonArray.getString(i));

			} else {

				JSONObject optJSONObject = jo.optJSONObject(joArray[i]);

				if (optJSONObject != null) {

					map.put(joArray[i], parseJSON(optJSONObject.toString()));

				} else {

					String optJSONString = jo.optString(joArray[i]);

					map.put(joArray[i], optJSONString);

				}
			}
		}
		return map;
	}
	
	public static Dollar[] transformer(Map<String, Object> map) {
		
		@SuppressWarnings("unchecked")
		Set<String> set = ((Map) map.get(bpi)).keySet();
		
		Dollar[] dollarArray = new Dollar[set.size()];
		
		String timeStamp = (String) ((Map) map.get(time)).get(updatedISO);
		
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);		
		
		Date date = null;
		
		try {
			 date = sdf.parse(timeStamp);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		for(String codeName : set) {

			int turn = 0;
			
			Dollar dollar = new Dollar();
			
			dollar.setDate(date);
			
			dollar.setCode((String) ((Map) ((Map) map.get(bpi)).get(codeName)).get(code));
			
			dollar.setDescription((String) ((Map) ((Map) map.get(bpi)).get(codeName)).get(description));
			
			dollar.setRate((String) ((Map) ((Map) map.get(bpi)).get(codeName)).get(rate));
			
			dollar.setRate_float((String) ((Map) ((Map) map.get(bpi)).get(codeName)).get(rate_float));
			
			dollar.setSymbol((String) ((Map) ((Map) map.get(bpi)).get(codeName)).get(symbol));
			
			dollarArray[turn] = dollar;
			
			turn++;
		}
		return dollarArray;
	}
}
