package com.gestionhospital.modelo;

import java.util.ArrayList;
import java.util.List;

public class ReservaDeHabitaciones {

    private List<HabitacionesDeEmergencia> habitaciones;

    public ReservaDeHabitaciones() {
        habitaciones = new ArrayList<>();
    }

    public void agregarHabitacion(HabitacionesDeEmergencia habitacion) {
        habitaciones.add(habitacion);
    }

    public void asignarPacienteCritico(int idPaciente) {
        for (HabitacionesDeEmergencia h : habitaciones) {
            if (!h.isOcupado()) {
                h.asignarPacienteCritico(idPaciente);
                return;
            }
        }
        System.out.println("No hay habitaciones disponibles para pacientes críticos.");
    }

    public void liberarHabitacion(int idHabitacion) {
        for (HabitacionesDeEmergencia h : habitaciones) {
            if (h.getIdHabitacion() == idHabitacion) {
                h.liberarHabitacionEmergencia();
                return;
            }
        }
        System.out.println("Habitación no encontrada.");
    }

    public void mostrarEquipamiento() {
        for (HabitacionesDeEmergencia h : habitaciones) {
            System.out.println("Habitación ID: " + h.getIdHabitacion() +
                    " - Equipamiento completo: " + h.verificarEquipamiento());
        }
    }

    public void listarHabitaciones() {
        for (HabitacionesDeEmergencia h : habitaciones) {
            h.mostrarInfo();
            System.out.println("------------------------");
        }
    }
}