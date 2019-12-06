package co.com.appmusicszeb.appmusic.services.impl;

import co.com.appmusicszeb.appmusic.dao.ICancionDao;
import co.com.appmusicszeb.appmusic.model.ListaReproduccion;
import co.com.appmusicszeb.appmusic.services.ICancionService;
import co.com.appmusicszeb.appmusic.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CancionService implements ICancionService {

    @Autowired
    private ICancionDao cancionDao;

    @Override
    @Transactional
    public Response save(ListaReproduccion guardar) {
        Response mi=new Response();
        if(guardar.getName().isEmpty() || guardar.getName()==null){
            mi.setState(false);
            mi.setCodeMessage(400);
        }else{
            mi.setState(true);
            mi.setCodeMessage(201);
            mi.setMessageBody(cancionDao.save(guardar));
        }
        return mi;
    }
}
