/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Datos.Conexion;
import Entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class ProductoDAO {
    private static final String Listar = "select*from Producto";
    private static final String Insertar = "insert into Producto values(?,?,?,?,?)";
    private static final String Modificar = "update Producto set idProducto=?,Nombre=?,Precio=?,Descripcion=?,Stock=? where idProducto=?";
    private static final String Eliminar = "delete from Producto where idProducto=?";
    
    public List<Producto> ListarProducto() {
        List<Producto> Lista = new ArrayList<Producto>();
        try {
            Conexion con = new Conexion();
            Connection conexion = con.ObtenerConexion();
            Statement st = conexion.createStatement();
            ResultSet res = st.executeQuery(Listar);
            while (res.next()) {
                Producto ob = new Producto();
                ob.setIdProducto(res.getInt(1));
                ob.setNombre(res.getString(2));
                ob.setPrecio(res.getDouble(3));
                ob.setDescripcion(res.getString(4));
                ob.setStock(res.getInt(5));
                Lista.add(ob);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return Lista;
    }
    
    public DefaultTableModel MostrarTablaProducto(List<Producto> Lista) {
        String[] Titulos = {"Codigo", "Nombre", "Precio", "Descripcion","Stock"};
        String[] Datos = new String[5];
        DefaultTableModel dt = new DefaultTableModel(null, Titulos);
        for (Producto oc : Lista) {
            Datos[0] = String.valueOf(oc.getIdProducto());
            Datos[1] = oc.getNombre();
            Datos[2] = String.valueOf(oc.getPrecio());
            Datos[3] = oc.getDescripcion();
            Datos[4] = String.valueOf(oc.getStock());
            dt.addRow(Datos);
        }
        return dt;
    }
    
    public int NumeroSerie(){
        int serie=0;
        String sql="select max(idProducto) from Producto";
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
 
    public Producto getProducto(List<Producto> Lista, int id, int can) {
        for (int i = 0; i < Lista.size(); i++) {
            if (Lista.get(i).getIdProducto() == id) {
                Lista.get(i).setUnidades(can);
                Lista.get(i).setTotal(Lista.get(i).getUnidades()*Lista.get(i).getPrecio());
                return Lista.get(i);
            }
        }
        return null;
    }

    public DefaultTableModel ProductosInsertados(List<Producto> Lista) {
        String[] Titulos = {"Codigo", "Nombre", "Precio", "Descripcion", "Unidades", "Total"};
        DecimalFormat df = new DecimalFormat("##.00");
        String[] Datos = new String[6];
        DefaultTableModel dt = new DefaultTableModel(null, Titulos);
        for (Producto oc : Lista) {
            Datos[0] = String.valueOf(oc.getIdProducto());
            Datos[1] = oc.getNombre();
            Datos[2] = String.valueOf(oc.getPrecio());
            Datos[3] = oc.getDescripcion();
            Datos[4] = String.valueOf(oc.getUnidades());
            Datos[5] = df.format(oc.getPrecio() * oc.getUnidades());
            dt.addRow(Datos);
        }
        return dt;
    }

    public void ActualizarStock(List<Producto> Lista, List<Producto> Lista2) {
        Conexion con = new Conexion();
        boolean opc = false;
        String sql = "update Producto set Stock=? where idProducto=?";
        for (int i = 0; i < Lista2.size(); i++) {
            for (int j = 0; j < Lista.size(); j++) {
                if (Lista.get(j).getNombre().equals(Lista2.get(i).getNombre())) {
                    int newStock = Lista.get(j).getStock() - Lista2.get(i).getUnidades();
                    System.out.println("newStock = " + newStock);
                    try (Connection conexion = con.ObtenerConexion()) {
                        PreparedStatement ps = conexion.prepareStatement(sql);
                        ps.setInt(1, newStock);
                        ps.setInt(2, Lista.get(j).getIdProducto());
                        int n = ps.executeUpdate();
                        if (n != 0) {
                            opc = true;
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        }
    }
    
    public String NombrePorID(List<Producto> Productos, int id) {
        for (int i = 0; i < Productos.size(); i++) {
            if (Productos.get(i).getIdProducto() == id) {
                return Productos.get(i).getNombre();
            }
        }
        return Productos.get(0).getNombre();
    }
    
    public double PrecioPorID(List<Producto> Productos, int id) {
        for (int i = 0; i < Productos.size(); i++) {
            if (Productos.get(i).getIdProducto() == id) {
                return Productos.get(i).getPrecio();
            }
        }
        return Productos.get(0).getPrecio();
    }

    public boolean InsertarProducto(Producto oc) {
        boolean opc = false;
        Conexion con = new Conexion();
        try (Connection conexion = con.ObtenerConexion()) {
            PreparedStatement ps = conexion.prepareStatement(Insertar);
            ps.setInt(1, oc.getIdProducto());
            ps.setString(2, oc.getNombre());
            ps.setDouble(3, oc.getPrecio());
            ps.setString(4, oc.getDescripcion());
            ps.setInt(5, oc.getStock());
            int n = ps.executeUpdate();
            if (n != 0) {
                opc = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return opc;
    }
    
    public boolean ModificarProducto(Producto oc) {
        boolean opc = false;
        Conexion con = new Conexion();
        try (Connection conexion = con.ObtenerConexion()) {
            PreparedStatement ps = conexion.prepareStatement(Modificar);
            ps.setInt(1, oc.getIdProducto());
            ps.setString(2, oc.getNombre());
            ps.setDouble(3, oc.getPrecio());
            ps.setString(4, oc.getDescripcion());
            ps.setInt(5, oc.getStock());
            ps.setInt(6, oc.getIdProducto());
            int n = ps.executeUpdate();
            if (n != 0) {
                opc = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return opc;
    }
    
    public boolean EliminarProducto(int pos) {
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
    
    

}
