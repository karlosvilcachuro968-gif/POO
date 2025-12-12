package com.gestionhospital.modelo;

public class Doctor {

    private int idDoctor; // SQL lo generará si usas la inserción sin id
    private String nombre;
    private String especialidad;
    private double salario;

    // Constructor original (registro)
    public Doctor(String nombre, String especialidad, double salario) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.salario = salario;
    }

    // Sobrecarga usada por tu Main: new Doctor("", "", idDoctor)
    public Doctor(String nombre, String especialidad, int idDoctor) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.idDoctor = idDoctor;
        this.salario = 0.0;
    }

    public int getIdDoctor() { return idDoctor; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public double getSalario() { return salario; }

    @Override
    public String toString() { return nombre + " (" + especialidad + ")"; }
}