package com.william.function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

public class DataSource {

	private final static String address = "https://api.coindesk.com/v1/bpi/currentprice.json";
	
	public static String jsonString() {
		
		URI uri = null;

		String result = null;

		InputStream ips = null;

		try {
			uri = new URI(address);

		} catch (URISyntaxException e) {

			e.printStackTrace();
		}

		try {

			if (uri != null) {
				ips = uri.toURL().openStream();
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		try (BufferedReader br = new BufferedReader(new InputStreamReader(ips))) {

			result = br.readLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
		
	}
	
}
