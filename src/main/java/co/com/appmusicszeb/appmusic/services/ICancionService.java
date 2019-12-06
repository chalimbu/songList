package co.com.appmusicszeb.appmusic.services;

import co.com.appmusicszeb.appmusic.model.ListaReproduccion;
import co.com.appmusicszeb.appmusic.util.Response;

import java.util.ArrayList;
import java.util.Optional;

public interface ICancionService {
    ListaReproduccion save(ListaReproduccion guardar);
    ArrayList<ListaReproduccion> getAll();
    Optional<String> getDescription(String listName);
    Optional<ListaReproduccion> updateDescription(String listName,ListaReproduccion lista);
}
