package com.gestionhospital.modelo;

import java.util.ArrayList;
import java.util.List;

public class ReservaDeHabitaciones {

    private List<HabitacionesDeEmergencia> habitaciones;

    public ReservaDeHabitaciones() {
        this.habitaciones = new ArrayList<>();
    }

    public void agregarHabitacion(HabitacionesDeEmergencia h) {
        habitaciones.add(h);
    }

    public List<HabitacionesDeEmergencia> obtenerDisponibles() {
        List<HabitacionesDeEmergencia> libres = new ArrayList<>();

        for (HabitacionesDeEmergencia h : habitaciones) {
            if (!h.isOcupado()) {
                libres.add(h);
            }
        }
        return libres;
    }

    public boolean reservarHabitacion(int prioridad, String pacienteId) {
        for (HabitacionesDeEmergencia h : habitaciones) {
            if (!h.isOcupado() && h.getPrioridadAtencion() == prioridad) {
                h.asignarPacienteCritico(pacienteId);
                System.out.println("Habitación asignada al paciente: " + pacienteId);
                return true;
            }
        }
        System.out.println("No hay habitaciones disponibles con prioridad " + prioridad);
        return false;
    }

    public void liberarHabitacion(HabitacionesDeEmergencia h) {
        if (h.isOcupado()) {
            h.liberarHabitacionEmergencia();
        } else {
            System.out.println("La habitación ya está libre.");
        }
    }

    public List<HabitacionesDeEmergencia> buscarPorPrioridad(int prioridad) {
        List<HabitacionesDeEmergencia> resultado = new ArrayList<>();
        for (HabitacionesDeEmergencia h : habitaciones) {
            if (h.getPrioridadAtencion() == prioridad) {
                resultado.add(h);
            }
        }
        return resultado;
    }

    public void mostrarHabitaciones() {
        System.out.println("Habitaciones de Emergencia:");
        for (HabitacionesDeEmergencia h : habitaciones) {
            System.out.println("- Prioridad " + h.getPrioridadAtencion() +
                    " Equipamiento: " + h.verificarEquipamiento() +
                    " Ocupada: " + h.isOcupado());
        }
    }
}