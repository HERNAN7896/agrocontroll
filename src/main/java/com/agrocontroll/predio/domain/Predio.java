package predio.domain;

import  java.util.ArrayList;
import java.util.Collection;
import  java.util.List;

public class Predio {
    private  long id ;
    private  String nombre;
    private  String ubicacion;
    private final List<Parcela>parcelas=new ArrayList<>();

    public Predio(long id, String nombre, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }
}