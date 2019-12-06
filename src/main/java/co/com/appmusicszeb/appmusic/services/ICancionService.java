package co.com.appmusicszeb.appmusic.services;

import co.com.appmusicszeb.appmusic.model.ListaReproduccion;
import co.com.appmusicszeb.appmusic.util.Response;

public interface ICancionService {
    Response save(ListaReproduccion guardar);
}
