/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author BRAYAN
 */
public abstract class Dinero  {
    
    public double saldo, gasto, ingreso;
    public String descripcion, descripcionGasto, descripcionIngreso, fecha;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getGasto() {
        return gasto;
    }

    public void setGasto(double gasto) {
        this.gasto = gasto;
    }

    public double getIngreso() {
        return ingreso;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcionGasto() {
        return descripcionGasto;
    }

    public void setDescripcionGasto(String descripcionGasto) {
        this.descripcionGasto = descripcionGasto;
    }

    public String getDescripcionIngreso() {
        return descripcionIngreso;
    }

    public void setDescripcionIngreso(String descripcionIngreso) {
        this.descripcionIngreso = descripcionIngreso;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Dinero(double saldo, double gasto, double ingreso, String descripcion, String descripcionGasto, String descripcionIngreso, String fecha) {
        this.saldo = saldo;
        this.gasto = gasto;
        this.ingreso = ingreso;
        this.descripcion = descripcion;
        this.descripcionGasto = descripcionGasto;
        this.descripcionIngreso = descripcionIngreso;
        this.fecha = fecha;
    }
    

    
    
}
