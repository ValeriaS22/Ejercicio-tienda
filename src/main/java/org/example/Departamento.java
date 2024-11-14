package org.example;

import java.util.ArrayList;

public class Departamento {
    private int iddep;
    private String nombredep;
    private Producto producto;


    static ArrayList<Producto> productodata = new ArrayList<>();

    public Departamento(int iddep, String nombredep) {
        this.iddep = iddep;
        this.nombredep = nombredep;
    }

    public int getIddep() {
        return iddep;
    }

    public void setIddep(int iddep) {
        this.iddep = iddep;
    }

    public String getNombredep() {
        return nombredep;
    }

    public void setNombredep(String nombredep) {
        this.nombredep = nombredep;
    }

    public static ArrayList<Producto> getProductodata() {
        return productodata;
    }

    public static void setProductodata(ArrayList<Producto> productodata) {
        Departamento.productodata = productodata;
    }


    // Agregar productos a un departamento

    // recibir la información de esa clase que creamos en el vector

    public void agregarProducto(Producto producto){
        this.producto = producto;
        Departamento.productodata.add(this.producto);
    }

    // eliminar productos de departamentos
    public void eliminarProducto(int id) {
        productodata.removeIf(producto -> producto.getId() == id); // se cambia para optimizar
    }


    // actualizar precio de un producto
    public void actualizarPrecio(int id, double nuevoPrecio) {
        for (Producto producto : Departamento.productodata) {
            if (producto.getId() == id) {
                producto.setPrecio(nuevoPrecio);
                System.out.println("Precio actualizado a: " + nuevoPrecio);
                return;
            }
        }
        System.out.println("Producto con ID " + id + " no encontrado.");
    }

    // Consultar stock de un producto
    public void consultarStock(int id) {
        for (Producto producto : productodata) {
            if (producto.getId() == id) {
                System.out.println("El stock del producto con ID " + id + " es: " + producto.getCantidad());
                return;
            }
        }
        System.out.println("Producto con ID " + id + " no esta disponible, crea el producto.");
    }

    // Consultar productos de un departamento
    public void consultarProductos() {
        if (productodata.isEmpty()) {
            System.out.println("No hay productos en este departamento.");
        } else {
            productodata.forEach(producto -> System.out.println(
                    "ID: " + producto.getId() +
                            ", Nombre: " + producto.getNombre() +
                            ", Precio: " + producto.getPrecio() +
                            ", Stock: " + producto.getCantidad()
            ));
        }
    }
    // Es una forma rápida y eficiente de comprobar si una colección tiene contenido

}
