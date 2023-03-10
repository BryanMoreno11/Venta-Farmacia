/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Datos.Conexion;
import Entidades.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class CargoDAO {

    private static final String Listar = "select*from Cargo";
    private static final String Insertar = "insert into Cargo values(?,?,?,?)";
    private static final String Modificar = "update Cargo set idCargo=?,Nombre=?,Sueldo=?,Descripcion=? where idCargo=?";
    private static final String Eliminar = "delete from Cargo where idCargo=?";

    public List<Cargo> ListarCargo() {
        List<Cargo> Lista = new ArrayList<Cargo>();
        try {
            Conexion con = new Conexion();
            Connection conexion = con.ObtenerConexion();
            Statement st = conexion.createStatement();
            ResultSet res = st.executeQuery(Listar);
            while (res.next()) {
                Cargo ob = new Cargo();
                ob.setIdCargo(res.getInt(1));
                ob.setNombre(res.getString(2));
                ob.setDescripcion(res.getString(3));
                ob.setSueldo(res.getDouble(4));
                Lista.add(ob);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return Lista;
    }

    public DefaultTableModel MostrarTablaCargo(List<Cargo> Lista) {
        String[] Titulos = {"Codigo", "Nombre", "Sueldo", "Descripción"};
        String[] Datos = new String[4];
        DefaultTableModel dt = new DefaultTableModel(null, Titulos);
        for (Cargo oc : Lista) {
            Datos[0] = String.valueOf(oc.getIdCargo());
            Datos[1] = oc.getNombre();
            Datos[2] = String.valueOf(oc.getSueldo());
            Datos[3] = oc.getDescripcion();
            dt.addRow(Datos);
        }
        return dt;
    }

    public boolean InsertarCargo(Cargo oc) {
        boolean opc = false;
        Conexion con = new Conexion();
        try (Connection conexion = con.ObtenerConexion()) {
            PreparedStatement ps = conexion.prepareStatement(Insertar);
            ps.setInt(1, oc.getIdCargo());
            ps.setString(2, oc.getNombre());
            ps.setString(3, oc.getDescripcion());
            ps.setDouble(4, oc.getSueldo());
            int n = ps.executeUpdate();
            if (n != 0) {
                opc = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return opc;
    }

    public boolean ModificarCargo(Cargo oc) {
        boolean opc = false;
        Conexion con = new Conexion();
        try (Connection conexion = con.ObtenerConexion()) {
            PreparedStatement ps = conexion.prepareStatement(Modificar);
            ps.setInt(1, oc.getIdCargo());
            ps.setString(2, oc.getNombre());
            ps.setDouble(3, oc.getSueldo());
            ps.setString(4, oc.getDescripcion());
            ps.setInt(5, oc.getIdCargo());
            int n = ps.executeUpdate();
            if (n != 0) {
                opc = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return opc;
    }
    
    public boolean EliminarCargo(Cargo oc) {
        boolean opc = false;
        Conexion con = new Conexion();
        try (Connection conexion = con.ObtenerConexion()) {
            PreparedStatement ps = conexion.prepareStatement(Eliminar);
            ps.setInt(1, oc.getIdCargo());
            int n = ps.executeUpdate();
            if (n != 0) {
                opc = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return opc;
    }
    
    //Coloca Cargos como String al momento de listar
    public String ColocarCargo(List<Cargo> Cargo, int id) {
        String res="";
        for (int i = 0; i < Cargo.size(); i++) {
            if (Cargo.get(i).getIdCargo() == id) {
                res = Cargo.get(i).getNombre();
            }
        }
        return res;
    }

    //Retorna el Id de cargo buscandolo con un String
    public int ValorCargo(List<Cargo> ListaCargo, String dat) {
        int res = 0;
        for (int i = 0; i < ListaCargo.size(); i++) {
            if (ListaCargo.get(i).getNombre().equals(dat)) {
                res = ListaCargo.get(i).getIdCargo();
            }
        }
        return res;
    }
    
    public int PosicionCargo(List<Cargo> Cargo,int id){
        int res=0;
        for (int i = 0; i < Cargo.size(); i++) {
            if(Cargo.get(i).getIdCargo()==id){
                return i;
            }
        }
        return res;
    }
    
    public int NumeroSerie(){
        int serie=0;
        String sql="select max(idCargo) from Cargo";
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

    public Vector<Cargo> ListarCargoVector() {
        Vector<Cargo> Lista = new Vector<Cargo>();
        Cargo oc = null;
        try {
            Conexion con = new Conexion();
            Connection objConexion = con.ObtenerConexion();
            PreparedStatement ps = objConexion.prepareStatement(Listar);
            ResultSet resultado = ps.executeQuery();//susceptible de sql injection
            oc = new Cargo();
            oc.setIdCargo(0);
            oc.setNombre("<Seleccione Opcion>");
            oc.setDescripcion("Descripcion");
            oc.setSueldo(0);
            Lista.add(oc);
            while (resultado.next()) {
                oc = new Cargo();
                oc.setIdCargo(resultado.getInt(1));
                oc.setNombre(resultado.getString(2));
                oc.setDescripcion(resultado.getString(3));
                oc.setSueldo(resultado.getDouble(4));
                Lista.add(oc);
            }
            resultado.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Lista;
    }
    
    public DefaultComboBoxModel MostrarComboBox() {
        DefaultComboBoxModel dc = new DefaultComboBoxModel(ListarCargoVector());
        return dc;
    }
    

}
