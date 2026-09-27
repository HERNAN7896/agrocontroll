package com.agrocontroll.predio.exception;

public class PredioNoEncontradoException extends RuntimeException {
    public PredioNoEncontradoException(Long id) {
        super("Error: No se encontró ningún predio con el ID " + id);
    }
}