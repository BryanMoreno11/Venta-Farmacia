/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
//import com.mysql.jdbc.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class Conexion {

    private static Connection conexion = null;
    private static String user = "root";
    private static String password = "gyrobest";
    private static String url = "jdbc:mysql://localhost:3306/farmacia";;

    public Conexion() {

    }

    public Connection ObtenerConexion() {
        try {
            System.out.println("Conexión exitosa");
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return conexion;
    }
}
