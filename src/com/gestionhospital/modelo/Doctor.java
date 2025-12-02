package com.gestionhospital.modelo;

public class Doctor {

    private int idDoctor; // SQL lo generará
    private String nombre;
    private String especialidad;
    private double salario;

    // Constructor SIN ID
    public Doctor(String nombre, String especialidad, double salario) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.salario = salario;
    }

    // Getters
    public int getIdDoctor() {
        return idDoctor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return nombre + " (" + especialidad + ")";
    }
}