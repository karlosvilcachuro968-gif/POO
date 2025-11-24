package com.gestionhospital.modelo;

public class HorarioDoctor {

    private int idHorario;
    private Doctor doctor;
    private String diaSemana;  // Lunes, Martes, etc.
    private String horaInicio; // "08:00"
    private String horaFin;    // "14:00"
    private boolean disponible;

    public HorarioDoctor(int idHorario, Doctor doctor,
                         String diaSemana, String horaInicio, String horaFin,
                         boolean disponible) {
        this.idHorario = idHorario;
        this.doctor = doctor;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.disponible = disponible;
    }

    public void marcarNoDisponible() {
        this.disponible = false;
    }

    public void marcarDisponible() {
        this.disponible = true;
    }

    // Getters
    public int getIdHorario() {
        return idHorario;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public boolean isDisponible() {
        return disponible;
    }

    @Override
    public String toString() {
        return "Horario de " + doctor.getNombre() +
                " - " + diaSemana +
                " de " + horaInicio + " a " + horaFin +
                " | Disponible: " + (disponible ? "Sí" : "No");
    }
}