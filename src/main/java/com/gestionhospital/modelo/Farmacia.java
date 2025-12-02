package com.gestionhospital.modelo;

import java.util.ArrayList;
import java.util.List;

public class Farmacia {

    private ProfesionalSalud encargado;
    private List<Medicamento> listaMedicamentos;
    private List<Receta> listaRecetas;

    public Farmacia(ProfesionalSalud encargado) {
        this.encargado = encargado;
        this.listaMedicamentos = new ArrayList<>();
        this.listaRecetas = new ArrayList<>();
    }

    public void despacharMedicamento(Paciente p, Medicamento m) {
        if (m.comprobarDisponibilidad()) {
            m.proporcionar(1);
            System.out.println("Despachado " + m.getNombre() + " a " + p.getNombre());
        } else {
            System.out.println("No hay stock de " + m.getNombre());
        }
    }

    public void registrarReceta(Receta r) {
        listaRecetas.add(r);
        System.out.println("Receta registrada para el paciente: " + r.getPaciente().getNombre());
    }

    public void mostrarStock() {
        System.out.println("Stock de farmacia:");
        for (Medicamento m : listaMedicamentos) {
            System.out.println(" - " + m.getNombre() + " : " + m.getCantidadDisponible());
        }
    }

    public void agregarMedicamentoAlStock(Medicamento m) {
        listaMedicamentos.add(m);
    }

    public ProfesionalSalud getEncargado() {
        return encargado;
    }
    public List<Medicamento> getListaMedicamentos() {
        return listaMedicamentos;
    }
}
