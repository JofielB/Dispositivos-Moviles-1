package com.example.eva2_activity_stack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    Button boton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        boton2 = findViewById(R.id.btnAct2);

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //destruye la actividad actual y regresa a la actividad anterior
            }
        });
    }
}
