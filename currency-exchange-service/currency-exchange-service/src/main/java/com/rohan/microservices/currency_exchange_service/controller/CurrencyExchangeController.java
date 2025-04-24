package com.rohan.microservices.currency_exchange_service.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.microservices.currency_exchange_service.model.CurrencyExchangeModel;
import com.rohan.microservices.currency_exchange_service.model.repository.CurrencyExchangeRepo;

@RestController
@RequestMapping("currency-exchange")
public class CurrencyExchangeController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyExchangeRepo repo;

	@GetMapping("/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyExchangeModel getExchangeCurrency(@PathVariable("fromCurrency") String fromCurrency,
			@PathVariable("toCurrency") String toCurrency) {
		CurrencyExchangeModel currencyModel=repo.findByFromAndTo(fromCurrency, toCurrency);
		
		if(currencyModel==null) {
			throw new RuntimeException("Unable to frind currency exchange format");
		}
		currencyModel.setEnvironment(env.getProperty("local.server.port"));
		return currencyModel;
	}
}
