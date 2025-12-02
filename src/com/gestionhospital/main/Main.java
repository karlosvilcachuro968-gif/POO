package com.gestionhospital.main;


import com.gestionhospital.conexion.ConexionBD;
import com.gestionhospital.modelo.*;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Connection conn = ConexionBD.conectar();

        if (conn == null) {
            System.out.println("No se pudo iniciar el programa por error en la conexión.");
            return;
        }

        HospitalPrivado hospital = new HospitalPrivado(
                "Hospital Privado Arequipa",
                "Av. Vidaurre 123",
                "054-222333"
        );

        int opcion;

        do {
            System.out.println("\n==============================");
            System.out.println("     SISTEMA HOSPITALARIO");
            System.out.println("==============================");
            System.out.println("1. Registrar Doctor");
            System.out.println("2. Registrar Paciente");
            System.out.println("3. Registrar Cita");
            System.out.println("4. Mostrar Doctores");
            System.out.println("5. Mostrar Pacientes");
            System.out.println("6. Mostrar Citas");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();  // limpiar buffer

            switch (opcion) {

                case 1 -> {
                    System.out.println("\n--- Registrar Doctor ---");

                    System.out.print("Nombre del doctor: ");
                    String nombre = sc.nextLine();

                    System.out.print("Especialidad: ");
                    String especialidad = sc.nextLine();

                    System.out.print("Salario: ");
                    double salario = sc.nextDouble();
                    sc.nextLine();

                    Doctor d = new Doctor(nombre, especialidad, salario);
                    hospital.guardarDoctorEnBD(d, conn);
                }

                case 2 -> {
                    System.out.println("\n--- Registrar Paciente ---");

                    System.out.print("Nombre del paciente: ");
                    String nombre = sc.nextLine();

                    System.out.print("Tipo de seguro: ");
                    String seguro = sc.nextLine();

                    System.out.print("Nro. Historia Clínica: ");
                    String historia = sc.nextLine();

                    System.out.print("ID del doctor asignado: ");
                    int idDoctor = sc.nextInt();
                    sc.nextLine();

                    Paciente p = new Paciente(nombre, seguro, historia, idDoctor);
                    hospital.guardarPacienteEnBD(p, conn);
                }

                case 3 -> {
                    System.out.println("\n--- Registrar Cita ---");

                    System.out.print("ID del paciente: ");
                    int idPaciente = sc.nextInt();
                    sc.nextLine();

                    System.out.print("ID del doctor: ");
                    int idDoctor = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Fecha (YYYY-MM-DD): ");
                    String fecha = sc.nextLine();

                    System.out.print("Hora (HH:MM): ");
                    String hora = sc.nextLine();

                    System.out.print("Motivo: ");
                    String motivo = sc.nextLine();

                    System.out.print("Estado (Programada/Cancelada/...): ");
                    String estado = sc.nextLine();

                    Cita c = new Cita(idPaciente, idDoctor, fecha, hora, motivo, estado);
                    hospital.guardarCitaEnBD(c, conn);
                }

                case 4 -> hospital.listarDoctoresSQL(conn);

                case 5 -> hospital.listarPacientesSQL(conn);

                case 6 -> hospital.listarCitasSQL(conn);

                case 7 -> System.out.println("\nSaliendo del sistema...");

                default -> System.out.println("Opción inválida, intenta nuevamente.");
            }

        } while (opcion != 7);
    }
}