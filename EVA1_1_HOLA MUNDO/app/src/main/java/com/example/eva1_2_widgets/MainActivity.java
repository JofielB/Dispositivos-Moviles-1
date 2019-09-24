package com.example.eva1_2_widgets;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtViewMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtViewMensaje = findViewById(R.id.txtVwMensaje);
        txtViewMensaje.setText(R.string.txt_mensaje);
    }
}
