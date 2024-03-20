package org.apache.camel.learn;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class ClientRouter extends RouteBuilder {
    // Para trabajar con procesor
    JacksonDataFormat jsonDataFormat = new JacksonDataFormat(ClientRequest.class);

    @Override
    public void configure() throws Exception {
        // Route save client
        /*from("direct:addClient")
                .routeId("addClient")
                .process(new CreateClientProcesor())
                .marshal(jsonDataFormat)
                .multicast() // Invoca ambos servicios REST al mismo tiempo
                    .parallelProcessing() // Procesamiento paralelo
                    .to("rest:post:/clients?host=localhost:5000")
                    .to("rest:post:/Client?host=localhost:5278")
                .end() // Fin del multicast
                .to("log:CREATE Client"); // Envía la salida al servicio de registro
                 */
                from("direct:addClient")
                .routeId("addClient")
                .process(new CreateClientProcesor())
                .marshal(jsonDataFormat)
                .multicast() // Invoca ambos servicios REST al mismo tiempo
                    .parallelProcessing() // Procesamiento paralelo
                    .to("rest:post:/clients?host=netmicro:5278") // Cambia localhost por netmicro
                    .to("rest:post:/Client?host=service123:5000") // Cambia localhost por service123
                .end() // Fin del multicast
                .to("log:CREATE Client"); // Envía la salida al servicio de registro
    }

}
