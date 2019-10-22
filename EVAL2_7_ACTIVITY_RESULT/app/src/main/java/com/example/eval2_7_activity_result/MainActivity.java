package com.example.eval2_7_activity_result;

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

    Button lanzar;
    TextView datos;
    Intent intent;
    final int SECUNDARAIA = 4200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lanzar = findViewById(R.id.btn_lanzar);
        datos = findViewById(R.id.txv_datos);

        intent = new Intent(this, Main2Activity.class);

        lanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(intent, SECUNDARAIA); // A la actividad se le asigna su codigo de identificacion(requestCode)
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case SECUNDARAIA:
                //Algunos con los datos
                if(resultCode == Activity.RESULT_OK){ //resultCode es la seleccion que da el usuario
                    //Aqui recibimos datos
                    datos.setText(data.getStringExtra("MENSAJE"));
                }else {
                    Toast.makeText(this, "ACCION CANSELADA", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

}
