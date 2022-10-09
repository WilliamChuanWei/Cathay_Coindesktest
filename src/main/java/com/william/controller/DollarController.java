package com.william.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.william.bean.Dollar;
import com.william.function.DataSource;
import com.william.function.JSONParser;
import com.william.repository.DollarRepository;

@Controller
public class DollarController {
	
	@Autowired
	private DollarRepository dollarRepository;

	@GetMapping(path="/")
	public String mainPagePath() {
		return "redirect:/index";
	}
	
	@GetMapping(path="/index")
	public String index() {
		
		String json = DataSource.jsonString();
		
		Map<String, Object> map = JSONParser.parseJSON(json);
		
		Dollar[] dollarArray = JSONParser.transformer(map);
		
		DollarRepository dr = new DollarRepository();
		
		for(int i = 0; i < dollarArray.length; i++) {
			
			dr.updateData(dollarArray[i]);
			
		}
		
		return "/index";
	}
	
	@GetMapping(path="/searchCode")
	public @ResponseBody Map<String, String> searchCode(@RequestParam(value = "code") String code) {
		
		DollarRepository dr = new DollarRepository();
		
		Dollar dollar = dr.searchByCode(code);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", dollar.getCode());
		map.put("description", dollar.getDescription());
		map.put("rate", dollar.getRate());
		map.put("rate_float", dollar.getRate_float());
		map.put("symbol", dollar.getSymbol());
		map.put("date", dollar.getDate().toString());
		return map;
	}
}
