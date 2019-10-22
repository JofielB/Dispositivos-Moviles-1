package com.example.eva2_8_activity_result_lista;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent intentoClima;
    Intent intentoRestaurante;
    Button botonClima;
    Button botonRestaurante;
    TextView text;
    final int WEATHER = 4200;
    final int RESTAURANTS = 6900;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.txtTest);
        intentoClima = new Intent(this,ClimaActivity.class);
        botonClima = findViewById(R.id.btnClima);
        botonClima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(intentoClima,WEATHER);
            }
        });

        intentoRestaurante = new Intent(this,RestauranteActivity.class);
        botonRestaurante = findViewById(R.id.btnRestaurante);
        botonRestaurante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(intentoRestaurante,RESTAURANTS);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case WEATHER:
                if(resultCode == Activity.RESULT_OK){ //resultCode es la seleccion que da el usuario
                    //Aqui recibimos datos
                    text.setText("You chose the city: "+data.getStringExtra("MENSAJE"));
                }else {
                    Toast.makeText(this, "ACCION CANSELADA", Toast.LENGTH_SHORT).show();
                }
                break;
            case RESTAURANTS:
                if(resultCode == Activity.RESULT_OK){ //resultCode es la seleccion que da el usuario
                    //Aqui recibimos datos
                    text.setText("You chose the restaurant: "+data.getStringExtra("MENSAJE"));
                }else {
                    Toast.makeText(this, "ACCION CANSELADA", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}
