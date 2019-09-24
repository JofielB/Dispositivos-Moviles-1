package com.example.eva2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    /*Los intentos son protocolos para comunicar actividades
    *Para lanzar actividades
    *starActivity no espera resultados
    * starActivityForResult espera resultados
    */
    Intent inLanzar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inLanzar = new Intent(this,Main2Activity.class);
    }

    public void lanzarActivity(View a){
        startActivity(inLanzar);
    }
}
