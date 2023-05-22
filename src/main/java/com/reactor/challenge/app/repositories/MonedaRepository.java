package com.reactor.challenge.app.repositories;

import com.reactor.challenge.app.domain.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MonedaRepository extends JpaRepository<Moneda, Long> {

    List<Moneda> findBymonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);

}
