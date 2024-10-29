package com.example.echotech;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnRegistroEmpleados).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistroEmpleadosActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnGestionDepartamentos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GestionDepartamentosActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnAsignacionEmpleados).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AsignacionEmpleadosActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnRegistroTiempo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistroTiempoActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnGestionProyectos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GestionProyectosActivity.class);
                startActivity(intent);
            }
        });
    }
}