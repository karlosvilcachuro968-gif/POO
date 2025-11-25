package com.gestionhospital.modelo;

public class Paciente {
    private int idPaciente;
    private String nombre;
    private String tipoSeguro;
    private String nroHistoriaClinica;

    public Paciente(int idPaciente, String nombre, String tipoSeguro, String nroHistoriaClinica) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.tipoSeguro = tipoSeguro;
        this.nroHistoriaClinica = nroHistoriaClinica;
    }


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

    @Override
    public String toString() {
        return nombre + " (" + tipoSeguro + ")";
    }
}