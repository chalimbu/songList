package co.com.appmusicszeb.appmusic.services;

import co.com.appmusicszeb.appmusic.model.ListaReproduccion;
import co.com.appmusicszeb.appmusic.util.Response;

import java.util.ArrayList;
import java.util.Optional;

public interface ICancionService {
    Response<ListaReproduccion> save(ListaReproduccion guardar);
    Response<ArrayList<ListaReproduccion>> getAll();
    Response<String> getDescription(String listName);
    Response<ListaReproduccion> updateDescription(String listName,ListaReproduccion lista);
    Response<Boolean>  delete(String name);
}
