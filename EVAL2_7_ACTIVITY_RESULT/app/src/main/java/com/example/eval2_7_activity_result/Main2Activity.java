package com.example.eval2_7_activity_result;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {


    Button enviar,cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        enviar = findViewById(R.id.btn_enviar);
        cancelar = findViewById(R.id.btn_cancelar);

        final Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.putExtra("MENSAJE","Data received");

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_CANCELED,intent);
                finish();
            }
        });
    }



}
