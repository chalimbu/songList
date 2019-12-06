package co.com.appmusicszeb.appmusic.dao;

import co.com.appmusicszeb.appmusic.model.ListaReproduccion;
import org.springframework.data.repository.CrudRepository;

public interface ICancionDao extends CrudRepository<ListaReproduccion,String> {
}
