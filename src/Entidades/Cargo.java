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
public class Cargo {
    private int idCargo;
    private String Nombre;
    private String Descripcion;
    private double Sueldo;

    public Cargo() {
    }

    public Cargo(int idCargo, String Nombre, String Descripcion, double Sueldo) {
        this.idCargo = idCargo;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Sueldo = Sueldo;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public double getSueldo() {
        return Sueldo;
    }

    public void setSueldo(double Sueldo) {
        this.Sueldo = Sueldo;
    }

    public String toString() {
        return this.Nombre;
    }

}
