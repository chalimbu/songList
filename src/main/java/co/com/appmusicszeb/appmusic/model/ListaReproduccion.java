package co.com.appmusicszeb.appmusic.model;

import java.util.ArrayList;

public class ListaReproduccion {
    private String name;
    private String description;
    private ArrayList<Cancion> songs;

    public ListaReproduccion() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Cancion> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Cancion> songs) {
        this.songs = songs;
    }
}
