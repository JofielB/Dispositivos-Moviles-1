package com.example.eva2_3_mensaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText numero;
    TextView mensaje;
    Button boton;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numero = findViewById(R.id.editText);
        mensaje = findViewById(R.id.mensaje);
        boton = findViewById(R.id.button);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sUri = "smsto:" + numero.getText().toString(); //Crear mensaje de uri con numero de telefono
                intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(sUri)); //Crear intent
                intent.putExtra("sms_body",mensaje.getText().toString());//Poner el extra con el texto del mensaje
                startActivity(intent);//Lanzarlo
            }
        });
    }
}
