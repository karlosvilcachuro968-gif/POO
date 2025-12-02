package com.gestionhospital.modelo;

public class Paciente {

    private int idPaciente; // SQL autogenera este ID
    private String nombre;
    private String tipoSeguro;
    private String nroHistoriaClinica;

    private int idDoctor; // FK hacia Doctor

    // Constructor SIN ID
    public Paciente(String nombre, String tipoSeguro, String nroHistoriaClinica, int idDoctor) {
        this.nombre = nombre;
        this.tipoSeguro = tipoSeguro;
        this.nroHistoriaClinica = nroHistoriaClinica;
        this.idDoctor = idDoctor;
    }

    // Getters
    public int getIdPaciente() {
        return idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public String getNroHistoriaClinica() {
        return nroHistoriaClinica;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    @Override
    public String toString() {
        return nombre + " (" + tipoSeguro + ")";
    }
}