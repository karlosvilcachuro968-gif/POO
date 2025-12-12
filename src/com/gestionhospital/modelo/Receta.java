package com.gestionhospital.modelo;

import java.util.ArrayList;
import java.util.List;

public class Receta {

    private int idReceta; // generado en BD
    private Paciente paciente;
    private Doctor doctor;
    private List<String> medicamentos;
    private String indicacionesGenerales;

    public Receta(Paciente paciente, Doctor doctor, String indicacionesGenerales) {
        this.paciente = paciente;
        this.doctor = doctor;
        this.indicacionesGenerales = indicacionesGenerales;
        this.medicamentos = new ArrayList<>();
    }

    public void agregarMedicamento(String medicamento) { medicamentos.add(medicamento); }

    public int getIdReceta() { return idReceta; }
    public Paciente getPaciente() { return paciente; }
    public Doctor getDoctor() { return doctor; }
    public List<String> getMedicamentos() { return medicamentos; }
    public String getIndicacionesGenerales() { return indicacionesGenerales; }
}