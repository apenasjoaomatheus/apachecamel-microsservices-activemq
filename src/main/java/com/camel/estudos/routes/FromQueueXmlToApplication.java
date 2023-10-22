package com.camel.estudos.routes;

import com.camel.estudos.beans.DataEnricher;
import com.camel.estudos.models.CurrencyExchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FromQueueXmlToApplication extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("activemq:fila-amq-xml")
                .unmarshal()
                .jacksonXml(CurrencyExchange.class)
                .bean(DataEnricher.class, "enricher");
    }
}
