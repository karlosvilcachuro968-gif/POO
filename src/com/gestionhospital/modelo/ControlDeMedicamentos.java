package com.gestionhospital.modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ControlDeMedicamentos {

    public static Medicamento buscarPorCodigo(List<Medicamento> lista, String codigo) {
        for (Medicamento m : lista) {
            if (m.getCodigo().equalsIgnoreCase(codigo)) {
                return m;
            }
        }
        return null;
    }

    public static List<Medicamento> buscarPorNombre(List<Medicamento> lista, String nombre) {
        List<Medicamento> resultado = new ArrayList<>();
        for (Medicamento m : lista) {
            if (m.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    public static List<Medicamento> obtenerAgotados(List<Medicamento> lista) {
        List<Medicamento> agotados = new ArrayList<>();
        for (Medicamento m : lista) {
            if (m.getCantidadDisponible() == 0) {
                agotados.add(m);
            }
        }
        return agotados;
    }

    public static List<Medicamento> obtenerCriticos(List<Medicamento> lista, int umbral) {
        List<Medicamento> criticos = new ArrayList<>();
        for (Medicamento m : lista) {
            if (m.getCantidadDisponible() <= umbral) {
                criticos.add(m);
            }
        }
        return criticos;
    }

    public static List<Medicamento> ordenarPorStock(List<Medicamento> lista) {
        lista.sort(Comparator.comparingInt(Medicamento::getCantidadDisponible));
        return lista;
    }

    public static void reponerStock(Medicamento medicamento, int cantidad) {
        medicamento.actualizarStock(cantidad);
        System.out.println("Reposición completada para: " + medicamento.getNombre());
    }

    public static boolean requierePedido(Medicamento m, int umbral) {
        return m.getCantidadDisponible() <= umbral;
    }
}