package com.gestionhospital.modelo;

import java.util.Date;

public class Enfermero extends ProfesionalSalud {

    private int idEnfermero;
    private String turno;
    private String area;

    // Constructor compatible con Main: new Enfermero(0, nombre, turno, area)
    public Enfermero(int idEnfermero, String nombre, String turno, String area) {
        // Llamamos a super() con valores por defecto (opción A)
        super("0", nombre, "", 0, "No Aplica", new Date(), "0", "No Aplica", "0", "No Aplica", "Enfermeria", "Turno");
        this.idEnfermero = idEnfermero;
        this.turno = turno;
        this.area = area;
    }

    // Constructor completo si necesitas
    public Enfermero(String id, String nombre, String apellido, int edad, String genero, Date fechaNacimiento,
                     String dni, String direccion, String telefono, String correo,
                     String especialidad, String horarioTrabajo, int idEnfermero, String turno, String area) {
        super(id, nombre, apellido, edad, genero, fechaNacimiento, dni, direccion, telefono, correo, especialidad, horarioTrabajo);
        this.idEnfermero = idEnfermero;
        this.turno = turno;
        this.area = area;
    }

    public int getIdEnfermero() { return idEnfermero; }
    public String getTurno() { return turno; }
    public String getArea() { return area; }

    @Override
    public String toString() {
        return "Enfermero: " + getNombre() + " - Turno: " + turno + " - Área: " + area;
    }
}