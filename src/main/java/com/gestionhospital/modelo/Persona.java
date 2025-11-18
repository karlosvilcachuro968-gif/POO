package com.gestionhospital.modelo;

import java.util.Date;

    public class Persona {

        private String id;
        private String nombre;
        private String apellido;
        private int edad;
        private String genero;
        private Date fechaNacimiento;
        private String dni;
        private String direccion;
        private String telefono;
        private String correo;

        public Persona(String id, String nombre, String apellido, int edad, String genero,
                       Date fechaNacimiento, String dni, String direccion, String telefono, String correo) {

            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
            this.genero = genero;
            this.fechaNacimiento = fechaNacimiento;
            this.dni = dni;
            this.direccion = direccion;
            this.telefono = telefono;
            this.correo = correo;
        }
        public String getId() {
            return id; }
        public String getNombre() {
            return nombre; }
        public String getApellido() {
            return apellido; }
        public int getEdad() {
            return edad; }
        public String getGenero() {
            return genero; }
        public Date getFechaNacimiento() {
            return fechaNacimiento; }
        public String getDni() {
            return dni; }
        public String getDireccion() {
            return direccion; }
        public String getTelefono() {
            return telefono; }
        public String getCorreo() {
            return correo; }

        @Override
        public String toString() {
            return nombre + " " + apellido;
        }
    }

