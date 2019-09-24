package com.example.eva2_2_intentos_llamada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
/*Se lanzara la pantalla de marcacion --> no requiere permisos
* Llamar directamente --> requiere permisos
* */
public class MainActivity extends AppCompatActivity {
    EditText telefono;
    Intent marcar;
    Button llamar;
    Button mandarNumero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        telefono = findViewById(R.id.numTel);

        llamar = findViewById(R.id.button);
        llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = "tel:"+telefono.getText().toString();
                //URI: uniform resource identificator
                marcar = new Intent(Intent.ACTION_CALL,Uri.parse(numero));
                startActivity(marcar);
            }
        });

        mandarNumero = findViewById(R.id.button2);
        mandarNumero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = "tel:"+telefono.getText().toString();
                //URI: uniform resource identificator
                marcar = new Intent(Intent.ACTION_DIAL,Uri.parse(numero));
                startActivity(marcar);
            }
        });
    }


}
