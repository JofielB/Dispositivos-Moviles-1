package com.example.eva1_4_eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    private Button btnInterfaz;
    private Button btnAnonimo;
    private Button btnClase;
    private MiEventoClick evento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Boton Interfaz
        btnInterfaz = findViewById(R.id.btnPorInt);
        btnInterfaz.setOnClickListener(this);
        //Boton por Clase Anonima
        btnAnonimo = findViewById(R.id.btnPorClaseAnonima);
        btnAnonimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Brindemos Anonimamente", Toast.LENGTH_SHORT).show();
            }
        });
        //Boton por clase externa
        btnClase = findViewById(R.id.btnPorClase);
        evento = new MiEventoClick();
        evento.setContexto(this);
        btnClase.setOnClickListener(evento);

    }

    public void myClick(View v){
        Toast.makeText(this, "Brindemos", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Brindemos por intefaz", Toast.LENGTH_SHORT).show();
    }
}
