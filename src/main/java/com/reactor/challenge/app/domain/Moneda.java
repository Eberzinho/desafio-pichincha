package com.reactor.challenge.app.domain;


import javax.persistence.*;

@Entity
@Table(name ="tbl_moneda")
public class Moneda {

    private @Id
    @GeneratedValue
    Long id;

    @Column(name="monedaOrigen")
    private String monedaOrigen;

    @Column(name="monedaDestino")
    private String monedaDestino;

    @Column(name="valor")
    private String valor;

    public Moneda() {
    }

    public Moneda( String monedaOrigen, String monedaDestino, String valor) {

        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
