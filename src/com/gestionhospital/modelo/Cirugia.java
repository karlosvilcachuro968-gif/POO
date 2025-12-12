package com.gestionhospital.modelo;

public class Cirugia extends Departamento {

    private int quirafanosDisponibles;
    private String fechaProgramada; // opcional

    // Constructor compatible con Main: (nombre, ubicacion, quirafanos)
    public Cirugia(String nombre, String ubicacion, int quirafanosDisponibles) {
        super(nombre, ubicacion);
        this.quirafanosDisponibles = quirafanosDisponibles;
        this.fechaProgramada = null;
    }

    public Cirugia(String nombre, String ubicacion, String fechaProgramada, int quirafanosDisponibles) {
        super(nombre, ubicacion);
        this.fechaProgramada = fechaProgramada;
        this.quirafanosDisponibles = quirafanosDisponibles;
    }

    public int getQuirafanosDisponibles() { return quirafanosDisponibles; }
    public String getFechaProgramada() { return fechaProgramada; }
    public void setFechaProgramada(String fechaProgramada) { this.fechaProgramada = fechaProgramada; }

    @Override
    public void mostrarInformacion() {
        System.out.println("Cirugía: " + nombre + " | Ubicación: " + ubicacion + " | Quirófanos: " + quirafanosDisponibles);
    }
}