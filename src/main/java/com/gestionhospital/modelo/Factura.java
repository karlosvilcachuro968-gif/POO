package com.gestionhospital.modelo;

import java.time.LocalDate;
import java.util.List;

public class Factura {

    private String idFactura;
    private Paciente paciente;
    private LocalDate fechaEmision;
    private float total;
    private String detalle;

    public Factura(String idFactura, Paciente paciente, LocalDate fechaEmision, String detalle) {
        this.idFactura = idFactura;
        this.paciente = paciente;
        this.fechaEmision = fechaEmision;
        this.detalle = detalle;
        this.total = 0.0f;
    }

    public void generarFactura(List<Medicamento> items) {
        float suma = 0f;
        StringBuilder sb = new StringBuilder();
        for (Medicamento m : items) {
            suma += m.getPrecioUnitario();
            sb.append(m.getNombre()).append(", ");
        }
        this.total = suma;
        this.detalle = sb.toString();
        System.out.println("Factura " + idFactura + " generada. Total: " + total);
    }

    public void verFactura() {
        System.out.println("Factura " + idFactura + " Paciente: " + paciente.getNombre() + " Fecha: " + fechaEmision + " Total: " + total);
        System.out.println("Detalle: " + detalle);
    }

    public float calcularTotal() {
        return total;
    }

    public String getIdFactura() {
        return idFactura;
    }
}