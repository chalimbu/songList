package co.com.appmusicszeb.appmusic.services.impl;

import co.com.appmusicszeb.appmusic.dao.ICancionDao;
import co.com.appmusicszeb.appmusic.model.ListaReproduccion;
import co.com.appmusicszeb.appmusic.services.ICancionService;
import co.com.appmusicszeb.appmusic.util.Response;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CancionService implements ICancionService {

    @Autowired
    private ICancionDao cancionDao;

    @Override
    @Transactional
    public Response<ListaReproduccion> save(ListaReproduccion guardar) {
        Response res= new Response<ListaReproduccion>();
        if(guardar.getName()==null || guardar.getName().isEmpty()){
            res.setState(false);
            res.setCodeMessage(400);
            res.setMessage("Bad request");
        }else{
            res.setState(true);
            res.setCodeMessage(201);
            res.setMessage("Created");
            res.setMessageBody(cancionDao.save(guardar));
        }
        return res;
    }

    @Override
    @Transactional
    public ArrayList<ListaReproduccion> getAll() {
        ArrayList<ListaReproduccion> todas=new ArrayList<>();
        for(ListaReproduccion lista: cancionDao.findAll()){
            todas.add(lista);
        }
        return todas;
    }

    @Override
    public Optional<String> getDescription(String listName) {
        Optional<ListaReproduccion> miLista=cancionDao.findById(listName);
        return miLista.map(x->x.getDescription());

    }

    @Override
    public Optional<ListaReproduccion> updateDescription(String listName, ListaReproduccion lista) {
        //TODO mis asked validation
        Optional<ListaReproduccion> miLista =cancionDao.findById(listName);
        miLista.map(name->{name.setDescription(lista.getDescription());
        return name;});
        return miLista;

    }

    @Override
    public boolean delete(String name) {
        boolean listExist=cancionDao.existsById(name);
        cancionDao.deleteById(name);
        return listExist;
    }


}
