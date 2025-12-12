package com.gestionhospital.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalPrivado {

    private String nombre;
    private String direccion;
    private String telefono;

    public HospitalPrivado(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // ===================== DOCTOR ==========================
    public void guardarDoctorEnBD(Doctor d, Connection conn) {
        try {
            String sql = "INSERT INTO Doctor (nombre, especialidad, salario) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getNombre());
            ps.setString(2, d.getEspecialidad());
            ps.setDouble(3, d.getSalario());
            ps.execute();
            System.out.println("Doctor registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar doctor: " + e.getMessage());
        }
    }

    public void listarDoctoresSQL(Connection conn) {
        try {
            String sql = "SELECT idDoctor, nombre, especialidad, salario FROM Doctor";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("\n=== LISTA DE DOCTORES ===");
            while (rs.next()) {
                System.out.println(rs.getInt("idDoctor") + ". " +
                        rs.getString("nombre") + " | " +
                        rs.getString("especialidad") + " | " +
                        rs.getDouble("salario"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar doctores: " + e.getMessage());
        }
    }

    public void eliminarDoctorSQL(int idDoctor, Connection conn) {
        try {
            String sql = "DELETE FROM Doctor WHERE idDoctor = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idDoctor);
            ps.execute();
            System.out.println("Doctor eliminado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar doctor: " + e.getMessage());
        }
    }

    // ===================== PACIENTE ==========================
    public void guardarPacienteEnBD(Paciente p, Connection conn) {
        try {
            String sql = "INSERT INTO Paciente (nombre, tipoSeguro, nroHistoriaClinica, idDoctor) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTipoSeguro());
            ps.setString(3, p.getNroHistoriaClinica());
            ps.setInt(4, p.getIdDoctor());
            ps.execute();
            System.out.println("Paciente registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar paciente: " + e.getMessage());
        }
    }

    public void listarPacientesSQL(Connection conn) {
        try {
            String sql = "SELECT idPaciente, nombre, tipoSeguro, nroHistoriaClinica, idDoctor FROM Paciente";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("\n=== LISTA DE PACIENTES ===");
            while (rs.next()) {
                System.out.println(rs.getInt("idPaciente") + ". " +
                        rs.getString("nombre") + " | " +
                        rs.getString("tipoSeguro") + " | " +
                        rs.getString("nroHistoriaClinica") + " | Doctor ID: " +
                        rs.getInt("idDoctor"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar pacientes: " + e.getMessage());
        }
    }

    public void eliminarPacienteSQL(int idPaciente, Connection conn) {
        try {
            String sql = "DELETE FROM Paciente WHERE idPaciente = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            ps.execute();
            System.out.println("Paciente eliminado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar paciente: " + e.getMessage());
        }
    }

    // ===================== CITA ==========================
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
            System.out.println("Cita registrada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar cita: " + e.getMessage());
        }
    }

    public void listarCitasSQL(Connection conn) {
        try {
            String sql = "SELECT idCita, idPaciente, idDoctor, fecha, hora, motivo, estado FROM Cita";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("\n=== LISTA DE CITAS ===");
            while (rs.next()) {
                System.out.println(rs.getInt("idCita") + ". Paciente ID: " +
                        rs.getInt("idPaciente") + " | Doctor ID: " +
                        rs.getInt("idDoctor") + " | Fecha: " +
                        rs.getString("fecha") + " | Hora: " +
                        rs.getString("hora") + " | Motivo: " +
                        rs.getString("motivo") + " | Estado: " +
                        rs.getString("estado"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar citas: " + e.getMessage());
        }
    }

    public void eliminarCitaSQL(int idCita, Connection conn) {
        try {
            String sql = "DELETE FROM Cita WHERE idCita = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idCita);
            ps.execute();
            System.out.println("Cita eliminada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar cita: " + e.getMessage());
        }
    }

    // ===================== ENFERMERO ==========================
    public void guardarEnfermeroEnBD(Enfermero e, Connection conn) {
        try {
            String sql = "INSERT INTO Enfermero (nombre, turno, area) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getTurno());
            ps.setString(3, e.getArea());
            ps.execute();
            System.out.println("Enfermero registrado correctamente.");
        } catch (Exception ex) {
            System.out.println("Error al registrar enfermero: " + ex.getMessage());
        }
    }

    public void listarEnfermerosSQL(Connection conn) {
        try {
            String sql = "SELECT idEnfermero, nombre, turno, area FROM Enfermero";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("\n=== LISTA DE ENFERMEROS ===");
            while (rs.next()) {
                System.out.println(rs.getInt("idEnfermero") + ". " +
                        rs.getString("nombre") + " | Turno: " +
                        rs.getString("turno") + " | Área: " +
                        rs.getString("area"));
            }
        } catch (Exception ex) {
            System.out.println("Error al listar enfermeros: " + ex.getMessage());
        }
    }

    public void eliminarEnfermeroSQL(int idEnfermero, Connection conn) {
        try {
            String sql = "DELETE FROM Enfermero WHERE idEnfermero = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idEnfermero);
            ps.execute();
            System.out.println("Enfermero eliminado correctamente.");
        } catch (Exception ex) {
            System.out.println("Error al eliminar enfermero: " + ex.getMessage());
        }
    }

    // ===================== MEDICAMENTO ==========================
    public void guardarMedicamentoEnBD(Medicamento m, Connection conn) {
        try {
            String sql = "INSERT INTO Medicamento (codigo, nombre, cantidadDisponible, precioUnitario) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, m.getCodigo());
            ps.setString(2, m.getNombre());
            ps.setInt(3, m.getCantidadDisponible());
            ps.setFloat(4, m.getPrecioUnitario());
            ps.execute();
            System.out.println("Medicamento registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar medicamento: " + e.getMessage());
        }
    }

    public void listarMedicamentosSQL(Connection conn) {
        try {
            String sql = "SELECT codigo, nombre, cantidadDisponible, precioUnitario FROM Medicamento";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("\n=== LISTA DE MEDICAMENTOS ===");
            while (rs.next()) {
                System.out.println(rs.getString("codigo") + ". " +
                        rs.getString("nombre") + " | Cantidad: " +
                        rs.getInt("cantidadDisponible") + " | Precio: " +
                        rs.getFloat("precioUnitario"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar medicamentos: " + e.getMessage());
        }
    }

    public void eliminarMedicamentoSQL(String codigo, Connection conn) {
        try {
            String sql = "DELETE FROM Medicamento WHERE codigo = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.execute();
            System.out.println("Medicamento eliminado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar medicamento: " + e.getMessage());
        }
    }

    // ===================== HABITACIONES ==========================
    public void guardarHabitacionEnBD(HabitacionesDeEmergencia h, Connection conn) {
        try {
            String sql = "INSERT INTO HabitacionesDeEmergencia (prioridadAtencion, equipamiento, ocupado, pacienteAsignado) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            String equipamiento = "";
            if(h.isEquipadoConMonitoreo()) equipamiento += "Monitoreo;";
            if(h.isEquipadoConOxigeno()) equipamiento += "Oxigeno;";
            ps.setInt(1, h.getPrioridadAtencion());
            ps.setString(2, equipamiento);
            ps.setBoolean(3, h.isOcupado());
            ps.setObject(4, null);
            ps.execute();
            System.out.println("Habitación de emergencia registrada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar habitación: " + e.getMessage());
        }
    }

    public void listarHabitacionesSQL(Connection conn) {
        try {
            String sql = "SELECT idHabitacion, prioridadAtencion, equipamiento, ocupado FROM HabitacionesDeEmergencia";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("\n=== LISTA DE HABITACIONES ===");
            while (rs.next()) {
                System.out.println(rs.getInt("idHabitacion") + ". Prioridad: " +
                        rs.getInt("prioridadAtencion") + " | Equipamiento: " +
                        rs.getString("equipamiento") + " | Ocupado: " +
                        rs.getBoolean("ocupado"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar habitaciones: " + e.getMessage());
        }
    }

    public void eliminarHabitacionSQL(int idHabitacion, Connection conn) {
        try {
            String sql = "DELETE FROM HabitacionesDeEmergencia WHERE idHabitacion = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idHabitacion);
            ps.execute();
            System.out.println("Habitación eliminada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar habitación: " + e.getMessage());
        }
    }

    // ===================== CIRUGÍAS ==========================
    public void guardarCirugiaEnBD(Cirugia c, Connection conn) {
        try {
            String sql = "INSERT INTO Cirugia (tipo, ubicacion, quirafanosDisponibles, fechaProgramada) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getUbicacion());
            ps.setInt(3, c.getQuirafanosDisponibles());
            ps.setString(4, c.getFechaProgramada());
            ps.execute();
            System.out.println("Cirugía registrada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar cirugía: " + e.getMessage());
        }
    }

    public void listarCirugiasSQL(Connection conn) {
        try {
            String sql = "SELECT id, tipo, ubicacion, quirafanosDisponibles, fechaProgramada FROM Cirugia";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("\n=== LISTA DE CIRUGÍAS ===");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". Tipo: " +
                        rs.getString("tipo") + " | Ubicación: " +
                        rs.getString("ubicacion") + " | Quirófanos: " +
                        rs.getInt("quirafanosDisponibles") + " | Fecha: " +
                        rs.getString("fechaProgramada"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar cirugías: " + e.getMessage());
        }
    }

    public void eliminarCirugiaSQL(int id, Connection conn) {
        try {
            String sql = "DELETE FROM Cirugia WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Cirugía eliminada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar cirugía: " + e.getMessage());
        }
    }

    // ===================== HISTORIALES ==========================
    public void guardarHistorialEnBD(HistorialMedico h, Connection conn) {
        try {
            String sql = "INSERT INTO HistorialMedico (idPaciente) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, h.getPaciente().getIdPaciente());
            ps.execute();
            System.out.println("Historial médico registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar historial médico: " + e.getMessage());
        }
    }

    public void listarHistorialesSQL(Connection conn) {
        try {
            String sql = "SELECT idHistorial, idPaciente FROM HistorialMedico";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("\n=== LISTA DE HISTORIALES MÉDICOS ===");
            while (rs.next()) {
                System.out.println(rs.getInt("idHistorial") + ". Paciente ID: " +
                        rs.getInt("idPaciente"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar historiales: " + e.getMessage());
        }
    }

    public void eliminarHistorialSQL(int idHistorial, Connection conn) {
        try {
            String sql = "DELETE FROM HistorialMedico WHERE idHistorial = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idHistorial);
            ps.execute();
            System.out.println("Historial eliminado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar historial: " + e.getMessage());
        }
    }

    // ===================== RECETAS ==========================
    public void guardarRecetaEnBD(Receta r, Connection conn) {
        try {
            String sql = "INSERT INTO Receta (idPaciente, idDoctor, indicacionesGenerales) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, r.getPaciente().getIdPaciente());
            ps.setInt(2, r.getDoctor().getIdDoctor());
            ps.setString(3, r.getIndicacionesGenerales());
            ps.execute();
            System.out.println("Receta registrada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar receta: " + e.getMessage());
        }
    }

    public void listarRecetasSQL(Connection conn) {
        try {
            String sql = "SELECT idReceta, idPaciente, idDoctor, indicacionesGenerales FROM Receta";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("\n=== LISTA DE RECETAS ===");
            while (rs.next()) {
                System.out.println(rs.getInt("idReceta") + ". Paciente ID: " +
                        rs.getInt("idPaciente") + " | Doctor ID: " +
                        rs.getInt("idDoctor") + " | Indicaciones: " +
                        rs.getString("indicacionesGenerales"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar recetas: " + e.getMessage());
        }
    }

    public void eliminarRecetaSQL(int idReceta, Connection conn) {
        try {
            String sql = "DELETE FROM Receta WHERE idReceta = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idReceta);
            ps.execute();
            System.out.println("Receta eliminada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar receta: " + e.getMessage());
        }
    }

    // ===================== OPERACIONES ==========================
    public void guardarOperacionEnBD(Operacion o, Connection conn) {
        try {
            String sql = "INSERT INTO Operacion (idCirugia, descripcion, estado) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, o.getIdCirugia());
            ps.setString(2, o.getDescripcion());
            ps.setString(3, o.getEstado());
            ps.execute();
            System.out.println("Operación registrada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar operación: " + e.getMessage());
        }
    }

    public void listarOperacionesSQL(Connection conn) {
        try {
            String sql = "SELECT idOperacion, idCirugia, descripcion, estado FROM Operacion";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("\n=== LISTA DE OPERACIONES ===");
            while (rs.next()) {
                System.out.println(rs.getInt("idOperacion") + ". Cirugía ID: " +
                        rs.getInt("idCirugia") + " | " + rs.getString("descripcion") +
                        " | Estado: " + rs.getString("estado"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar operaciones: " + e.getMessage());
        }
    }

    public void eliminarOperacionSQL(int idOperacion, Connection conn) {
        try {
            String sql = "DELETE FROM Operacion WHERE idOperacion = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idOperacion);
            ps.execute();
            System.out.println("Operación eliminada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar operación: " + e.getMessage());
        }
    }

    // ===================== TRATAMIENTOS ==========================
    public void guardarTratamientoEnBD(Tratamiento t, Connection conn) {
        try {
            String sql = "INSERT INTO Tratamiento (idPaciente, descripcion, fechaInicio, fechaFin) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, t.getIdPaciente());
            ps.setString(2, t.getDescripcion());
            ps.setString(3, t.getFechaInicio());
            ps.setString(4, t.getFechaFin());
            ps.execute();
            System.out.println("Tratamiento registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar tratamiento: " + e.getMessage());
        }
    }

    public void listarTratamientosSQL(Connection conn) {
        try {
            String sql = "SELECT idTratamiento, idPaciente, descripcion, fechaInicio, fechaFin FROM Tratamiento";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("\n=== LISTA DE TRATAMIENTOS ===");
            while (rs.next()) {
                System.out.println(rs.getInt("idTratamiento") + ". Paciente ID: " +
                        rs.getInt("idPaciente") + " | " + rs.getString("descripcion") +
                        " | " + rs.getString("fechaInicio") + " - " + rs.getString("fechaFin"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar tratamientos: " + e.getMessage());
        }
    }

    public void eliminarTratamientoSQL(int idTratamiento, Connection conn) {
        try {
            String sql = "DELETE FROM Tratamiento WHERE idTratamiento = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idTratamiento);
            ps.execute();
            System.out.println("Tratamiento eliminado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar tratamiento: " + e.getMessage());
        }
    }

    // ===================== DIAGNOSTICOS ==========================
    public void guardarDiagnosticoEnBD(Diagnostico d, Connection conn) {
        try {
            String sql = "INSERT INTO Diagnostico (idPaciente, descripcion, gravedad) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, d.getIdPaciente());
            ps.setString(2, d.getDescripcion());
            ps.setString(3, d.getGravedad());
            ps.execute();
            System.out.println("Diagnóstico registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar diagnóstico: " + e.getMessage());
        }
    }

    public void listarDiagnosticosSQL(Connection conn) {
        try {
            String sql = "SELECT idDiagnostico, idPaciente, descripcion, gravedad FROM Diagnostico";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("\n=== LISTA DE DIAGNÓSTICOS ===");
            while (rs.next()) {
                System.out.println(rs.getInt("idDiagnostico") + ". Paciente ID: " +
                        rs.getInt("idPaciente") + " | " + rs.getString("descripcion") +
                        " | Gravedad: " + rs.getString("gravedad"));
            }
        } catch (Exception e) {
            System.out.println("Error al listar diagnósticos: " + e.getMessage());
        }
    }

    public void eliminarDiagnosticoSQL(int idDiagnostico, Connection conn) {
        try {
            String sql = "DELETE FROM Diagnostico WHERE idDiagnostico = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idDiagnostico);
            ps.execute();
            System.out.println("Diagnóstico eliminado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar diagnóstico: " + e.getMessage());
        }
    }
}