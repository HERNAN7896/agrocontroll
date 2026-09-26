package cultivo.domain;

public class Cosecha {
    private long id;
    private double toneladas;
    private String fecha;

    public Cosecha(long id, double toneladas, String fecha) {
        this.id = id;
        this.toneladas = toneladas;
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public double getToneladas() {
        return toneladas;
    }

    public String getFecha() {
        return fecha;
    }
}
