package com.gestionhospital.modelo;

public class Doctor {
    private int idDoctor;
    private String nombre;
    private String especialidad;
    private double salario;

    public Doctor(int idDoctor, String nombre, String especialidad, double salario) {
        this.idDoctor = idDoctor;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.salario = salario;
    }


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