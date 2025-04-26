package com.rohan.microservices.currency_conversion_service;

import java.math.BigDecimal;

//@Entity
public class CurrencyConversion {

	
//	@Id
	private Long id;
//	@Column(name="currency_from")
	private String from;
//	@Column(name="currency_to")
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal calculatedQuantity;
	private String environment;
	public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal calculatedQuantity, String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.calculatedQuantity = calculatedQuantity;
		this.environment = environment;
	}
	public CurrencyConversion() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getCalculatedQuantity() {
		return calculatedQuantity;
	}
	public void setCalculatedQuantity(BigDecimal calculatedQuantity) {
		this.calculatedQuantity = calculatedQuantity;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	@Override
	public String toString() {
		return "CurrencyConversion [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + ", quantity=" + quantity + ", calculatedQuantity=" + calculatedQuantity
				+ ", environment=" + environment + "]";
	}
	
	
}
