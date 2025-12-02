package com.gestionhospital.modelo;

public class Medicamento {

    private String nombre;
    private String codigo;
    private int cantidadDisponible;
    private float precioUnitario;

    public Medicamento(String nombre, String codigo, int cantidadDisponible, float precioUnitario) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cantidadDisponible = cantidadDisponible;
        this.precioUnitario = precioUnitario;
    }

    public boolean comprobarDisponibilidad() {
        return cantidadDisponible > 0;
    }

    public void proporcionar(int cantidad) {
        if (cantidad <= cantidadDisponible) {
            cantidadDisponible -= cantidad;
            System.out.println("Proporcionado " + cantidad + " de " + nombre);
        } else {
            System.out.println("Stock insuficiente para " + nombre);
        }
    }

    public void actualizarStock(int cantidad) {
        this.cantidadDisponible += cantidad;
        System.out.println("Stock actualizado para " + nombre + ". Nuevo stock: " + cantidadDisponible);
    }

    public String getNombre() {
        return nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }
    public float getPrecioUnitario() {
        return precioUnitario;
    }
}