package com.reactor.challenge.app.controllers;


import com.reactor.challenge.app.domain.Moneda;
import com.reactor.challenge.app.exceptions.MonedaNotFoundException;
import com.reactor.challenge.app.services.MonedaService;
import dto.ResponseExchangeDto;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/moneda")
public class MonedaController {

    private MonedaService monedaService;

    public MonedaController(MonedaService monedaService) {
        this.monedaService = monedaService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> all() {
        HttpStatus status = HttpStatus.OK;
        List<Moneda> ListaMoneda = monedaService.findAll().stream()
                .collect(Collectors.toList());
        return new ResponseEntity<>(ListaMoneda, status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarMoneda(@RequestBody Moneda body, @PathVariable Long id) {
    	monedaService.findById(id)
                .map(moneda -> {
                	moneda.setValor(body.getValor());
                    return monedaService.save(moneda);
                })
                .orElseThrow(() -> new MonedaNotFoundException(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/exchange")
    public Single<ResponseEntity<BaseWebResponse<ResponseExchangeDto>>> getExchangeRate(
            @Param("monedaOrigen") String monedaOrigen,
            @Param("monedaDestino") String monedaDestino,
            @Param("monto") String monto)  {

        return monedaService.exchangeCurrency(monedaOrigen,monedaDestino,monto)
                .subscribeOn(Schedulers.io())
                .map(exchangeRateResult -> ResponseEntity.ok(BaseWebResponse.successWithData(exchangeRateResult)));

    }

}
