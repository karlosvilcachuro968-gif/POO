package com.gestionhospital.modelo;

public class Cirugia extends Departamento {

    private int quirafanosDisponibles;

    public Cirugia(String nombre, String ubicacion, int quirafanosDisponibles) {
        super(nombre, ubicacion);
        this.quirafanosDisponibles = quirafanosDisponibles;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("🔪 Departamento de Cirugía");
        System.out.println("Nombre: " + nombre);
        System.out.println("Ubicación: " + ubicacion);
        System.out.println("Quirófanos disponibles: " + quirafanosDisponibles);
    }

    public int getQuirafanosDisponibles() {
        return quirafanosDisponibles;
    }

    public void setQuirafanosDisponibles(int quirafanosDisponibles) {
        this.quirafanosDisponibles = quirafanosDisponibles;
    }
}