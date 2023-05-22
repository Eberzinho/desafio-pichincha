package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseExchangeDto {


    private String monto;
    private String monedaOrigen;
    private String monedaDestino;
    private String montoResultado;
    private String valor;
    
    public String getMonto() {
		return monto;
	}

	

    public ResponseExchangeDto() {}

    public ResponseExchangeDto(String monto, String monedaOrigen, String monedaDestino, String montoResultado, String valor) {
        this.monto = monto;
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.montoResultado = montoResultado;
        this.valor = valor;
    }


}
