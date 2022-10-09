package com.william.test;

import java.util.Arrays;
import java.util.Map;

import org.json.JSONTokener;

import com.william.bean.Dollar;
import com.william.function.JSONParser;

public class TransformerTest {

	public static void main(String args[]) {
		
		String source = "{\"time\":{\"updated\":\"Oct 9, 2022 15:20:00 UTC\",\"updatedISO\":\"2022-10-09T15:20:00+00:00\",\"updateduk\":\"Oct 9, 2022 at 16:20 BST\"},\"disclaimer\":\"This data was produced from the CoinDesk Bitcoin Price Index (USD). Non-USD currency data converted using hourly conversion rate from openexchangerates.org\",\"chartName\":\"Bitcoin\",\"bpi\":{\"USD\":{\"code\":\"USD\",\"symbol\":\"&#36;\",\"rate\":\"19,545.3498\",\"description\":\"United States Dollar\",\"rate_float\":19545.3498},\"GBP\":{\"code\":\"GBP\",\"symbol\":\"&pound;\",\"rate\":\"16,331.9379\",\"description\":\"British Pound Sterling\",\"rate_float\":16331.9379},\"EUR\":{\"code\":\"EUR\",\"symbol\":\"&euro;\",\"rate\":\"19,040.0243\",\"description\":\"Euro\",\"rate_float\":19040.0243}}}";

		Map<String, Object> map = JSONParser.parseJSON(source);
		
		Dollar[] dollarArray = JSONParser.transformer(map);
		
		for(int i = 0; i < dollarArray.length; i++) {
			
			System.out.println(dollarArray[i].toString());
		}	

	}
}
