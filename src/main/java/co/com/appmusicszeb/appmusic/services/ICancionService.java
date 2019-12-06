package co.com.appmusicszeb.appmusic.services;

import co.com.appmusicszeb.appmusic.model.ListaReproduccion;
import co.com.appmusicszeb.appmusic.util.Response;

import java.util.ArrayList;

public interface ICancionService {
    ListaReproduccion save(ListaReproduccion guardar);
    ArrayList<ListaReproduccion> getAll();
}
