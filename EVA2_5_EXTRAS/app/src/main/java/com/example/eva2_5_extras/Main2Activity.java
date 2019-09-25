package com.example.eva2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    Button boton2;
    TextView txtRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intRecibido = getIntent(); // Es el intent con el que se crea esta actividad
        String mensaje = intRecibido.getStringExtra("mensaje"); //Se puede acceder a los extras

        txtRecibido = findViewById(R.id.textView);
        txtRecibido.setText(mensaje);

        boton2 = findViewById(R.id.button2);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
