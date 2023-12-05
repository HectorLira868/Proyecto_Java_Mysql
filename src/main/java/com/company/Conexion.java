package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    //Lo primero creamos una variable en la cual vamos a guardar el estado de conexion a nuestra BD
    private static Connection conexion;

    //Creamos una variable para crear una sola instancia
    private static Conexion instancia;

    //Creamos las variables para poder conectarnos a la BD
    private static final String URL = "jdbc:mysql://localhost:3306/bd_registros";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    //creamos el metodo para conectar a la BD
    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //JOptionPane.showMessageDialog(null, "Conexion Exitosa!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return conexion;
    }

    //Creamos el metodo para crear la conexion
    public void cerrarConexion() throws SQLException{
        try {
            conexion.close();
            //JOptionPane.showMessageDialog(null, "Se desconecto de la BD");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        } finally{
            conexion.close();
        }
    }
    
    //Creamos el patron singleton
    public static Conexion getInstance(){
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }
}
