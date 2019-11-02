package com.example.eva3_3_hilo_ejemplo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView imagen;
    String URL = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRG40aL5F2EaEWgrQsW59tEiXRJsnROKcyzbE2DQEgRuGE4cw6t";
    Bitmap bitmap;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            imagen.setImageBitmap(bitmap);
        }
    };

    Thread hilo = new Thread(){
        @Override
        public void run() {
            super.run();
            bitmap = cargarImagen(URL);//Cargar la imagen en el hilo
            Message msg = handler.obtainMessage();//Hacer mensaje
            handler.sendMessage(msg);//Mandar mensaje o señal de que ya se obtuvo el mensaje para invocar el handler
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen = findViewById(R.id.imageView);

       // bitmap = cargarImagen(URL);

       //imagen.setImageBitmap(bitmap);

        hilo.start();
    }

    private Bitmap cargarImagen(String url){
        Bitmap imagen = null;
        try {
            InputStream input = (InputStream) new URL(url).getContent();
            imagen = BitmapFactory.decodeStream(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imagen;
    }

}
