package com.example.eva1_9_listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {
    ListView lvLista;
    TextView texto;
    String[] comida ={"Pastel","Tacos","Pizza","Tortas",
    "Montados","Bolas de arroz","Hamburgesa",
    "Gorditas","Ceveza","Anis","Ron","Four loko",
    "Ginebra","Tequila"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvLista = findViewById(R.id.lv_listaDatos);
        texto = findViewById(R.id.txt_Seleccion);
        lvLista.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,comida));
        lvLista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        texto.setText(comida[i]);
    }
}
