package cc.nuvu.personatarjetas.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.nuvu.personatarjetas.api.PersonaAPI;
import cc.nuvu.personatarjetas.api.TarjetaCreditoAPI;
import cc.nuvu.personatarjetas.api.model.Persona;
import cc.nuvu.personatarjetas.api.model.TarjetaCredito;
import cc.nuvu.personatarjetas.business.PersonaTarjetasBusiness;
import cc.nuvu.personatarjetas.dto.PersonaTarjetasDTO;

@Service
public class PersonaTarjetasBusinessImpl implements PersonaTarjetasBusiness {
	
	@Autowired
	private PersonaAPI personaApi;
	
	@Autowired
	private TarjetaCreditoAPI tarjetaCreditoApi;


	@Override
	public void guardarPersonaTarjetasCredito(PersonaTarjetasDTO personaTarjetas) {
		Persona persona = Persona.builder()
			.tipoDocumento(personaTarjetas.getTipoDocumento())
			.numDocumento(personaTarjetas.getNumDocumento())
			.nombres(personaTarjetas.getNombres())
			.apellidos(personaTarjetas.getApellidos())
			.correo(personaTarjetas.getCorreo())
		.build();
		Persona personaCreada = this.personaApi.guardarPersona(persona);
		
		if (personaCreada.getId() != null) {
			List<TarjetaCredito> tarjetas = new ArrayList<>();
			personaTarjetas.getTarjetasCredito().stream().forEach((tarjeta) -> {
				tarjetas.add(
					TarjetaCredito.builder()
						.idPersona(personaCreada.getId())
						.numero(tarjeta.getNumero())
						.fechaVencimiento(tarjeta.getFechaVencimiento())
						.banco(tarjeta.getBanco())
					.build()
				);
			});
			
			this.tarjetaCreditoApi.guardarTarjetasCredito(tarjetas);
		}
	}

}
