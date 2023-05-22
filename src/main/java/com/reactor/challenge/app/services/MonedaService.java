package com.reactor.challenge.app.services;

import com.reactor.challenge.app.domain.Moneda;
import dto.ResponseExchangeDto;
import io.reactivex.Single;

import java.util.List;
import java.util.Optional;

public interface MonedaService {

    List<Moneda> findAll();
    Moneda save(Moneda moneda);
    Optional<Moneda> findById(Long id);
    void deleteAll();
    Single<ResponseExchangeDto> exchangeCurrency(String monedaOrigen, String monedaDestino, String monto);
}
