package com.camel.estudos.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FromApplicationToQueue extends RouteBuilder{

	String caminho = "src/main/resources/files/json/";
	
	@Override
	public void configure() throws Exception {
		
		from("file:"+caminho)
		.setHeader("cabeca", simple("Teste"))
		.to("activemq:minhaPrimeiraFila");
	}
}
