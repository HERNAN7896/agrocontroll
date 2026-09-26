package labor.domain;

public class BitacoraCampo {
    private long id;
    private String observacion;
    private String fecha;

    public BitacoraCampo(long id, String observacion, String fecha) {
        this.id = id;
        this.observacion = observacion;
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public String getObservacion() {
        return observacion;
    }

    public String getFecha() {
        return fecha;
    }
}
