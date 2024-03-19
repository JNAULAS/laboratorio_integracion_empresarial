package org.apache.camel.learn;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CreateClientProcesor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        ClientRequest clientRequest = exchange.getIn().getBody(ClientRequest.class);
        exchange.getIn().setBody(clientRequest);

    }

}
