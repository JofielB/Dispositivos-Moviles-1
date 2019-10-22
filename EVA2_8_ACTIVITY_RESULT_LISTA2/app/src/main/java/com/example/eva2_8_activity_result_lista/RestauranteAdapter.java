package com.example.eva2_8_activity_result_lista;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RestauranteAdapter extends ArrayAdapter<Restaurante> {
    Context contexto;
    int recurso;
    Restaurante[] restaurantes;

    public RestauranteAdapter(Context context, int resource, Restaurante[] objects) {
        super(context, resource, objects);
        contexto = context;
        recurso = resource;
        restaurantes = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView  imgRestaurante;          //imgClima;
        TextView   txtNombre, txtEslogan;  //txtCiudad, txtTemperatura, txtClima;

        //CONVERTVIEW ES UNA FILA DE LA LISTA
        if(convertView == null){
            //CREAR NUESTRO LAYOUT
            //INFLATER
            LayoutInflater lInflater = ((Activity)contexto).getLayoutInflater();
            convertView = lInflater.inflate(recurso,parent,false);
        }
        //SACAMOS DE LA CONVERVIEW LOS DATOS QUE NECESITAMOS
        imgRestaurante = convertView.findViewById(R.id.fondo);
        txtNombre = convertView.findViewById(R.id.textoPrincipal);
        txtEslogan = convertView.findViewById(R.id.textoSecundario);
        //LO LLENAMOS
        imgRestaurante.setImageResource(restaurantes[position].getImagen());
        txtNombre.setText(restaurantes[position].getNombre());
        txtEslogan.setText(restaurantes[position].getEslogan());

        return convertView;
    }
}
