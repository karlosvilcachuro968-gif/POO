package com.gestionhospital.modelo;

public class Paramedico extends ProfesionalSalud {

    private String nivelInformacion;
    private String vehiculoAsignado;

    public Paramedico(String id, String nombre, String apellido, int edad, String genero,
                      java.util.Date fechaNacimiento, String dni, String direccion, String telefono, String correo,
                      String especialidad, String horarioTrabajo,
                      String nivelInformacion, String vehiculoAsignado) {
        super(id, nombre, apellido, edad, genero, fechaNacimiento, dni, direccion, telefono, correo, especialidad, horarioTrabajo);
        this.nivelInformacion = nivelInformacion;
        this.vehiculoAsignado = vehiculoAsignado;
    }

    public void estabilizarPaciente() {
        System.out.println(getNombre() + " estabiliza al paciente.");
    }

    public void trasladarPaciente() {
        System.out.println(getNombre() + " traslada al paciente en " + vehiculoAsignado);
    }

    public String getNivelInformacion() {
        return nivelInformacion;
    }
    public String getVehiculoAsignado() {
        return vehiculoAsignado;
    }
}