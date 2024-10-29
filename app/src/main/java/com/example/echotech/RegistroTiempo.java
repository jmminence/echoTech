package com.example.echotech;

public class RegistroTiempo {
    private int horas;
    private String descripcion;

    public RegistroTiempo(int horas, String descripcion) {
        this.horas = horas;
        this.descripcion = descripcion;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}