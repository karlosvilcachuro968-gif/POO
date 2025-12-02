package com.gestionhospital.modelo;

public class HabitacionesDeEmergencia {
    private boolean equipadoConOxigeno;
    private boolean equipadoConMonitoreo;
    private int prioridadAtencion;
    private boolean ocupado;
    private String pacienteAsignadoId;

    public HabitacionesDeEmergencia(boolean equipadoConOxigeno, boolean equipadoConMonitoreo, int prioridadAtencion) {
        this.equipadoConOxigeno = equipadoConOxigeno;
        this.equipadoConMonitoreo = equipadoConMonitoreo;
        this.prioridadAtencion = prioridadAtencion;
        this.ocupado = false;
        this.pacienteAsignadoId = null;
    }

    public void activarProtocoloEmergencia() {
        System.out.println("Protocolo de emergencia activado: " + prioridadAtencion );
    }

    public void asignarPacienteCritico(String pacienteId) {
        this.pacienteAsignadoId = pacienteId;
        this.ocupado = true;
        System.out.println("Paciente crítico asignado: " + pacienteId);
    }

    public boolean verificarEquipamiento() {
        return equipadoConMonitoreo && equipadoConOxigeno;
    }

    public void liberarHabitacionEmergencia() {
        this.ocupado = false;
        this.pacienteAsignadoId = null;
        System.out.println("Habitación de emergencia liberada");
    }

    public boolean isEquipadoConOxigeno() {
        return equipadoConOxigeno;
    }
    public boolean isEquipadoConMonitoreo() {
        return equipadoConMonitoreo;
    }
    public int getPrioridadAtencion() {
        return prioridadAtencion;
    }
    public boolean isOcupado() {
        return ocupado;
    }
}

