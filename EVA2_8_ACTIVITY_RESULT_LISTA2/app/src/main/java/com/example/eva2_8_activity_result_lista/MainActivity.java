package com.example.eva2_8_activity_result_lista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent intentoClima;
    Intent intentoRestaurante;
    Button botonClima;
    Button botonRestaurante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentoClima = new Intent(this,ClimaActivity.class);
        botonClima = findViewById(R.id.btnClima);
        botonClima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentoClima);
            }
        });

        intentoRestaurante = new Intent(this,RestauranteActivity.class);
        botonRestaurante = findViewById(R.id.btnRestaurante);
        botonRestaurante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentoRestaurante);
            }
        });
    }
}
