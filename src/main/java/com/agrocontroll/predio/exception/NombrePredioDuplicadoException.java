package com.agrocontroll.predio.exception;

public class NombrePredioDuplicadoException extends RuntimeException {
    public NombrePredioDuplicadoException(String nombre) {
        super("Error de regla de negocio: Ya existe un predio con el nombre '" + nombre + "'");
    }
}