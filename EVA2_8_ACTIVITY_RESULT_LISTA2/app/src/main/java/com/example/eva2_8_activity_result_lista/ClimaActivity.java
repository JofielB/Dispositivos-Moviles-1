package com.example.eva2_8_activity_result_lista;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ClimaActivity extends AppCompatActivity  implements ListView.OnItemClickListener{
    Clima[] cCiudades = {
            new Clima(),
            new Clima(R.drawable.atmospher,19.8,"Ciudad 2","Templado"),
            new Clima(R.drawable.cloudy,24,"Ciudad 3","Nublado"),
            new Clima(R.drawable.rainy,14,"Ciudad 4","Lluvioso"),
            new Clima(R.drawable.snow,-4,"Ciudad 5","Nevado"),
            new Clima(R.drawable.thunderstorm,9.8,"Ciudad 6","Truenos"),
            new Clima(R.drawable.tornado,12,"Ciudad 7","Tornado"),
    };
    ListView listaClima;
    Intent intWeather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clima);
        intWeather = new Intent(this,MainActivity.class);

        listaClima = findViewById(R.id.listaClima);
        listaClima.setAdapter(new ClimaAdapter(this,
                R.layout.layout_clima,cCiudades));
        listaClima.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(this,cCiudades[i].getCiudad(),Toast.LENGTH_SHORT).show();

        //int imagen, double temperatura, String ciudad, String clima

        String ciudad = cCiudades[i].getCiudad();
        intWeather.putExtra("MENSAJE",""+ciudad);
        intWeather.putExtra("IMG",""+cCiudades[i].getImagen());
        intWeather.putExtra("TEMP",""+cCiudades[i].getTemperatura());
        intWeather.putExtra("CITY",""+cCiudades[i].getCiudad());
        intWeather.putExtra("WEATHER",""+cCiudades[i].getClima());
        setResult(Activity.RESULT_OK,intWeather);
        finish();
    }
}
