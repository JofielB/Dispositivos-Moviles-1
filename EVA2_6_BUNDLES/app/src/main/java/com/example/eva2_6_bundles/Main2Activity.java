package com.example.eva2_6_bundles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView recibido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recibido = findViewById(R.id.txtRecibir);
        Intent intento = getIntent();
        Bundle bundle =  intento.getExtras();
        recibido.append(bundle.getString("nombre")+"");
        recibido.append(bundle.getString("apellido")+"");
        recibido.append(bundle.getInt("telefono")+"");
        if(bundle.getInt("sexo")==1){//Hombre
            recibido.append("Hombre");
        }else{
            recibido.append("Mujer");
        }

    }
}
