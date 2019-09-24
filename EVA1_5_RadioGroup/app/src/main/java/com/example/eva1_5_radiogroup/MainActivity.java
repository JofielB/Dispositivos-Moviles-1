package com.example.eva1_5_radiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    RadioGroup comida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        comida = findViewById(R.id.rgComida);
        comida.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        String mensaje = "";
        if(i == R.id.radioButton2){
            mensaje = "Pastel";
        }else if(i == R.id.radioButton3){
            mensaje = "Pollo";
        }else if(i == R.id.radioButton4){
            mensaje = "Pizza";
        }else{
            mensaje = "Papitas";
        }
        Toast.makeText(this, mensaje,Toast.LENGTH_SHORT).show();
    }
}
