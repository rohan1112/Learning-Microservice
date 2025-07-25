package com.rohan.microservices.currency_conversion_service;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("currency-conversion")
public class CurrencyConversionController {
	
	@Autowired
	CurrencyExchangeProxy proxy;
	
	@Autowired
	private Environment env;

	@GetMapping("/rest/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
	public CurrencyConversion getCalculatedCurrencyConversion(
			@PathVariable("fromCurrency") String fromCurrency,
			@PathVariable("toCurrency") String toCurrency,
			@PathVariable("quantity") BigDecimal quantity) {
		
		HashMap<String,String> uriVariables=new HashMap<>();
		uriVariables.put("from",fromCurrency);
		uriVariables.put("to",toCurrency);

		ResponseEntity<CurrencyConversion> reponseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class,uriVariables);
		CurrencyConversion result=reponseEntity.getBody();
		result.setQuantity(quantity);
		result.setCalculatedQuantity(result.getConversionMultiple().multiply(quantity));
		result.setEnvironment(result.getEnvironment()+ " Rest Template");
		return result;
	}
	
	@GetMapping("/feign/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
	public CurrencyConversion getCalculatedCurrencyConversionFeign(
			@PathVariable("fromCurrency") String fromCurrency,
			@PathVariable("toCurrency") String toCurrency,
			@PathVariable("quantity") BigDecimal quantity) {
		
		CurrencyConversion result=proxy.getExchangeCurrency(fromCurrency, toCurrency);
		result.setQuantity(quantity);
		result.setCalculatedQuantity(result.getConversionMultiple().multiply(quantity));
		result.setEnvironment(result.getEnvironment()+ " Feign");

		return result;
	}
}
