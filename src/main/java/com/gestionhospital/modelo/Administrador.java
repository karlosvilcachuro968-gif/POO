package com.gestionhospital.modelo;

import java.util.Date;

public class Administrador extends Personal implements IGestionable {

    private String usuario;
    private String contrasena;

    public Administrador(String id, String nombre, String apellido, int edad, String genero,
                         Date fechaNacimiento, String dni, String direccion, String telefono,
                         String correo, String rol, float salario, String usuario, String contrasena) {
        super(id, nombre, apellido, edad, genero, fechaNacimiento, dni, direccion, telefono, correo, rol, salario);
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario; }

    public void registrarDoctor(Doctor doctor) {
        System.out.println("Doctor registrado: " + doctor.getNombre());
    }

    public void eliminarDoctor(Doctor doctor) {
        System.out.println("Doctor eliminado: " + doctor.getNombre());
    }

    public void editarPaciente(Paciente paciente) {
        System.out.println("Editando datos del paciente: " + paciente.getNombre());
    }

    public void generarReporte() {
        System.out.println("Generando reporte del hospital");
    }

    @Override
    public void registrar() {
        System.out.println("Administrador registrado: " + getNombre());
    }

    @Override
    public void editar() {
        System.out.println("Editando datos del administrador: " + getNombre());
    }

    @Override
    public void eliminar() {
        System.out.println("Eliminando administrador: " + getNombre());
    }

    @Override
    public String toString() {
        return getNombre() + " (Administrador)";
    }
}

