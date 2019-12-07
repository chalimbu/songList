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
    public Response<ArrayList<ListaReproduccion>> getAll() {
        ArrayList<ListaReproduccion> todas=new ArrayList<>();
        for(ListaReproduccion lista: cancionDao.findAll()){
            todas.add(lista);
        }
        return new Response<>(todas,200,true);
    }

    @Override
    public Response<String> getDescription(String listName) {
        Optional<ListaReproduccion> miLista=cancionDao.findById(listName);
        if(miLista.isPresent()){
            return new Response(miLista.orElse(new ListaReproduccion()),200,true);
        }else{
            return new Response(null,404,false);
        }
    }

    @Override
    public Response<ListaReproduccion> updateDescription(String listName, ListaReproduccion lista) {
        if(listName.equals(lista.getName())){
            Optional<ListaReproduccion> miLista=cancionDao.findById(listName);
            if(miLista.isPresent()){
                miLista.map(x->{x.setDescription(lista.getDescription());return x;});
                return new Response<>(cancionDao.save(miLista.get()),204,false);
            }else{
                return new Response<>(null,404,false);
            }
        }else {
            return new Response(null,409,false);
        }
    }

    @Override
    public Response<Boolean> delete(String name) {
        boolean listExist=cancionDao.existsById(name);
        if(listExist){
            cancionDao.deleteById(name);
            return new Response(listExist,204,false);
        }else{
            return  new Response(null,404,false);
        }

    }


}
