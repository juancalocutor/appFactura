package com.juancalocutor.appfactura.modelo;

public class Producto {

    private int codigo;
    private String nombreProducto;
    private double precio;
    private static int ultimoCodigo;
    
    public Producto() {
        this.codigo = ++ultimoCodigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return codigo + "\t" + nombreProducto + "\t" + precio;
    }

    

    // ********************************************
}
