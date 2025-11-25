package com.gestionhospital.modelo;

public class SignosVitales {

    private int idSignos;
    private Paciente paciente;
    private double temperatura;
    private int frecuenciaCardiaca;
    private int presionSistolica;
    private int presionDiastolica;

    public SignosVitales(int idSignos, Paciente paciente,
                         double temperatura,
                         int frecuenciaCardiaca,
                         int presionSistolica,
                         int presionDiastolica) {
        this.idSignos = idSignos;
        this.paciente = paciente;
        this.temperatura = temperatura;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.presionSistolica = presionSistolica;
        this.presionDiastolica = presionDiastolica;
    }

    public boolean tieneFiebre() {
        return temperatura >= 38.0;
    }

    public void mostrarSignos() {
        System.out.println("Signos vitales de " + paciente.getNombre());
        System.out.println("Temperatura: " + temperatura + " °C");
        System.out.println("Frecuencia cardíaca: " + frecuenciaCardiaca + " lpm");
        System.out.println("Presión arterial: " + presionSistolica + "/" + presionDiastolica + " mmHg");
    }

    // Getters
    public int getIdSignos() {
        return idSignos;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public int getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public int getPresionSistolica() {
        return presionSistolica;
    }

    public int getPresionDiastolica() {
        return presionDiastolica;
    }
}