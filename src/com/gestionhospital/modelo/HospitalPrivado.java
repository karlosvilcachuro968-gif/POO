package com.gestionhospital.modelo;

import java.util.ArrayList;
import java.util.List;

public class HospitalPrivado {

    private String nombre;
    private String direccion;
    private String telefono;

    private List<Doctor> doctores;
    private List<Paciente> pacientes;
    private List<Departamento> departamentos;

    public HospitalPrivado(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.doctores = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.departamentos = new ArrayList<>();
    }

    public void agregarDoctor(Doctor doctor) {
        doctores.add(doctor);
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void mostrarInformacion() {
        System.out.println(" Hospital: " + nombre);
        System.out.println(" Dirección: " + direccion);
        System.out.println(" Teléfono: " + telefono);
        System.out.println(" Doctores: " + doctores.size());
        System.out.println(" Pacientes: " + pacientes.size());
    }

}