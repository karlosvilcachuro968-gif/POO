package com.gestionhospital.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static Connection conn = null;

    // Método para conectar
    public static Connection conectar() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=HospitalPrivadoDB;encrypt=false;";
        String user = "sa";
        String password = "9682141";

        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Conexión exitosa a SQL Server.");
            }
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }

        return conn;
    }

    // Método para desconectar
    public static void desconectar() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    // Método para verificar si está conectado
    public static boolean estaConectado() {
        try {
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
}