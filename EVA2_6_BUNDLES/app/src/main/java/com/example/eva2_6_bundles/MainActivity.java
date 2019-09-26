package com.example.eva2_6_bundles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView nombre;
    TextView apellido;
    EditText telefono;
    RadioGroup sexo;
    Button enviar;
    Intent intento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtApellidos);
        telefono = findViewById(R.id.etxTelefono);
        sexo = findViewById(R.id.rgSexo);
        enviar = findViewById(R.id.btnEnviar);
        intento = new Intent(this,Main2Activity.class);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //INGRESAR DATOS AL INTENT
                //BUNDLE ES UN EQUIPAMENTO DE EXTRAS
                Bundle bundle = new Bundle();
                bundle.putString("nombre",nombre.getText().toString());
                bundle.putString("apellido",apellido.getText().toString());
                bundle.putInt("telefono",Integer.parseInt(telefono.getText().toString()));
                int cSexo;
                if(sexo.getCheckedRadioButtonId() == R.id.rdHombre){
                    cSexo = 1;
                }else{
                    cSexo = 0;
                }
                bundle.putInt("sexo",cSexo);
                intento.putExtras(bundle); //Se le dan todos los bundle
                startActivity(intento);
            }
        });
    }
}
