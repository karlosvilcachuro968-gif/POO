package com.gestionhospital.modelo;

public class Enfermero {

    private int idEnfermero;
    private String nombre;
    private String turno;     // Mañana, Tarde o Noche
    private String area;      //  Emergencia, Cirugía, etc.

    public Enfermero(int idEnfermero, String nombre, String turno, String area) {
        this.idEnfermero = idEnfermero;
        this.nombre = nombre;
        this.turno = turno;
        this.area = area;
    }

    // Getters y Setters
    public int getIdEnfermero() {
        return idEnfermero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTurno() {
        return turno;
    }

    public String getArea() {
        return area;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Enfermero: " + nombre + " - Turno: " + turno + " - Área: " + area;
    }
}