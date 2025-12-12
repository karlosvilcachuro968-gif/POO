package com.gestionhospital.modelo;

import java.util.Date;

public class Paciente extends Persona {

    private int idPaciente; // si la BD lo genera, se queda en 0 hasta insertar
    private String tipoSeguro;
    private String nroHistoriaClinica;
    private int idDoctor; // FK hacia Doctor

    /**
     * Constructor compatible con Main cuando usas:
     * new Paciente(nombre, tipoSeguro, nroHistoriaClinica, idDoctor)
     *
     * Y también es usado en algunos puntos del Main como placeholder:
     * new Paciente("", "", "", idPaciente) -> en ese caso se interpreta que
     * el entero pasado es el idPaciente.
     */
    public Paciente(String nombre, String tipoSeguro, String nroHistoriaClinica, int numero) {
        // Llamada puente a super() con valores por defecto (Opción A)
        super("0", nombre, "", 0, "No Aplica", new Date(), "0", "No Aplica", "0", "No Aplica");

        // Si nombre está vacío lo tratamos como constructor placeholder (numero = idPaciente)
        if (nombre == null || nombre.trim().isEmpty()) {
            this.idPaciente = numero;
            this.idDoctor = 0;
        } else {
            this.idDoctor = numero; // aquí numero representa idDoctor (compatible con Main al registrar)
        }
        this.tipoSeguro = tipoSeguro;
        this.nroHistoriaClinica = nroHistoriaClinica;
    }

    // Constructor explícito para crear con idDoctor
    public Paciente(String nombre, String tipoSeguro, String nroHistoriaClinica, int idDoctor, boolean nuevo) {
        super("0", nombre, "", 0, "No Aplica", new Date(), "0", "No Aplica", "0", "No Aplica");
        this.tipoSeguro = tipoSeguro;
        this.nroHistoriaClinica = nroHistoriaClinica;
        this.idDoctor = idDoctor;
        this.idPaciente = 0;
    }

    // Getters y setters
    public int getIdPaciente() { return idPaciente; }
    public void setIdPaciente(int idPaciente) { this.idPaciente = idPaciente; }
    public String getTipoSeguro() { return tipoSeguro; }
    public String getNroHistoriaClinica() { return nroHistoriaClinica; }
    public int getIdDoctor() { return idDoctor; }

    @Override
    public String toString() {
        return getNombre() + " (Historia: " + nroHistoriaClinica + ")";
    }
}