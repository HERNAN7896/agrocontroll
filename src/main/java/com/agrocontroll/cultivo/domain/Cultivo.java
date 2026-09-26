package cultivo.domain;

public class Cultivo {
    private long id;
    private String nombre;
    private String variedad;

    public Cultivo(long id, String nombre, String variedad) {
        this.id = id;
        this.nombre = nombre;
        this.variedad = variedad;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getVariedad() {
        return variedad;
    }
}
