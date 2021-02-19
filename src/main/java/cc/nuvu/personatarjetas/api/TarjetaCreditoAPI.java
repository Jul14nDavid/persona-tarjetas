package cc.nuvu.personatarjetas.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cc.nuvu.personatarjetas.api.model.TarjetaCredito;
import io.swagger.annotations.Api;

@Api
@Service
public class TarjetaCreditoAPI {

	@Autowired
	private RestTemplate restTemplate;
	
	final String url = "http://localhost:8081/tarjetacredito/persona/guardar";
	

	public void guardarTarjetasCredito(List<TarjetaCredito> tarjetas) {
		this.restTemplate.postForObject(this.url, tarjetas, void.class);
	}
	
}
