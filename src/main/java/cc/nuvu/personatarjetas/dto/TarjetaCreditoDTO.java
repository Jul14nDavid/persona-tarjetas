package cc.nuvu.personatarjetas.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@ApiModel
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarjetaCreditoDTO {

	@ApiModelProperty(name = "id", accessMode = AccessMode.READ_ONLY)
	private Long id;
	
	@ApiModelProperty(name = "idPersona", required = true, value = "ID de la persona")
	@NotNull(message = "El campo idPersona no puede ser nulo")
	private Long idPersona;
	
	@ApiModelProperty(name = "numero", required = true, value = "Numero de la tarjeta")
	@NotNull(message = "El campo numero no puede ser nulo")
	private String numero;
	
	@ApiModelProperty(name = "fechaVencimiento", required = true, value = "Fecha de Vencimiento de la tarjeta")
	@NotNull(message = "El campo fechaVencimiento no puede ser nulo")
	private Date fechaVencimiento;
	
	@ApiModelProperty(name = "banco", required = true, value = "Fecha de Vencimiento de la tarjeta")
	@NotNull(message = "El campo banco no puede ser nulo")
	private String banco;
	
}
