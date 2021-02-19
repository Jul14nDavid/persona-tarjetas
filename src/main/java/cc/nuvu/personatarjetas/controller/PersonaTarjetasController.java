package cc.nuvu.personatarjetas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.nuvu.personatarjetas.business.PersonaTarjetasBusiness;
import cc.nuvu.personatarjetas.dto.PersonaTarjetasDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("personaTarjetas")
@Api(tags = "#personaTarjetas")
public class PersonaTarjetasController {

	@Autowired
	private PersonaTarjetasBusiness personaTarjetasBusiness;
	
	
	@PostMapping("/guardar")
	@ApiOperation(value = "Crear Persona y sus Tarjetas de Crédito", response = void.class, httpMethod = "POST")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Informacion registrada."),
		@ApiResponse(code = 400, message = "Datos de entrada incorrectos."),
		@ApiResponse(code = 500, message = "Error inesperado.")
	})
	public void guardarPersonaTarjetasCredito(@RequestBody PersonaTarjetasDTO personaTarjetas) {
		this.personaTarjetasBusiness.guardarPersonaTarjetasCredito(personaTarjetas);
	}
	
}
