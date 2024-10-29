package com.example.echotech;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class GestionProyectosActivity extends AppCompatActivity {

    private List<Proyecto> listaProyectos = new ArrayList<>();
    private ArrayAdapter<Proyecto> adapter;
    private ListView listViewProyectos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_proyectos);

        EditText etNombreProyecto = findViewById(R.id.etNombreProyecto);
        EditText etDescripcionProyecto = findViewById(R.id.etDescripcionProyecto);
        Button btnGuardarProyecto = findViewById(R.id.btnGuardarProyecto);
        listViewProyectos = findViewById(R.id.listViewProyectos);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaProyectos);
        listViewProyectos.setAdapter(adapter);

        btnGuardarProyecto.setOnClickListener(v -> {
            String nombreProyecto = etNombreProyecto.getText().toString();
            String descripcionProyecto = etDescripcionProyecto.getText().toString();

            if (!nombreProyecto.isEmpty() && !descripcionProyecto.isEmpty()) {
                Proyecto proyecto = new Proyecto(nombreProyecto, descripcionProyecto);
                listaProyectos.add(proyecto);
                adapter.notifyDataSetChanged(); // Actualiza el ListView
                Toast.makeText(this, "Proyecto guardado", Toast.LENGTH_SHORT).show();

                etNombreProyecto.setText("");
                etDescripcionProyecto.setText("");
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}