package org.apache.camel.learn;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CreateClientProcesor implements Processor{

    @Override
    public void process(Exchange exchange) throws Exception {
        ClientRequest clientRequest = new ClientRequest(); 
        clientRequest.setCodigo(5);
        clientRequest.setIdentificacion("0105477804");
        clientRequest.setNombres("Cliente One");
        clientRequest.setCorreo("Pruebas@yahoo.es");
        clientRequest.setTelefono("0976436698");
        clientRequest.setDireccion("cuenta");
        exchange.getIn().setBody(clientRequest);
        
    }
    
}
