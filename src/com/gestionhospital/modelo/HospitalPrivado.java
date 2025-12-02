package com.gestionhospital.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class HospitalPrivado {

    private String nombre;
    private String direccion;
    private String telefono;

    public HospitalPrivado(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // ===================== GUARDAR DOCTOR ==========================
    public void guardarDoctorEnBD(Doctor d, Connection conn) {
        try {
            String sql = "INSERT INTO Doctor (nombre, especialidad, salario) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getNombre());
            ps.setString(2, d.getEspecialidad());
            ps.setDouble(3, d.getSalario());
            ps.execute();
            System.out.println(" Doctor registrado correctamente.");
        } catch (Exception e) {
            System.out.println(" Error al registrar doctor: " + e.getMessage());
        }
    }

    // ===================== GUARDAR PACIENTE ==========================
    public void guardarPacienteEnBD(Paciente p, Connection conn) {
        try {
            String sql = "INSERT INTO Paciente (nombre, tipoSeguro, nroHistoriaClinica, idDoctor) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTipoSeguro());
            ps.setString(3, p.getNroHistoriaClinica());
            ps.setInt(4, p.getIdDoctor());
            ps.execute();
            System.out.println(" Paciente registrado correctamente.");
        } catch (Exception e) {
            System.out.println(" Error al registrar paciente: " + e.getMessage());
        }
    }

    // ===================== GUARDAR CITA ==========================
    public void guardarCitaEnBD(Cita c, Connection conn) {
        try {
            String sql = "INSERT INTO Cita (idPaciente, idDoctor, fecha, hora, motivo, estado) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, c.getIdPaciente());
            ps.setInt(2, c.getIdDoctor());
            ps.setString(3, c.getFecha());
            ps.setString(4, c.getHora());
            ps.setString(5, c.getMotivo());
            ps.setString(6, c.getEstado());
            ps.execute();
            System.out.println(" Cita registrada correctamente.");
        } catch (Exception e) {
            System.out.println(" Error al registrar cita: " + e.getMessage());
        }
    }

    // ===================== LISTAR DOCTORES (SIN REPETIDOS) ==========================
    public void listarDoctoresSQL(Connection conn) {
        try {
            // DISTINCT evita duplicados en nombre + especialidad + salario
            String sql = "SELECT DISTINCT nombre, especialidad, salario FROM Doctor ORDER BY nombre";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\n=== LISTA DE DOCTORES ===");

            int n = 1;
            while (rs.next()) {
                System.out.println(
                        n + ". " +
                                "Nombre: " + rs.getString("nombre") +
                                " | Especialidad: " + rs.getString("especialidad") +
                                " | Salario: " + rs.getDouble("salario")
                );
                n++;
            }

        } catch (Exception e) {
            System.out.println("Error al listar doctores: " + e.getMessage());
        }
    }

    // ===================== LISTAR PACIENTES (SIN REPETIDOS) ==========================
    public void listarPacientesSQL(Connection conn) {
        try {
            String sql = """
                    SELECT DISTINCT nombre, tipoSeguro, nroHistoriaClinica, idDoctor
                    FROM Paciente ORDER BY nombre
                    """;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\n=== LISTA DE PACIENTES ===");

            int n = 1;
            while (rs.next()) {
                System.out.println(
                        n + ". " +
                                "Nombre: " + rs.getString("nombre") +
                                " | Seguro: " + rs.getString("tipoSeguro") +
                                " | Historia: " + rs.getString("nroHistoriaClinica") +
                                " | Doctor Asignado: " + rs.getInt("idDoctor")
                );
                n++;
            }

        } catch (Exception e) {
            System.out.println("Error al listar pacientes: " + e.getMessage());
        }
    }

    // ===================== LISTAR CITAS (SIN REPETIDOS) ==========================
    public void listarCitasSQL(Connection conn) {
        try {
            String sql = """
                    SELECT DISTINCT idPaciente, idDoctor, fecha, hora, motivo, estado
                    FROM Cita ORDER BY fecha, hora
                    """;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\n=== LISTA DE CITAS ===");

            int n = 1;
            while (rs.next()) {
                System.out.println(
                        n + ". " +
                                "Paciente: " + rs.getInt("idPaciente") +
                                " | Doctor: " + rs.getInt("idDoctor") +
                                " | Fecha: " + rs.getString("fecha") +
                                " | Hora: " + rs.getString("hora") +
                                " | Motivo: " + rs.getString("motivo") +
                                " | Estado: " + rs.getString("estado")
                );
                n++;
            }

        } catch (Exception e) {
            System.out.println("Error al listar citas: " + e.getMessage());
        }
    }
}