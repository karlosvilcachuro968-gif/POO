package com.gestionhospital.modelo;

import java.util.List;

public class Administrador extends ProfesionalSalud implements IGestionable {

    private String usuario;
    private String contrasena;

    public Administrador(String id, String nombre, String apellido, int edad, String genero,
                         java.util.Date fechaNacimiento, String dni, String direccion, String telefono, String correo,
                         String especialidad, String horarioTrabajo,
                         String usuario, String contrasena, double salario) {
        super(id, nombre, apellido, edad, genero, fechaNacimiento, dni, direccion, telefono, correo, especialidad, horarioTrabajo);
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    // IGestionable
    @Override
    public void registrar() {
        System.out.println("Administrador " + getNombre() + " registrado con usuario: " + usuario);
    }

    @Override
    public void editar() {
        System.out.println("Administrador " + getNombre() + " editado.");
    }

    @Override
    public void eliminar() {
        System.out.println("Administrador " + getNombre() + " eliminado.");
    }

    public void registrarDoctor(Doctor doctor, List<Doctor> listaDoctores) {
        listaDoctores.add(doctor);
        System.out.println("Doctor registrado: " + doctor.getNombre());
    }

    public void eliminarDoctor(Doctor doctor, List<Doctor> listaDoctores) {
        listaDoctores.remove(doctor);
        System.out.println("Doctor eliminado: " + doctor.getNombre());
    }

    public void editarPaciente(Paciente paciente) {
        System.out.println("Editar datos del paciente: " + paciente.getNombre());
    }

    public void generarReporte() {
        System.out.println("Generando reporte administrativo...");
    }

    public String getUsuario() {
        return usuario;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}