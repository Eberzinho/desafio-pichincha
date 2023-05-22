package Util;

import com.reactor.challenge.app.domain.Moneda;
import dto.ResponseExchangeDto;

import java.math.BigDecimal;

public class Util {

    public static ResponseExchangeDto convertByRate(Moneda exchangeRate, String amount) {
        BigDecimal amountDecimal=BigDecimal.valueOf(Double.valueOf(amount));
        BigDecimal result = amountDecimal.multiply(BigDecimal.valueOf(Double.valueOf(exchangeRate.getValor())));
        return new ResponseExchangeDto(amount,exchangeRate.getMonedaOrigen(), exchangeRate.getMonedaDestino(), result.toString(),exchangeRate.getValor());
    }
}
