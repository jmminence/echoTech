package com.example.echotech;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager instance;
    private List<Empleado> listaEmpleados;
    private List<Departamento> listaDepartamentos;
    private List<String> listaAsignaciones;
    private List<String> listaRegistrosTiempo;
    private List<String> listaProyectos;

    private DataManager() {
        listaEmpleados = new ArrayList<>();
        listaDepartamentos = new ArrayList<>();
        listaAsignaciones = new ArrayList<>();
        listaRegistrosTiempo = new ArrayList<>();
        listaProyectos = new ArrayList<>();
    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public List<Departamento> getListaDepartamentos() {
        return listaDepartamentos;
    }

    public List<String> getListaAsignaciones() {
        return listaAsignaciones;
    }

    public List<String> getListaRegistrosTiempo() {
        return listaRegistrosTiempo;
    }

    public List<String> getListaProyectos() {
        return listaProyectos;
    }
}