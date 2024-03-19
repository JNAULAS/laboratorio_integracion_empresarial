package org.apache.camel.learn;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

// Realizamos anotacion de injeccion de dependencias
@Component
public class MyRouteActivator extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        // Route Test
        from("direct:saludo")
                .transform()
                .method("ClientBean", "updateString")
                .log("log:SALIDA")// print console log
                .to("stream:out");// send output service

        // Route save client
        from("direct:saveClient")
                .routeId("saveClient")
                .transform()
                .method("ClientBean", "saveClient")
                .log("log:Registro de cliente ok.")// print console log
                .to("stream:out");// send output service



    }

}
