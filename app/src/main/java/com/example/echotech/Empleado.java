package com.example.echotech;

import java.util.UUID;

public class Empleado {
    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String fechaInicio;
    private double salario;

    public Empleado(String nombre, String direccion, String telefono, String email, String fechaInicio, double salario) {
        this.id = UUID.randomUUID().toString(); // Genera un ID único
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechaInicio = fechaInicio;
        this.salario = salario;
    }

    // Getters y setters

    @Override
    public String toString() {
        return nombre + " - " + email; // Muestra el nombre y el email
    }
    public String getNombre() {
        return nombre;
    }
}