package cultivo.domain;

public class Campania {

    private long id;
    private String nombre;
    private String fechaInicio;
    private String fechaFinal;

    public Campania(String fechaFinal, String fechaInicio, String nombre, long id) {
        this.fechaFinal = fechaFinal;
        this.fechaInicio = fechaInicio;
        this.nombre = nombre;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }
}
