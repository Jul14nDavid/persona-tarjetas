package cc.nuvu.personatarjetas.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cc.nuvu.personatarjetas.api.model.Persona;
import io.swagger.annotations.Api;

@Api
@Service
public class PersonaAPI {

	@Autowired
	private RestTemplate restTemplate;
	
	final String url = "http://localhost:8080/persona/guardar";
	

	public Persona guardarPersona(Persona persona) {
		return this.restTemplate.postForObject(this.url, persona, Persona.class);
	}
	
}
