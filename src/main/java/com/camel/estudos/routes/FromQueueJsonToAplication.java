package com.camel.estudos.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.camel.estudos.beans.DataEnricher;
import com.camel.estudos.models.CurrencyExchange;

@Component
public class FromQueueJsonToAplication extends RouteBuilder{

	@Autowired
	private DataEnricher dataEnricher;
	
	@Override
	public void configure() throws Exception {
		
		from("activemq:minhaPrimeiraFila")
		.unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
		.bean(DataEnricher.class, "enricher");
	}

}
