package com.gestionhospital.modelo;

public class HabitacionesDeEmergencia {

    private int idHabitacion;
    private int prioridadAtencion;
    private boolean equipadoConOxigeno;
    private boolean equipadoConMonitoreo;
    private boolean ocupado;
    private Integer pacienteAsignado; // null si está libre

    public HabitacionesDeEmergencia(boolean equipadoConOxigeno, boolean equipadoConMonitoreo, int prioridadAtencion) {
        this.equipadoConOxigeno = equipadoConOxigeno;
        this.equipadoConMonitoreo = equipadoConMonitoreo;
        this.prioridadAtencion = prioridadAtencion;
        this.ocupado = false;
        this.pacienteAsignado = null;
    }

    public void asignarPacienteCritico(int idPaciente) {
        if (!ocupado) {
            this.pacienteAsignado = idPaciente;
            this.ocupado = true;
            System.out.println("Paciente crítico asignado a la habitación: " + idPaciente);
        } else {
            System.out.println("La habitación ya está ocupada.");
        }
    }

    public void liberarHabitacionEmergencia() {
        this.ocupado = false;
        this.pacienteAsignado = null;
        System.out.println("Habitación liberada.");
    }

    public boolean verificarEquipamiento() {
        return equipadoConOxigeno && equipadoConMonitoreo;
    }

    public void mostrarInfo() {
        System.out.println("Habitación ID: " + idHabitacion);
        System.out.println("Prioridad: " + prioridadAtencion);
        System.out.println("Equipamiento: Oxígeno(" + equipadoConOxigeno + "), Monitoreo(" + equipadoConMonitoreo + ")");
        System.out.println("Ocupado: " + ocupado);
        if (ocupado) {
            System.out.println("Paciente asignado: " + pacienteAsignado);
        }
    }

    // Getters y setters
    public int getIdHabitacion() { return idHabitacion; }
    public void setIdHabitacion(int idHabitacion) { this.idHabitacion = idHabitacion; }
    public int getPrioridadAtencion() { return prioridadAtencion; }
    public boolean isOcupado() { return ocupado; }
    public Integer getPacienteAsignado() { return pacienteAsignado; }
    public boolean isEquipadoConOxigeno() { return equipadoConOxigeno; }
    public boolean isEquipadoConMonitoreo() { return equipadoConMonitoreo; }
}
