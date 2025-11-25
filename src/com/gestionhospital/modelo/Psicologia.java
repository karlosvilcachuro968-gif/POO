package com.gestionhospital.modelo;

public class Psicologia extends Departamento {

    private int sesionesDisponibles;

    public Psicologia(String nombre, String ubicacion, int sesionesDisponibles) {
        super(nombre, ubicacion);
        this.sesionesDisponibles = sesionesDisponibles;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Departamento de Psicología");
        System.out.println("Nombre: " + nombre);
        System.out.println("Ubicación: " + ubicacion);
        System.out.println("Sesiones disponibles: " + sesionesDisponibles);
    }

    public int getSesionesDisponibles() {
        return sesionesDisponibles;
    }

    public void setSesionesDisponibles(int sesionesDisponibles) {
        this.sesionesDisponibles = sesionesDisponibles;
    }
}