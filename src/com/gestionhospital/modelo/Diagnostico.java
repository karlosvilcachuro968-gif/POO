package com.gestionhospital.modelo;

public class Diagnostico {
    private int idDiagnostico;
    private int idPaciente;
    private String descripcion;
    private String gravedad;

    public Diagnostico(int idPaciente, String descripcion, String gravedad) {
        this.idPaciente = idPaciente;
        this.descripcion = descripcion;
        this.gravedad = gravedad;
    }

    public int getIdDiagnostico() { return idDiagnostico; }
    public int getIdPaciente() { return idPaciente; }
    public String getDescripcion() { return descripcion; }
    public String getGravedad() { return gravedad; }
}