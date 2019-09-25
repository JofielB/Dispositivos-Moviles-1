package com.example.eva2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button boton1;
    Intent intento;
    EditText txtEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEnviar = findViewById(R.id.editText);

        intento = new Intent(this,Main2Activity.class);

        boton1 = findViewById(R.id.button);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sMensaje = txtEnviar.getText().toString();
                intento.putExtra("mensaje",sMensaje); //Extra que se envia a la actividad que se lanzara / Nombre del mensaje y mensaje
                startActivity(intento);
            }
        });

    }
}
