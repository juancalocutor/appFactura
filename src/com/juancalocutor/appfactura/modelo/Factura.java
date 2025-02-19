package com.juancalocutor.appfactura.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {

    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private int indiceItems;
    public static final int MAX_ITEMS = 10;
    public static int ultimoFolio;

    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEMS];
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
    }

    public int getFolio() {
        return folio;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItems() {
        return items;
    }

    public void addItemFactura(ItemFactura itemFactura) {
        if (indiceItems < MAX_ITEMS) {
            this.items[indiceItems++] = itemFactura;
        }

    }

    public double calcularTotal() {
        double total = 0d;
        for (int i = 0; i < indiceItems; i++) {
            total += this.items[i].calcularImporte();
        }
        return total;
    }

    SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");

    public String generarDetalle() {
        StringBuilder sbuild = new StringBuilder("Factura N°: ");
        sbuild.append(folio)
                .append("\nFecha de emisión: ").append(df.format(fecha)).append("\n")
                .append("\nCliente: ")
                .append(this.cliente.getNombreCliente())
                .append("\tCédula N°: ")
                .append(cliente.getCedulaCliente())
                .append("\nDescripcion: ")
                .append(this.descripcion)
                .append("\n")
                .append("\n#\tNombre\t\t$\tCant.\tTotal\n");

        for (int i = 0; i < indiceItems; i++) {
            sbuild.append(this.items[i].toString()).append("\n");
        }

        sbuild.append("\nGran Total: ")
                .append(calcularTotal());

        return sbuild.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }

    

    // *******************************************
}
