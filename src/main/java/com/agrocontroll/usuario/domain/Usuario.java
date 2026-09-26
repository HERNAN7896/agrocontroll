package usuario.domain;

public class Usuario {
    private long id;
    private String nombre;
    private String email;
    private Rol rol;

    public Usuario(long id, String nombre, String email, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGmail() {
        return email;
    }

    public Rol getRol() {
        return rol;
    }
}
