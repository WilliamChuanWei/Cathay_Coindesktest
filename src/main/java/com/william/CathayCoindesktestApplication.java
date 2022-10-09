package com.william;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.xml.transform.Transformer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.william.bean.Dollar;
import com.william.function.DataSource;
import com.william.function.JSONParser;
import com.william.repository.DollarRepository;

@SpringBootApplication
public class CathayCoindesktestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CathayCoindesktestApplication.class, args);
	}

}
