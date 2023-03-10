/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Datos.Conexion;
import Entidades.Cliente;
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
public class ClienteDAO {
    private static final String Listar = "select*from Cliente";
    private static final String Insertar = "insert into Cliente values(?,?,?,?,?,?,?,?)";
    private static final String Modificar = "update Cliente set idCliente=?,Nombre=?,Apellido=?,Edad=?, Sexo=?,Provincia=?, Ciudad=?, Correo=? where idCliente=?";
    private static final String Eliminar = "delete from Cliente where idCliente=?";
    
    public List<Cliente> ListarCliente() {
        List<Cliente> Lista = new ArrayList<Cliente>();
        try {
            Conexion con = new Conexion();
            Connection conexion = con.ObtenerConexion();
            Statement st = conexion.createStatement();
            ResultSet res = st.executeQuery(Listar);
            while (res.next()) {
                Cliente ob = new Cliente();
                ob.setIdCliente(res.getInt(1));
                ob.setNombre(res.getString(2));
                ob.setApellido(res.getString(3));
                ob.setEdad(res.getInt(4));
                ob.setSexo(res.getString(5));
                ob.setProvincia(res.getString(6));
                ob.setCiudad(res.getString(7));
                ob.setCorreo(res.getString(8));
                Lista.add(ob);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return Lista;
    }
    
    public DefaultTableModel MostrarTablaCliente(List<Cliente> Lista) {
        String[] Titulos = {"Cedula", "Nombre", "Apellidos", "Edad", "Sexo", "Provincia", "Ciudad", "Correo"};
        String[] Datos = new String[8];
        DefaultTableModel dt = new DefaultTableModel(null, Titulos);
        for (Cliente oc : Lista) {
            Datos[0] = "0"+String.valueOf(oc.getIdCliente());
            Datos[1] = oc.getNombre();
            Datos[2] = oc.getApellido();
            Datos[3] = String.valueOf(oc.getEdad());
            Datos[4] = oc.getSexo();
            Datos[5] = oc.getProvincia();
            Datos[6] = oc.getCiudad();
            Datos[7] = oc.getCorreo();
            dt.addRow(Datos);
        }
        return dt;
    }
    
    public int NumeroSerie(){
        int serie=0;
        String sql="select max(idCliente) from Cliente";
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
    
    public Cliente RetornarCliente(List<Cliente> Clientes,int id){
        for (int i = 0; i < Clientes.size(); i++) {
            if(Clientes.get(i).getIdCliente()==id){
                return Clientes.get(i);
            }
        }
        return null;
    }

    public String NombrePorCedula(List<Cliente> Clientes, int ced) {
        for (int i = 0; i < 10; i++) {
            if (Clientes.get(i).getIdCliente() == ced) {
                return Clientes.get(i).getNombre()+" "+Clientes.get(i).getApellido();
            }
        }
        return null;
    }

    public boolean verificarExistencia(List<Cliente> Clientes, int ID) {
        boolean res = false;
        for (int i = 0; i < Clientes.size(); i++) {
            if (Clientes.get(i).getIdCliente() == ID) {
                return res = true;
            }
        }
        return res = false;
    }
    
    

     public boolean InsertarCliente(Cliente oc) {
        boolean opc = false;
        Conexion con = new Conexion();
        try (Connection conexion = con.ObtenerConexion()) {
            PreparedStatement ps = conexion.prepareStatement(Insertar);
            ps.setInt(1, oc.getIdCliente());
            ps.setString(2, oc.getNombre());
            ps.setString(3, oc.getApellido());
            ps.setInt(4, oc.getEdad());
            ps.setString(5, oc.getSexo());
            ps.setString(6, oc.getProvincia());
            ps.setString(7, oc.getCiudad());
            ps.setString(8, oc.getCorreo());
            int n = ps.executeUpdate();
            if (n != 0) {
                opc = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return opc;
    }
     
     public boolean ModificarCliente(Cliente oc,int aux) {
        boolean opc = false;
        Conexion con = new Conexion();
        try (Connection conexion = con.ObtenerConexion()) {
            PreparedStatement ps = conexion.prepareStatement(Modificar);
            ps.setInt(1, oc.getIdCliente());
            ps.setString(2, oc.getNombre());
            ps.setString(3, oc.getApellido());
            ps.setInt(4, oc.getEdad());
            ps.setString(5, oc.getSexo());
            ps.setString(6, oc.getProvincia());
            ps.setString(7, oc.getCiudad());
            ps.setString(8, oc.getCorreo());
            ps.setInt(9, aux);
            int n = ps.executeUpdate();
            if (n != 0) {
                opc = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return opc;
    }
     
     public boolean EliminarCliente(int pos) {
        boolean opc = false;
        Conexion con = new Conexion();
        try (Connection conexion = con.ObtenerConexion()) {
            PreparedStatement ps = conexion.prepareStatement(Eliminar);
            ps.setInt(1, pos);
            int n = ps.executeUpdate();
            if (n != 0) {
                opc = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return opc;
    }

    public Cliente getCliente(List<Cliente> Clientes, String nombre) {
        for (int i = 0; i < Clientes.size(); i++) {
            String nom = Clientes.get(i).getNombre()+" "+Clientes.get(i).getApellido();
            System.out.println("nom = " + nom);
            if (nom.equals(nombre)) {
                return Clientes.get(i);
            }
        }
        return Clientes.get(0);
    }
}
