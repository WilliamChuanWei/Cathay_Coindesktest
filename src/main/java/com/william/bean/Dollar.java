package com.william.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity(name = "dollar")
@Table(name = "dollar")
@Component("dollar")
public class Dollar {

	@Column(name = "symbol")
	private String symbol;
	
	@Column(name = "rate_float")
	private String rate_float;
	
	@Id @Column(name = "code")
	private String code;
	
	@Column(name = "rate")
	private String rate;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "date")
	private Date date;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getRate_float() {
		return rate_float;
	}

	public void setRate_float(String rate_float) {
		this.rate_float = rate_float;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Dollar [symbol=" + symbol + ", rate_float=" + rate_float + ", code=" + code + ", rate=" + rate
				+ ", description=" + description + ", date=" + date + "]";
	}
}
