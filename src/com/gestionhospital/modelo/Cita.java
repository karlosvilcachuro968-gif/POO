package com.gestionhospital.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {

    private int idCita;
    private Paciente paciente;
    private Doctor doctor;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
    private String estado;
    // Ej: "Programada", "Atendida" o "Cancelada"

    public Cita(int idCita, Paciente paciente, Doctor doctor,
                LocalDate fecha, LocalTime hora,
                String motivo, String estado) {
        this.idCita = idCita;
        this.paciente = paciente;
        this.doctor = doctor;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.estado = estado;
    }


    public void marcarComoAtendida() {
        this.estado = "Atendida";
    }

    public void cancelarCita() {
        this.estado = "Cancelada";
    }

    // Getters y Setters
    public int getIdCita() {
        return idCita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cita #" + idCita +
                " - Paciente: " + paciente.getNombre() +
                " - Doctor: " + doctor.getNombre() +
                " - Fecha: " + fecha +
                " - Hora: " + hora +
                " - Estado: " + estado;
    }
}