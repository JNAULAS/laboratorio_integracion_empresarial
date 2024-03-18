package org.apache.camel.learn;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;

public class ClientRouter extends RouteBuilder {
    // Para trabajar con procesor
    JacksonDataFormat jsonDataFormat = new JacksonDataFormat(ClientRequest.class);

    @Override
    public void configure() throws Exception {
        // Route save client
        from("direct:saveClient1")
                .routeId("addClient")
                .process(new CreateClientProcesor())
                .marshal(jsonDataFormat)
                .to("rest:post:/clients?host=localhost:5000")
                .to("log:CREATE Client");// send output service

    }

}
