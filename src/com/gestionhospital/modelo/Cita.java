package com.gestionhospital.modelo;

public class Cita {

    private int idCita;
    private int idPaciente;
    private int idDoctor;
    private String fecha;              // DATE (YYYY-MM-DD)
    private String hora;               // HH:MM
    private String motivo;
    private String estado;

    public Cita(int idPaciente, int idDoctor, String fecha, String hora, String motivo, String estado) {
        this.idPaciente = idPaciente;
        this.idDoctor = idDoctor;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.estado = estado;
    }

    // Getters
    public int getIdPaciente() { return idPaciente; }
    public int getIdDoctor() { return idDoctor; }
    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
    public String getMotivo() { return motivo; }
    public String getEstado() { return estado; }
}