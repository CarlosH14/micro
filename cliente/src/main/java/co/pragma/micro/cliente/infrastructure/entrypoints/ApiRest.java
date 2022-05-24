package co.pragma.micro.cliente.infrastructure.entrypoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import co.pragma.micro.cliente.domain.model.Persona;

@RestController("/api")
public class ApiRest {
    @Autowired
    RestTemplate restTemplate;

    String personaUrl = "http://localhost:8089/api/persona/";
    String imagenUrl = "http://localhost:8087/api/imagen/";

    @GetMapping("/cliente/persona")
    public List<?> getAllPersona(){
        return restTemplate.getForObject(personaUrl, List.class);
    }

    @PostMapping("/cliente/persona")
    public Persona savePersona(@RequestBody Persona persona){
        return restTemplate.postForObject(personaUrl, persona, Persona.class);
    }
}
