package org.example;

import java.util.ArrayList;

public class Tienda {
    private String nombretienda;
    private Departamento departamento;
    static ArrayList<Departamento> departamentodata = new ArrayList<>();

    public Tienda(String nombretienda) {
        this.nombretienda = nombretienda;
    }

    public String getNombretienda() {
        return nombretienda;
    }

    public void setNombretienda(String nombretienda) {
        this.nombretienda = nombretienda;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public static ArrayList<Departamento> getDepartamentodata() {
        return departamentodata;
    }

    public static void setDepartamentodata(ArrayList<Departamento> departamentodata) {
        Tienda.departamentodata = departamentodata;
    }

    // Consultar departamentos de la tienda
    public void consultarDepartamentos() {
        ArrayList<Departamento> departamentos = Tienda.getDepartamentodata();

        if (departamentos.isEmpty()) {
            System.out.println("No hay departamentos en la tienda.");
        } else {
            System.out.println("Departamentos en la tienda:");
            departamentos.forEach(departamento -> System.out.println(
                    "ID: " + departamento.getIddep() +
                            ", Nombre: " + departamento.getNombredep()
            ));
        }
    }
    // Es una forma rápida y eficiente de comprobar si una colección tiene contenido
}
