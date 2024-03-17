package org.apache.camel.learn;

import org.springframework.stereotype.Component;

@Component("ClientBean")
public class MyClientBean {

    public String updateString(String mensaje){
        return mensaje.toUpperCase();
    }
    public ClientResponse saveClient(ClientRequest clientRequest){
        ClientResponse clientResponse = new ClientResponse();
        try {
            clientResponse.setIdentificacion(clientRequest.getIdentificacion().toUpperCase());
            clientResponse.setNombres(clientRequest.getNombres().toUpperCase());
            clientResponse.setTelefono(clientRequest.getTelefono().toUpperCase());
            clientResponse.setCorreo(clientRequest.getCorreo().toUpperCase());
            clientResponse.setDireccion(clientRequest.getDireccion().toUpperCase());
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return clientResponse;
    }
    
}
