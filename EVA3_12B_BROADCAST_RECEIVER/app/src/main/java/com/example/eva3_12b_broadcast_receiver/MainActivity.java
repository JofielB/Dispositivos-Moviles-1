package com.example.eva3_12b_broadcast_receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView texto;

    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = findViewById(R.id.texto);
        broadcastReceiver = new MiReceptorDifusion();
        IntentFilter filtro = new IntentFilter("MI_SERVICIO");
        registerReceiver(broadcastReceiver,filtro);


    }
    class MiReceptorDifusion extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            texto.setText(texto.getText() +
                    intent.getStringExtra("MENSAJE")
                    +"\n");
        }
    }
}
