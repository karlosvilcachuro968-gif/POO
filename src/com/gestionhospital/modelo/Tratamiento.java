package com.gestionhospital.modelo;

public class Tratamiento {
    private int idTratamiento;
    private int idPaciente;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;

    public Tratamiento(int idPaciente, String descripcion, String fechaInicio, String fechaFin) {
        this.idPaciente = idPaciente;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getIdTratamiento() { return idTratamiento; }
    public int getIdPaciente() { return idPaciente; }
    public String getDescripcion() { return descripcion; }
    public String getFechaInicio() { return fechaInicio; }
    public String getFechaFin() { return fechaFin; }
}