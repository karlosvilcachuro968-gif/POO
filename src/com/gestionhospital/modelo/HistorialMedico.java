package com.gestionhospital.modelo;

import java.util.ArrayList;
import java.util.List;

public class HistorialMedico {

    private int idHistorial; // generado en BD
    private Paciente paciente;
    private List<String> diagnosticos;
    private List<String> tratamientos;

    public HistorialMedico(Paciente paciente) {
        this.paciente = paciente;
        this.diagnosticos = new ArrayList<>();
        this.tratamientos = new ArrayList<>();
    }

    public void agregarDiagnostico(String diagnostico) { diagnosticos.add(diagnostico); }
    public void agregarTratamiento(String tratamiento) { tratamientos.add(tratamiento); }

    public int getIdHistorial() { return idHistorial; }
    public Paciente getPaciente() { return paciente; }
    public List<String> getDiagnosticos() { return diagnosticos; }
    public List<String> getTratamientos() { return tratamientos; }
}