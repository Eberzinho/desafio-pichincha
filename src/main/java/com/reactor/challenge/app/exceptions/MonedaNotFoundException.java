package com.reactor.challenge.app.exceptions;

public class MonedaNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private final static String NO_ENCONTRO_MONENDA_ID = "No encontro la moneda Id : ";

    public MonedaNotFoundException(Long id) {
        super(NO_ENCONTRO_MONENDA_ID + id);
    }

}
