package com.gestionhospital.modelo;

public class Cirugia extends Departamento {

    private int quirofanosDisponibles;

    public Cirugia(String nombre, String ubicacion, int quirafanosDisponibles) {
        super(nombre, ubicacion);
        this.quirofanosDisponibles = quirafanosDisponibles;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Departamento de Cirugía");
        System.out.println("Nombre: " + nombre);
        System.out.println("Ubicación: " + ubicacion);
        System.out.println("Quirófanos disponibles: " + quirofanosDisponibles);
    }

    public int getQuirafanosDisponibles() {
        return quirofanosDisponibles;
    }

    public void setQuirafanosDisponibles(int quirafanosDisponibles) {
        this.quirofanosDisponibles = quirafanosDisponibles;
    }
}