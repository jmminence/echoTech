package com.example.echotech;

public class Departamento {
    private String nombre;
    private String gerente;

    public Departamento(String nombre, String gerente) {
        this.nombre = nombre;
        this.gerente = gerente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    @Override
    public String toString() {
        return nombre + " - " + gerente;
    }
}