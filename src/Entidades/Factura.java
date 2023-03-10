/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Daniel
 */
public class Factura {
    private int idVenta;
    private int idFactura;
    private String fecha;
    private String nombre;
    private int idProducto;
    private double total;
    private int Cantidad;

    public Factura() {
    }

    public Factura(int idVenta, int idFactura, String fecha, String nombre, int idProducto, double total, int Cantidad) {
        this.idVenta = idVenta;
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.nombre = nombre;
        this.idProducto = idProducto;
        this.total = total;
        this.Cantidad = Cantidad;
    }


    
  
//    public Factura(int idFactura, String fecha, String nombre, int idProducto, double total) {
//        this.idFactura = idFactura;
//        this.fecha = fecha;
//        this.nombre = nombre;
//        this.idProducto = idProducto;
//        this.total = total;
//    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    
    
    
}
