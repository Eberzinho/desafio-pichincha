package com.reactor.challenge.app.jwt.config;


import com.reactor.challenge.app.domain.Moneda;
import com.reactor.challenge.app.services.MonedaService;
import io.reactivex.subjects.BehaviorSubject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfiguration {


    @Bean
    public CommandLineRunner loadData(MonedaService monedaService) {
        return (args) -> {
        	monedaService.deleteAll();

        	monedaService.save(new Moneda("USD", "PEN", "3.7"));
        	monedaService.save(new Moneda("PEN", "USD", "0.285714"));


        };
    }
}
