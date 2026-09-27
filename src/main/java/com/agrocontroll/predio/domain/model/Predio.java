package com.agrocontroll.predio.domain;
import java.util.ArrayList;
import java.util.List;

public class Predio {
    private Long id;
    private String nombre;
    private String ubicacion;
    private List<Parcela> parcelas;

    public Predio(Long id, String nombre, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.parcelas = new ArrayList<>();
    }

    public void agregarParcela(Parcela parcela) {
        this.parcelas.add(parcela);
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getUbicacion() { return ubicacion; }
    public List<Parcela> getParcelas() { return parcelas; }
}