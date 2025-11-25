package com.gestionhospital.modelo;

import java.util.Date;

public class Personal extends Persona {

    private String rol;
    private float salario;

    public Personal(String id, String nombre, String apellido, int edad, String genero,
                    Date fechaNacimiento, String dni, String direccion, String telefono,
                    String correo, String rol, float salario) {

        super(id, nombre, apellido, edad, genero, fechaNacimiento, dni, direccion, telefono, correo);
        this.rol = rol;
        this.salario = salario;
    }

    public String getRol() {
        return rol; }
    public float getSalario() {
        return salario; }

    public void ayudarPaciente(Paciente paciente) {
        System.out.println(getNombre() + " está ayudando al paciente " + paciente.getNombre());
    }

    public void ayudarDoctor(Doctor doctor) {
        System.out.println(getNombre() + " está apoyando al doctor " + doctor.getNombre());
    }

    public void registrar() {
        System.out.println("Registrando personal: " + getNombre());
    }

    public void actualizarDatos() {
        System.out.println("Actualizando datos de personal: " + getNombre());
    }

    public void verDatos() {
        System.out.println("Datos de personal: " + toString());
    }
}


