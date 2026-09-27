package com.agrocontroll.labor.domain;

public class AsignacionLabor {

    private long id;
    private long laborId;
    private long usuarioId;




    public AsignacionLabor(long id, long laborId, long usuarioId) {
        this.id = id;
        this.laborId = laborId;
        this.usuarioId = usuarioId;

    }

    public long getId() {
        return id;
    }

    public long getLaborId() {
        return laborId;
    }

    public long getUsuarioId() {
        return usuarioId;
    }
}
