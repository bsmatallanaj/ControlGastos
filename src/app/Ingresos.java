/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Date;

/**
 *
 * @author BRAYAN
 */
public class Ingresos {
    
    public float valor;
    public String descripcion;
    public Date fecha;

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Ingresos(float valor, String descripcion, Date fecha) {
        this.valor = valor;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }
    
}
