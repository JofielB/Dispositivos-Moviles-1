package com.example.kipo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class AddPlant extends AppCompatActivity implements View.OnClickListener {
    Button btnBack;
    Button b1,b2,b3,b4,b5,b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_add_plant);
        asignarBotones();
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        Button selected = (Button) view;
        //selected.setEnabled(true);
        //selected.getBackground().getState();
    }
    public void asignarBotones(){
        b1 = findViewById(R.id.button9);
        b2 = findViewById(R.id.button10);
        b3 = findViewById(R.id.button11);
        b4 = findViewById(R.id.button12);
        b5 = findViewById(R.id.button13);
        b6 = findViewById(R.id.button14);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
    }

}
