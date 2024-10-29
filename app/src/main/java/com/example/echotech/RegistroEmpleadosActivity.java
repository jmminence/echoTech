package com.example.echotech;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistroEmpleadosActivity extends AppCompatActivity {

    private ArrayAdapter<Empleado> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_empleados);

        EditText etNombre = findViewById(R.id.etNombre);
        EditText etDireccion = findViewById(R.id.etDireccion);
        EditText etTelefono = findViewById(R.id.etTelefono);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etFechaInicio = findViewById(R.id.etFechaInicio);
        EditText etSalario = findViewById(R.id.etSalario);
        Button btnGuardarEmpleado = findViewById(R.id.btnGuardarEmpleado);
        ListView listViewEmpleados = findViewById(R.id.listViewEmpleados);

        DataManager dataManager = DataManager.getInstance();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataManager.getListaEmpleados());
        listViewEmpleados.setAdapter(adapter);

        btnGuardarEmpleado.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString();
            String direccion = etDireccion.getText().toString();
            String telefono = etTelefono.getText().toString();
            String email = etEmail.getText().toString();
            String fechaInicio = etFechaInicio.getText().toString();
            String salarioStr = etSalario.getText().toString();

            if (!nombre.isEmpty() && !direccion.isEmpty() && !telefono.isEmpty() && !email.isEmpty() && !fechaInicio.isEmpty() && !salarioStr.isEmpty()) {
                try {
                    double salario = Double.parseDouble(salarioStr);
                    Empleado empleado = new Empleado(nombre, direccion, telefono, email, fechaInicio, salario);
                    dataManager.getListaEmpleados().add(empleado);
                    adapter.notifyDataSetChanged(); // Actualiza el ListView
                    Toast.makeText(this, "Empleado guardado", Toast.LENGTH_SHORT).show();

                    etNombre.setText("");
                    etDireccion.setText("");
                    etTelefono.setText("");
                    etEmail.setText("");
                    etFechaInicio.setText("");
                    etSalario.setText("");
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Por favor, ingresa un salario válido", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}