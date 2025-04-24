package com.rohan.microservices.currency_exchange_service.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rohan.microservices.currency_exchange_service.model.CurrencyExchangeModel;

@Repository
public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchangeModel,Long> {

	
	CurrencyExchangeModel findByFromAndTo(String from,String to);
}
