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
            System.out.println("4. Registrar Enfermero");
            System.out.println("5. Registrar Medicamento");
            System.out.println("6. Registrar Habitación de Emergencia");
            System.out.println("7. Registrar Cirugía");
            System.out.println("8. Registrar Historial Médico");
            System.out.println("9. Registrar Receta");
            System.out.println("10. Mostrar Doctores");
            System.out.println("11. Mostrar Pacientes");
            System.out.println("12. Mostrar Citas");
            System.out.println("13. Mostrar Enfermeros");
            System.out.println("14. Mostrar Medicamentos");
            System.out.println("15. Mostrar Habitaciones");
            System.out.println("16. Mostrar Cirugías");
            System.out.println("17. Mostrar Historiales Médicos");
            System.out.println("18. Mostrar Recetas");
            System.out.println("19. Eliminar Doctor");
            System.out.println("20. Eliminar Paciente");
            System.out.println("21. Eliminar Cita");
            System.out.println("22. Eliminar Enfermero");
            System.out.println("23. Eliminar Medicamento");
            System.out.println("24. Registrar Operación");
            System.out.println("25. Mostrar Operaciones");
            System.out.println("26. Eliminar Operación");
            System.out.println("27. Registrar Tratamiento");
            System.out.println("28. Mostrar Tratamientos");
            System.out.println("29. Eliminar Tratamiento");
            System.out.println("30. Registrar Diagnóstico");
            System.out.println("31. Mostrar Diagnósticos");
            System.out.println("32. Eliminar Diagnóstico");
            System.out.println("33. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();  // limpiar buffer

            switch (opcion) {
                // ===================== REGISTRAR =====================
                case 1 -> { // Doctor
                    System.out.print("Nombre del doctor: ");
                    String nombre = sc.nextLine();
                    System.out.print("Especialidad: ");
                    String especialidad = sc.nextLine();
                    System.out.print("Salario: ");
                    double salario = sc.nextDouble();
                    sc.nextLine();
                    hospital.guardarDoctorEnBD(new Doctor(nombre, especialidad, salario), conn);
                }

                case 2 -> { // Paciente
                    System.out.print("Nombre del paciente: ");
                    String nombre = sc.nextLine();
                    System.out.print("Tipo de seguro: ");
                    String seguro = sc.nextLine();
                    System.out.print("Nro. Historia Clínica: ");
                    String historia = sc.nextLine();
                    System.out.print("ID del doctor asignado: ");
                    int idDoctor = sc.nextInt();
                    sc.nextLine();
                    hospital.guardarPacienteEnBD(new Paciente(nombre, seguro, historia, idDoctor), conn);
                }

                case 3 -> { // Cita
                    System.out.print("ID del paciente: ");
                    int idPaciente = sc.nextInt();
                    System.out.print("ID del doctor: ");
                    int idDoctor = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Fecha (YYYY-MM-DD): ");
                    String fecha = sc.nextLine();
                    System.out.print("Hora (HH:MM): ");
                    String hora = sc.nextLine();
                    System.out.print("Motivo: ");
                    String motivo = sc.nextLine();
                    System.out.print("Estado: ");
                    String estado = sc.nextLine();
                    hospital.guardarCitaEnBD(new Cita(idPaciente, idDoctor, fecha, hora, motivo, estado), conn);
                }

                case 4 -> { // Enfermero
                    System.out.print("Nombre del enfermero: ");
                    String nombre = sc.nextLine();
                    System.out.print("Turno: ");
                    String turno = sc.nextLine();
                    System.out.print("Área: ");
                    String area = sc.nextLine();
                    hospital.guardarEnfermeroEnBD(new Enfermero(0, nombre, turno, area), conn);
                }

                case 5 -> { // Medicamento
                    System.out.print("Código: ");
                    String codigo = sc.nextLine();
                    System.out.print("Nombre del medicamento: ");
                    String nombre = sc.nextLine();
                    System.out.print("Cantidad disponible: ");
                    int cantidad = sc.nextInt();
                    System.out.print("Precio unitario: ");
                    float precio = sc.nextFloat();
                    sc.nextLine();
                    hospital.guardarMedicamentoEnBD(new Medicamento(nombre, codigo, cantidad, precio), conn);
                }

                case 6 -> { // Habitación de Emergencia
                    System.out.print("Equipado con oxígeno (true/false): ");
                    boolean oxigeno = sc.nextBoolean();
                    System.out.print("Equipado con monitoreo (true/false): ");
                    boolean monitoreo = sc.nextBoolean();
                    System.out.print("Prioridad de atención (1-10): ");
                    int prioridad = sc.nextInt();
                    sc.nextLine();
                    hospital.guardarHabitacionEnBD(
                            new HabitacionesDeEmergencia(oxigeno, monitoreo, prioridad),
                            conn
                    );
                }

                case 7 -> { // Cirugía
                    System.out.print("Nombre de cirugía: ");
                    String nombreCirugia = sc.nextLine();
                    System.out.print("Ubicación: ");
                    String ubicacion = sc.nextLine();
                    System.out.print("Quirófanos disponibles: ");
                    int quirafanos = sc.nextInt();
                    sc.nextLine();
                    hospital.guardarCirugiaEnBD(new Cirugia(nombreCirugia, ubicacion, quirafanos), conn);
                }

                case 8 -> { // Historial Médico
                    System.out.print("ID del paciente: ");
                    int idPaciente = sc.nextInt();
                    sc.nextLine();
                    Paciente paciente = new Paciente("", "", "", idPaciente); // placeholder compatible
                    hospital.guardarHistorialEnBD(new HistorialMedico(paciente), conn);
                }

                case 9 -> { // Receta
                    System.out.print("ID del paciente: ");
                    int idPaciente = sc.nextInt();
                    System.out.print("ID del doctor: ");
                    int idDoctor = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Indicaciones generales: ");
                    String indicaciones = sc.nextLine();
                    Paciente paciente = new Paciente("", "", "", idPaciente);
                    Doctor doctor = new Doctor("", "", idDoctor);
                    hospital.guardarRecetaEnBD(new Receta(paciente, doctor, indicaciones), conn);
                }

                // ===================== LISTAR =====================
                case 10 -> hospital.listarDoctoresSQL(conn);
                case 11 -> hospital.listarPacientesSQL(conn);
                case 12 -> hospital.listarCitasSQL(conn);
                case 13 -> hospital.listarEnfermerosSQL(conn);
                case 14 -> hospital.listarMedicamentosSQL(conn);
                case 15 -> hospital.listarHabitacionesSQL(conn);
                case 16 -> hospital.listarCirugiasSQL(conn);
                case 17 -> hospital.listarHistorialesSQL(conn);
                case 18 -> hospital.listarRecetasSQL(conn);

                // ===================== ELIMINAR =====================
                case 19 -> {
                    System.out.print("ID del doctor a eliminar: ");
                    int idDoctor = sc.nextInt();
                    sc.nextLine();
                    hospital.eliminarDoctorSQL(idDoctor, conn);
                }

                case 20 -> {
                    System.out.print("ID del paciente a eliminar: ");
                    int idPaciente = sc.nextInt();
                    sc.nextLine();
                    hospital.eliminarPacienteSQL(idPaciente, conn);
                }

                case 21 -> {
                    System.out.print("ID de la cita a eliminar: ");
                    int idCita = sc.nextInt();
                    sc.nextLine();
                    hospital.eliminarCitaSQL(idCita, conn);
                }

                case 22 -> {
                    System.out.print("ID del enfermero a eliminar: ");
                    int idEnfermero = sc.nextInt();
                    sc.nextLine();
                    hospital.eliminarEnfermeroSQL(idEnfermero, conn);
                }

                case 23 -> {
                    System.out.print("Código del medicamento a eliminar: ");
                    String codigo = sc.nextLine();
                    hospital.eliminarMedicamentoSQL(codigo, conn);
                }

                // ===================== OPERACIONES =====================
                case 24 -> {
                    System.out.print("ID de la cirugia asociada: ");
                    int idCirugia = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Descripción de la operación: ");
                    String descripcion = sc.nextLine();
                    System.out.print("Estado: ");
                    String estado = sc.nextLine();
                    hospital.guardarOperacionEnBD(new Operacion(idCirugia, descripcion, estado), conn);
                }

                case 25 -> hospital.listarOperacionesSQL(conn);

                case 26 -> {
                    System.out.print("ID de la operación a eliminar: ");
                    int idOperacion = sc.nextInt();
                    sc.nextLine();
                    hospital.eliminarOperacionSQL(idOperacion, conn);
                }

                // ===================== TRATAMIENTOS =====================
                case 27 -> {
                    System.out.print("ID del paciente: ");
                    int idPacienteT = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Descripción del tratamiento: ");
                    String descT = sc.nextLine();
                    System.out.print("Fecha inicio (YYYY-MM-DD): ");
                    String fi = sc.nextLine();
                    System.out.print("Fecha fin (YYYY-MM-DD): ");
                    String ff = sc.nextLine();
                    hospital.guardarTratamientoEnBD(new Tratamiento(idPacienteT, descT, fi, ff), conn);
                }

                case 28 -> hospital.listarTratamientosSQL(conn);

                case 29 -> {
                    System.out.print("ID del tratamiento a eliminar: ");
                    int idTrat = sc.nextInt();
                    sc.nextLine();
                    hospital.eliminarTratamientoSQL(idTrat, conn);
                }

                // ===================== DIAGNOSTICOS =====================
                case 30 -> {
                    System.out.print("ID del paciente: ");
                    int idPacienteD = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Descripción del diagnóstico: ");
                    String descD = sc.nextLine();
                    System.out.print("Gravedad (baja/media/alta): ");
                    String gravedad = sc.nextLine();
                    hospital.guardarDiagnosticoEnBD(new Diagnostico(idPacienteD, descD, gravedad), conn);
                }

                case 31 -> hospital.listarDiagnosticosSQL(conn);

                case 32 -> {
                    System.out.print("ID del diagnóstico a eliminar: ");
                    int idDiag = sc.nextInt();
                    sc.nextLine();
                    hospital.eliminarDiagnosticoSQL(idDiag, conn);
                }

                case 33 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida, intenta nuevamente.");
            }

        } while (opcion != 33);

        sc.close();
        ConexionBD.desconectar();
    }
}
