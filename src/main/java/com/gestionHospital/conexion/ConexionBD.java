package com.gestionHospital.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionBD {
    public static void main(String[] args) {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=HospitalPrivadoDB;encrypt=false;";
        String user = "sa";
        String password = "9682141";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println(" Conexión exitosa a la base de datos.");

            // Consulta a la tabla Doctor
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT TOP 5 * FROM Doctor");

            System.out.println(" Lista de Doctores:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("idDoctor") +
                        " | Nombre: " + rs.getString("nombre") +
                        " | Especialidad: " + rs.getString("especialidad") +
                        " | Salario: " + rs.getDouble("salario"));
            }

        } catch (Exception e) {
            System.out.println(" Error al conectar o consultar: " + e.getMessage());
        }
    }
}