package com.camel.estudos.beans;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import com.camel.estudos.models.CurrencyExchange;

@Component
public class DataEnricher {
	
	public void enricher (CurrencyExchange cur) {

		System.out.println(cur.getFrom().toString());
		
	}
}
