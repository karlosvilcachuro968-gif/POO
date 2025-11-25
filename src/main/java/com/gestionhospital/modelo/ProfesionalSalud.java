package com.gestionhospital.modelo;

import java.util.Date;

public abstract class ProfesionalSalud extends Persona {

    protected String especialidad;
    protected String horarioTrabajo;

    public ProfesionalSalud(String id, String nombre, String apellido, int edad, String genero,
                            Date fechaNacimiento, String dni, String direccion, String telefono,
                            String correo, String especialidad, String horarioTrabajo) {

        super(id, nombre, apellido, edad, genero, fechaNacimiento, dni, direccion, telefono, correo);

        this.especialidad = especialidad;
        this.horarioTrabajo = horarioTrabajo;
    }

    public void registrarEntrada() {
        System.out.println(getNombre() + " registró entrada.");
    }

    public void registrarSalida() {
        System.out.println(getNombre() + " registró salida.");
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public String getHorarioTrabajo() {
        return horarioTrabajo;
    }
    public void setHorarioTrabajo(String horarioTrabajo) {
        this.horarioTrabajo = horarioTrabajo;
    }
}