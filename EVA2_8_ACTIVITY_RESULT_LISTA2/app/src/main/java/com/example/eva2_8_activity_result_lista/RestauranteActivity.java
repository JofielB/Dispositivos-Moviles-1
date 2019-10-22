package com.example.eva2_8_activity_result_lista;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class RestauranteActivity extends AppCompatActivity implements ListView.OnItemClickListener{

    Restaurante[] arregloRestaurantes ={
            new Restaurante(),
            new Restaurante(R.drawable.pizza,"La Gran Pizza", "Pizzas que se pueden comer"),
            new Restaurante(R.drawable.pastel,"Los Super Postres", "Servimos rico"),
    };
    ListView lista;
    Intent intRestaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);
        intRestaurant = new Intent(this,MainActivity.class);
        lista = findViewById(R.id.lista);
        lista.setAdapter(new RestauranteAdapter(this,
                R.layout.layout_restaurante,
                arregloRestaurantes));
        lista.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(this,"Me tocas me compras",Toast.LENGTH_SHORT).show();
        String restaurant = arregloRestaurantes[i].getNombre();
        intRestaurant.putExtra("MENSAJE",""+restaurant);
        setResult(Activity.RESULT_OK,intRestaurant);
        finish();
    }
}
