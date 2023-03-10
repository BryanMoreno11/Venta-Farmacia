/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Datos.Conexion;
import Entidades.Cliente;
import Entidades.Factura;
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
public class FacturaDAO {

    private static final String Listar = "select*from Venta";
    private static final String Insertar = "insert into Venta values(?,?,?,?,?,?,?)";
    private static final String Modificar = "update Venta set idVenta=?,Fecha=?,Cliente=?,Total=? where idVenta=?";
    private static final String Eliminar = "delete from Venta where idVenta=?";

    public List<Factura> ListarFactura() {
        List<Factura> Lista = new ArrayList<Factura>();
        try {
            Conexion con = new Conexion();
            Connection conexion = con.ObtenerConexion();
            Statement st = conexion.createStatement();
            ResultSet res = st.executeQuery(Listar);
            while (res.next()) {
                Factura ob = new Factura();
                ob.setIdVenta(res.getInt(1));
                ob.setIdFactura(res.getInt(2));
                ob.setFecha(res.getString(3));
                ob.setNombre(res.getString(4));
                ob.setIdProducto(res.getInt(5));
                ob.setCantidad(res.getInt(6));
                ob.setTotal(res.getDouble(7));
                Lista.add(ob);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return Lista;
    }
    

    public DefaultTableModel MostrarTablaFactura(List<Factura> Lista) {
        String[] Titulos = {"NUM#", "Fecha", "Nombre", "Total"};
        String[] Datos = new String[4];
        DefaultTableModel dt = new DefaultTableModel(null, Titulos);
        for (Factura oc : Lista) {
            Datos[0] = String.valueOf(oc.getIdFactura());
            Datos[1] = oc.getFecha();
            Datos[2] = oc.getNombre();
            Datos[3] = String.valueOf(oc.getTotal());
            dt.addRow(Datos);
        }
        return dt;
    }

    public DefaultTableModel MostrarTablaFacturaPorID(List<Factura> Lista, int ID) {
        ProductoDAO proDAO = new ProductoDAO();
        String strDouble = String.format("%.2f", 1.23456);
        String[] Titulos = {"ID Producto", "Cantidad", "Nombre", "Precio","Total Unitario"};
        String[] Datos = new String[5];
        DefaultTableModel dt = new DefaultTableModel(null, Titulos);
        for (int i = 0; i < Lista.size(); i++) {
            if (Lista.get(i).getIdVenta() == ID) {
                Datos[0] = String.valueOf(Lista.get(i).getIdProducto());
                Datos[1] = String.valueOf(Lista.get(i).getCantidad());
                Datos[2] = proDAO.NombrePorID(proDAO.ListarProducto(), Lista.get(i).getIdProducto());
                Datos[3] = String.valueOf(proDAO.PrecioPorID(proDAO.ListarProducto(), Lista.get(i).getIdProducto()));
                Datos[4] = String.valueOf(Lista.get(i).getTotal());
//                Datos[3] = strDouble.format("%.2f", Lista.get(i).getTotal());
                dt.addRow(Datos);
            }
        }
        return dt;
    }
    
    public String getFecha(List<Factura> Facturas, int ID){
        for (int i = 0; i < 10; i++) {
            if(Facturas.get(i).getIdVenta()==ID){
                return Facturas.get(i).getFecha();
            }
        }
        return Facturas.get(0).getFecha();
    }
    
    public String getNombre(List<Factura> Facturas, int ID) {
        for (int i = 0; i < Facturas.size(); i++) {
            if (Facturas.get(i).getIdVenta() == ID) {
                return Facturas.get(i).getNombre();
            }
        }
        return Facturas.get(0).getNombre();
    }
    
    public boolean existenciaCliente(List<Factura> Facturas,int ID){
        ClienteDAO cliDao = new  ClienteDAO();
        Cliente cli = cliDao.RetornarCliente(cliDao.ListarCliente(), ID);
        String nom = cli.getNombre()+" "+cli.getApellido();
        for (int i = 0; i < Facturas.size(); i++) {
            if(Facturas.get(i).getNombre().equals(nom)){
                return true;
            }
        }
        return false;
    }
    


    
    public boolean InsertarFactura(Factura oc) {
        boolean opc = false;
        Conexion con = new Conexion();
        try (Connection conexion = con.ObtenerConexion()) {
            PreparedStatement ps = conexion.prepareStatement(Insertar);
            ps.setInt(1,oc.getIdVenta());
            ps.setInt(2, oc.getIdFactura());
            ps.setString(3, oc.getFecha());
            ps.setString(4, oc.getNombre());
            ps.setInt(5, oc.getIdProducto());
            ps.setInt(6, oc.getCantidad());
            ps.setDouble(7, oc.getTotal());
            int n = ps.executeUpdate();
            if (n != 0) {
                opc = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return opc;
    }
    
    public int NumeroSerie(){
        int serie=0;
        String sql="select max(idVenta) from Venta";
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
    
    public int IDFacturaEnSerie(){
        int serie=0;
        String sql="select max(idFactura) from Venta";
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

}
