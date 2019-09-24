package com.example.eva1_7_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnMagic;
    TextView txtMen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMagic = findViewById(R.id.btnMagia);
        txtMen = findViewById(R.id.txtMensaje);

        btnMagic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMen.append("Pastel "+"\n");
            }
        });
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Log.wtf("PANTALLA", "PORTRAIT");
        }else{
            Log.wtf("PANTALLA", "LANDSCAPE");
        }
    }

}
