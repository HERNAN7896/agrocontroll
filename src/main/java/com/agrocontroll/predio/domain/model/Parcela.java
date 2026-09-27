package com.agrocontroll.predio.domain;

public class Parcela {

private long id;
private String codigo;
private double hectareas;

    public Parcela(long id, String codigo, double hectareas) {
        this.id = id;
        this.codigo = codigo;
        this.hectareas = hectareas;
    }

    public long getId() {

        return id;
    }

    public String getCodigo() {

        return codigo;
    }

    public double getHectareas() {

        return hectareas;
    }
}
