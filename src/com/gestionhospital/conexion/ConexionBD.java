package com.gestionhospital.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    public static Connection conectar() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=HospitalPrivadoDB;encrypt=false;";
        String user = "sa";
        String password = "9682141";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println(" Conexión exitosa a SQL Server.");
            return conn;
        } catch (Exception e) {
            System.out.println(" Error en la conexión: " + e.getMessage());
            return null;
        }
    }
}