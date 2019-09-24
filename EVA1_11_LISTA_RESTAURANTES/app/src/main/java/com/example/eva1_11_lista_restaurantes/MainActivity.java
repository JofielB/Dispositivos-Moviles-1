package com.example.eva1_11_lista_restaurantes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {
    Restaurante[] arregloRestaurantes ={
      new Restaurante(),
      new Restaurante(R.drawable.pizza,"La Gran Pizza", "Pizzas que se pueden comer"),
      new Restaurante(R.drawable.postres,"Los Super Postres", "Servimos rico"),
      new Restaurante(R.drawable.lasagna,"La Ok Lasagna", "Lasagnas que estan ok")

    };
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.lista);
        lista.setAdapter(new RestauranteAdapter(this,
                R.layout.layout_restaurante,
                arregloRestaurantes));
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this,"Me tocas me compras",Toast.LENGTH_SHORT).show();
    }
}
