package cc.nuvu.personatarjetas.dto;

import java.util.List;

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
public class PersonaTarjetasDTO {

	@ApiModelProperty(name = "id", accessMode = AccessMode.READ_ONLY)
	private Long id;
	
	@ApiModelProperty(name = "tipoDocumento", required = true, value = "Tipo de documento de la persona")
	@NotNull(message = "El campo tipoDocumento no puede ser nulo")
	private String tipoDocumento;
	
	@ApiModelProperty(name = "numDocumento", required = true, value = "Numero de documento de la persona")
	@NotNull(message = "El campo numDocumento no puede ser nulo")
	private Long numDocumento;
	
	@ApiModelProperty(name = "nombres", required = true, value = "Nombres de la persona")
	@NotNull(message = "El campo nombres no puede ser nulo")
	private String nombres;
	
	@ApiModelProperty(name = "apellidos", required = true, value = "Apellidos de la persona")
	@NotNull(message = "El campo apellidos no puede ser nulo")
	private String apellidos;
	
	@ApiModelProperty(name = "correo", required = true, value = "Correo de la persona")
	@NotNull(message = "El campo correo no puede ser nulo")
	private String correo;
	
	@ApiModelProperty(name = "tarjetasCredito", required = true, value = "Tarjetas de credito de la persona")
	private List<TarjetaCreditoDTO> tarjetasCredito;
	
}
