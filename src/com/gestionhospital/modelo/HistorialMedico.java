package com.gestionhospital.modelo;

import java.util.ArrayList;
import java.util.List;

public class HistorialMedico {

    private int idHistorial;
    private Paciente paciente;
    private List<String> diagnosticos;
    private List<String> tratamientos;

    public HistorialMedico(int idHistorial, Paciente paciente) {
        this.idHistorial = idHistorial;
        this.paciente = paciente;
        this.diagnosticos = new ArrayList<>();
        this.tratamientos = new ArrayList<>();
    }

    public void agregarDiagnostico(String diagnostico) {
        diagnosticos.add(diagnostico);
    }

    public void agregarTratamiento(String tratamiento) {
        tratamientos.add(tratamiento);
    }

    public void mostrarHistorial() {
        System.out.println(" Historial médico de: " + paciente.getNombre());
        System.out.println("Diagnósticos:");
        for (String d : diagnosticos) {
            System.out.println(" - " + d);
        }
        System.out.println("Tratamientos:");
        for (String t : tratamientos) {
            System.out.println(" - " + t);
        }
    }

    // Getters
    public int getIdHistorial() {
        return idHistorial;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public List<String> getDiagnosticos() {
        return diagnosticos;
    }

    public List<String> getTratamientos() {
        return tratamientos;
    }
}
