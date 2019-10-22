package com.example.eva2_8_activity_result_lista;

public class Restaurante {
    private int imagen;
    private String nombre;
    private String eslogan;

    public Restaurante(){
        imagen = R.drawable.taco;
        nombre = "El Buen Taco";
        eslogan = "Son buenos tacos";
    }

    public Restaurante(int imagen, String nombre, String eslogan) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.eslogan = eslogan;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEslogan() {
        return eslogan;
    }

    public void setEslogan(String eslogan) {
        this.eslogan = eslogan;
    }
}
