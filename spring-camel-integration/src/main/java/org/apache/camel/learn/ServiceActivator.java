package org.apache.camel.learn;

import org.apache.camel.ProducerTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ServiceActivator {
    // Inyectamos enconvelte que permite llamas a las rutas dentro de camel
    @Autowired
    private ProducerTemplate producerTemplate;

    // 1. Define el path de servicio y el parametro a utilizar o (variable a
    // utilizar)
    @GetMapping(value = "/saludo/{parametro}")
    public String test(@PathVariable("parametro") String parametro) {// 2. Recibimos la variable a traves
                                                                     // del metodo atraves del @PathVariable
        return producerTemplate.requestBody("direct:saludo", parametro).toString();
    }

    @GetMapping(value = "/addClienteEmp")
    public String createClient() {// 2. Recibimos la variable a traves
                                  // del metodo atraves del @PathVariable
        return producerTemplate.requestBody("direct:addClient", "").toString();
    }

    @SuppressWarnings("null")
    @PostMapping(ComunRoutes.POST_SAVE_CLIENT)
    public ResponseEntity<?> registraClientestransform(HttpServletRequest headers,
            @RequestBody ClientRequest request) {
        // Enviar la solicitud al endpoint "direct:saveClient" y obtener la respuesta
        ClientResponse clientResponse = producerTemplate.requestBody("direct:saveClient", request, ClientResponse.class);

        // Retornar la respuesta como ResponseEntity con tipo de contenido JSON
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(clientResponse);
    }

    @PostMapping(value = "/addClienteEmp", consumes = "application/json")
    public String createClient(@RequestBody ClientRequest clientRequest) {
        return producerTemplate.requestBody("direct:addClient", clientRequest, String.class);
    }
}
