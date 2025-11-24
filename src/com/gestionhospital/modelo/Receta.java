package com.gestionhospital.modelo;

import java.util.ArrayList;
import java.util.List;

public class Receta {

    private int idReceta;
    private Paciente paciente;
    private Doctor doctor;
    private List<String> medicamentos;
    private String indicacionesGenerales;

    public Receta(int idReceta, Paciente paciente, Doctor doctor, String indicacionesGenerales) {
        this.idReceta = idReceta;
        this.paciente = paciente;
        this.doctor = doctor;
        this.indicacionesGenerales = indicacionesGenerales;
        this.medicamentos = new ArrayList<>();
    }

    public void agregarMedicamento(String medicamento) {
        medicamentos.add(medicamento);
    }

    public void mostrarReceta() {
        System.out.println("📝 Receta #" + idReceta);
        System.out.println("Paciente: " + paciente.getNombre());
        System.out.println("Doctor: " + doctor.getNombre());
        System.out.println("Medicamentos:");
        for (String m : medicamentos) {
            System.out.println(" - " + m);
        }
        System.out.println("Indicaciones generales: " + indicacionesGenerales);
    }

    // Getters
    public int getIdReceta() {
        return idReceta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public List<String> getMedicamentos() {
        return medicamentos;
    }

    public String getIndicacionesGenerales() {
        return indicacionesGenerales;
    }
}