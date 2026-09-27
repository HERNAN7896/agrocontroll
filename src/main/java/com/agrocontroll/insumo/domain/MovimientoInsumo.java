package com.agrocontroll.insumo.domain;

public class MovimientoInsumo {
    private long id;
    private double catidad;
    private String  tipodeMovimiento;//es lo que entra y sale

    public MovimientoInsumo(long id, double catidad, String tipodeMovimiento) {
        this.id = id;
        this.catidad = catidad;
        this.tipodeMovimiento = tipodeMovimiento;
    }

    public long getId() {
        return id;
    }

    public double getCatidad() {
        return catidad;
    }

    public String getTipodeMovimiento() {
        return tipodeMovimiento;
    }
}
