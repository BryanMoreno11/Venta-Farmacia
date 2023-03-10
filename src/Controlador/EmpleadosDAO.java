/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Datos.Conexion;
import Entidades.Empleados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class EmpleadosDAO {
    private static final String Listar = "select*from Empleados";
    private static final String Insertar = "insert into Empleados values(?,?,?,?,?,?,?,?)";
    private static final String Modificar = "update Empleados set idEmpleados=?,Nombre=?,Apellidos=?,Edad=?, Sexo=?,Provincia=?, Ciudad=?, Cargo_idCargo=? where idEmpleados=?";
    private static final String Eliminar = "delete from Empleados where idEmpleados=?";

    public List<Empleados> ListarEmpleados() {
        List<Empleados> Lista = new ArrayList<Empleados>();
        try {
            Conexion con = new Conexion();
            Connection conexion = con.ObtenerConexion();
            Statement st = conexion.createStatement();
            ResultSet res = st.executeQuery(Listar);
            while (res.next()) {
                Empleados ob = new Empleados();
                ob.setIdEmpleados(res.getInt(1));
                ob.setNombre(res.getString(2));
                ob.setApellido(res.getString(3));
                ob.setEdad(res.getInt(4));
                ob.setSexo(res.getString(5));
                ob.setProvincia(res.getString(6));
                ob.setCiudad(res.getString(7));
                ob.setId_Cargo(res.getInt(8));
                Lista.add(ob);
            }
        } catch (SQLException ex) {
            System.out.println("Good morning TV");
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return Lista;
    }
    //Variables globales
    CargoDAO CargoDao = new CargoDAO();

    public DefaultTableModel MostrarTablaEmpleados(List<Empleados> Lista) {
        String[] Titulos = {"ID", "Nombre", "Apellidos", "Edad", "Sexo", "Provincia", "Ciudad", "Cargo"};
        String[] Datos = new String[8];
        DefaultTableModel dt = new DefaultTableModel(null, Titulos);
        for (Empleados oc : Lista) {
            Datos[0] = String.valueOf(oc.getIdEmpleados());
            Datos[1] = oc.getNombre();
            Datos[2] = oc.getApellido();
            Datos[3] = String.valueOf(oc.getEdad());
            Datos[4] = oc.getSexo();
            Datos[5] = oc.getProvincia();
            Datos[6] = oc.getCiudad();
            Datos[7] = (CargoDao.ColocarCargo(CargoDao.ListarCargo(), oc.getId_Cargo()));
            dt.addRow(Datos);
        }
        return dt;
    }

    public int NumeroSerie(){
        int serie=0;
        String sql="select max(idEmpleados) from Empleados";
        try{
            Conexion con = new Conexion();
            Connection conexion = con.ObtenerConexion();
            Statement st = conexion.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                serie = res.getInt(1);
            }
        }
        catch(Exception ex){            
        }
        return serie;
    }
    
    public boolean InsertarEmpleados(Empleados oc) {
        boolean opc = false;
        Conexion con = new Conexion();
        try (Connection conexion = con.ObtenerConexion()) {
            PreparedStatement ps = conexion.prepareStatement(Insertar);
            ps.setInt(1, oc.getIdEmpleados());
            ps.setString(2, oc.getNombre());
            ps.setString(3, oc.getApellido());
            ps.setInt(4, oc.getEdad());
            ps.setString(5, oc.getSexo());
            ps.setString(6, oc.getProvincia());
            ps.setString(7, oc.getCiudad());
            ps.setInt(8, oc.getId_Cargo());
            int n = ps.executeUpdate();
            if (n != 0) {
                opc = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return opc;
    }

    public boolean ModificarEmpleados(Empleados oc) {
        boolean opc = false;
        Conexion con = new Conexion();
        try (Connection conexion = con.ObtenerConexion()) {
            PreparedStatement ps = conexion.prepareStatement(Modificar);
            ps.setInt(1, oc.getIdEmpleados());
            ps.setString(2, oc.getNombre());
            ps.setString(3, oc.getApellido());
            ps.setInt(4, oc.getEdad());
            ps.setString(5, oc.getSexo());
            ps.setString(6, oc.getProvincia());
            ps.setString(7, oc.getCiudad());
            ps.setInt(8, oc.getId_Cargo());
            ps.setInt(9, oc.getIdEmpleados());
            int n = ps.executeUpdate();
            if (n != 0) {
                opc = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return opc;
    }
    
    public boolean EliminarEmpleado(int oc) {
        boolean opc = false;
        Conexion con = new Conexion();
        try (Connection conexion = con.ObtenerConexion()) {
            PreparedStatement ps = conexion.prepareStatement(Eliminar);
            ps.setInt(1, oc);
            int n = ps.executeUpdate();
            if (n != 0) {
                opc = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return opc;
    }
}
