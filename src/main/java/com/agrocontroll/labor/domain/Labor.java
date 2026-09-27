package com.agrocontroll.labor.domain;

public class Labor {
    private long id;
    private String nombre;
    private String descripcion;


    private EstadoLabor estado;

    public Labor(long id, String nombre, String descripcion, EstadoLabor estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EstadoLabor getEstado() {
        return estado;
    }

    public void setEstado(EstadoLabor estado) {
        this.estado = estado;
    }
}
