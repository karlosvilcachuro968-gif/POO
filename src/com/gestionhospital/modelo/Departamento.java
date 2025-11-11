package com.gestionhospital.modelo;

public abstract class Departamento {
    protected String nombre;
    protected String ubicacion;

    public Departamento(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    // Método abstracto quelas subclases deberán implementar
    public abstract void mostrarInformacion();


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}