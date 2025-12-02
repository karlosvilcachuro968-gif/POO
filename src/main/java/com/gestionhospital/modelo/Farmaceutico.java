package com.gestionhospital.modelo;

import java.util.Date;

public class Farmaceutico extends ProfesionalSalud {

    private String licenciaFarmaceutica;
    private String areaFarmacia;

    public Farmaceutico(String id, String nombre, String apellido, int edad, String genero,
                        Date fechaNacimiento, String dni, String direccion, String telefono, String correo,
                        String especialidad, String horarioTrabajo,
                        String licenciaFarmaceutica, String areaFarmacia) {

        super(id, nombre, apellido, edad, genero, fechaNacimiento,
                dni, direccion, telefono, correo, especialidad, horarioTrabajo);

        this.licenciaFarmaceutica = licenciaFarmaceutica;
        this.areaFarmacia = areaFarmacia;
    }

    public void gestionarMedicamentos() {
        System.out.println(getNombre() + " gestiona el stock del área: " + areaFarmacia);
    }

    public void verificarPrescripciones(Receta receta) {
        System.out.println(getNombre() + " verifica la receta " + receta.getIdReceta() + " para el paciente " + receta.getPaciente().getNombre());
    }

    public String getLicenciaFarmaceutica() {
        return licenciaFarmaceutica;
    }
}
