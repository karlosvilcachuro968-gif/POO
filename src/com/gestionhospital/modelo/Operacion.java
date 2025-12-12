package com.gestionhospital.modelo;

public class Operacion {
    private int idOperacion;
    private int idCirugia;
    private String descripcion;
    private String estado;

    public Operacion(int idCirugia, String descripcion, String estado) {
        this.idCirugia = idCirugia;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdOperacion() { return idOperacion; }
    public int getIdCirugia() { return idCirugia; }
    public String getDescripcion() { return descripcion; }
    public String getEstado() { return estado; }
}