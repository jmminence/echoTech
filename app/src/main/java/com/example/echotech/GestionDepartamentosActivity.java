package com.example.echotech;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class GestionDepartamentosActivity extends AppCompatActivity {

    private ArrayAdapter<Departamento> adapter;
    private EditText etNombreDepartamento, etGerente;
    private int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_departamentos);

        etNombreDepartamento = findViewById(R.id.etNombreDepartamento);
        etGerente = findViewById(R.id.etGerente);
        Button btnGuardarDepartamento = findViewById(R.id.btnGuardarDepartamento);
        ListView listViewDepartamentos = findViewById(R.id.listViewDepartamentos);

        DataManager dataManager = DataManager.getInstance();

        // Inicializar departamentos predefinidos solo si la lista está vacía
        if (dataManager.getListaDepartamentos().isEmpty()) {
            dataManager.getListaDepartamentos().add(new Departamento("Desarrollo Sostenible", "Gerente 1"));
            dataManager.getListaDepartamentos().add(new Departamento("Investigación y Desarrollo", "Gerente 2"));
            dataManager.getListaDepartamentos().add(new Departamento("Ventas", "Gerente 3"));
            dataManager.getListaDepartamentos().add(new Departamento("Recursos Humanos", "Gerente 4"));
        }

        // Configurar el adaptador
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataManager.getListaDepartamentos());
        listViewDepartamentos.setAdapter(adapter);

        btnGuardarDepartamento.setOnClickListener(v -> {
            String nombre = etNombreDepartamento.getText().toString();
            String gerente = etGerente.getText().toString();

            if (!nombre.isEmpty() && !gerente.isEmpty()) {
                if (selectedIndex == -1) {
                    Departamento departamento = new Departamento(nombre, gerente);
                    dataManager.getListaDepartamentos().add(departamento);
                    Toast.makeText(this, "Departamento guardado", Toast.LENGTH_SHORT).show();
                } else {
                    Departamento departamento = dataManager.getListaDepartamentos().get(selectedIndex);
                    departamento.setNombre(nombre);
                    departamento.setGerente(gerente);
                    Toast.makeText(this, "Departamento actualizado", Toast.LENGTH_SHORT).show();
                    selectedIndex = -1;
                }
                adapter.notifyDataSetChanged();
                etNombreDepartamento.setText("");
                etGerente.setText("");
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            }
        });

        listViewDepartamentos.setOnItemClickListener((parent, view, position, id) -> {
            Departamento departamento = dataManager.getListaDepartamentos().get(position);
            etNombreDepartamento.setText(departamento.getNombre());
            etGerente.setText(departamento.getGerente());
            selectedIndex = position;
        });

        listViewDepartamentos.setOnItemLongClickListener((parent, view, position, id) -> {
            dataManager.getListaDepartamentos().remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Departamento eliminado", Toast.LENGTH_SHORT).show();
            return true;
        });
    }
}