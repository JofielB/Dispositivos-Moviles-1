package com.example.eva3_9_asynk_banner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    boolean state = true;
    int tiempo = 900;
    int[] tiempos = {900,800,700,600,500,400,300,200,100,50};
    int contador = 0;
    SeekBar barra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyAsyncClass myAsyncClass = new MyAsyncClass();
        myAsyncClass.execute();
        image = findViewById(R.id.imageView);
        barra = findViewById(R.id.seekBar);
        barra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tiempo =tiempos[i];
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public class MyAsyncClass extends AsyncTask<Integer,String ,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            switch(contador){
                case 0:
                    image.setImageResource(R.drawable.atmospher);
                    contador++;
                    break;
                case 1:
                    image.setImageResource(R.drawable.cloudy);
                    contador++;
                    break;
                case 2:
                    image.setImageResource(R.drawable.tornado);
                    contador++;
                    break;
                case 3:
                    image.setImageResource(R.drawable.snow);
                    contador = 0;
                    break;

            }
        }

        @Override
        protected String doInBackground(Integer... integers) {
            while (state){
                try {
                    Thread.sleep(tiempo);
                    publishProgress();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }



    }

    @Override
    protected void onStop() {
        super.onStop();
        state = false;
    }
}
