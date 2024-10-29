package com.example.echotech;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;

public class AsignacionEmpleadosActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion_empleados);

        Spinner spinnerEmpleados = findViewById(R.id.spinnerEmpleados);
        Spinner spinnerDepartamentos = findViewById(R.id.spinnerDepartamentos);
        Button btnAsignar = findViewById(R.id.btnAsignar);
        ListView listViewAsignaciones = findViewById(R.id.listViewAsignaciones);

        DataManager dataManager = DataManager.getInstance();

        ArrayAdapter<Empleado> adapterEmpleados = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataManager.getListaEmpleados());
        adapterEmpleados.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEmpleados.setAdapter(adapterEmpleados);

        ArrayAdapter<Departamento> adapterDepartamentos = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataManager.getListaDepartamentos());
        adapterDepartamentos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDepartamentos.setAdapter(adapterDepartamentos);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataManager.getListaAsignaciones());
        listViewAsignaciones.setAdapter(adapter);

        btnAsignar.setOnClickListener(v -> {
            Empleado empleadoSeleccionado = (Empleado) spinnerEmpleados.getSelectedItem();
            Departamento departamentoSeleccionado = (Departamento) spinnerDepartamentos.getSelectedItem();

            if (empleadoSeleccionado != null && departamentoSeleccionado != null) {
                String asignacion = empleadoSeleccionado.getNombre() + " asignado a " + departamentoSeleccionado.getNombre();
                dataManager.getListaAsignaciones().add(asignacion);
                adapter.notifyDataSetChanged();
                Toast.makeText(this, "Empleado asignado al departamento", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Por favor, selecciona un empleado y un departamento", Toast.LENGTH_SHORT).show();
            }
        });
    }
}