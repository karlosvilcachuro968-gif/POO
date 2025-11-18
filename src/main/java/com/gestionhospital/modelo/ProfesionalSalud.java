package com.gestionhospital.modelo;

public abstract class ProfesionalSalud {

    private String idProfesional;
    private String nombre;
    private String especialidad;

    public ProfesionalSalud(String idProfesional, String nombre, String especialidad) {
        this.idProfesional = idProfesional;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getIdProfesional() {
        return idProfesional;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public abstract void atenderPaciente();
}
