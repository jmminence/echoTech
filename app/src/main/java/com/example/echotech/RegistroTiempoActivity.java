package com.example.echotech;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class RegistroTiempoActivity extends AppCompatActivity {

    private ArrayList<RegistroTiempo> registros;
    private ArrayAdapter<String> adapter;
    private ListView listViewRegistrosTiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_tiempo);

        EditText etHorasTrabajadas = findViewById(R.id.etHorasTrabajadas);
        EditText etDescripcion = findViewById(R.id.etDescripcion);
        Button btnRegistrarTiempo = findViewById(R.id.btnRegistrarTiempo);
        listViewRegistrosTiempo = findViewById(R.id.listViewRegistrosTiempo);

        registros = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
        listViewRegistrosTiempo.setAdapter(adapter);

        btnRegistrarTiempo.setOnClickListener(v -> {
            String horasStr = etHorasTrabajadas.getText().toString();
            String descripcion = etDescripcion.getText().toString();

            if (!horasStr.isEmpty() && !descripcion.isEmpty()) {
                try {
                    int horas = Integer.parseInt(horasStr);
                    RegistroTiempo registro = new RegistroTiempo(horas, descripcion);
                    registros.add(registro);
                    adapter.add("Horas: " + horas + " - " + descripcion);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(this, "Registro de tiempo guardado", Toast.LENGTH_SHORT).show();

                    etHorasTrabajadas.setText("");
                    etDescripcion.setText("");
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Por favor, ingresa un número válido de horas", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}