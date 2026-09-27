package com.agrocontroll.insumo.domain;

public class Insumo {

    private long id;
    private String nombre ;
    private String unidadMedida;
    private double stockDisonible;

    public Insumo(long id, String nombre, String unidadMedida, double stockDisonible) {

        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stockDisonible = stockDisonible;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public double getStockDisonible() {
        return stockDisonible;
    }
}


