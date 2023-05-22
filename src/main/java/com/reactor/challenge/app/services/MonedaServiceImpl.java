package com.reactor.challenge.app.services;

import Util.Util;
import com.reactor.challenge.app.domain.Moneda;
import com.reactor.challenge.app.repositories.MonedaRepository;
import dto.ResponseExchangeDto;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonedaServiceImpl implements MonedaService {

    @Autowired
    private MonedaRepository monedaRepository;

    @Override
    public List<Moneda> findAll() {
        List<Moneda> currencyList = monedaRepository.findAll();
        return currencyList;
    }

    @Override
    public Moneda save(Moneda moneda) {
        Moneda monedaSave = monedaRepository.save(moneda);
        return monedaSave;
    }

    @Override
    public Optional<Moneda> findById(Long id) {
        return monedaRepository.findById(id);
    }

    @Override
    public void deleteAll() {
    	monedaRepository.deleteAll();
    }

    @Override
    public Single<ResponseExchangeDto> exchangeCurrency
            (String monedaOrigen, String monedaDestino, String monto) {
        List<Moneda> listaMoneda = monedaRepository.findBymonedaOrigenAndMonedaDestino(monedaOrigen, monedaDestino);

        if (listaMoneda.size() > 0) {
            return Single.create(singleSubscriber -> {
                ResponseExchangeDto exchange = Util.convertByRate(listaMoneda.get(0), monto);
                singleSubscriber.onSuccess(exchange);
            });
        } else {
            return Single.create(singleSubscriber -> {
                singleSubscriber.onSuccess(new ResponseExchangeDto());
            });
        }
    }


}
