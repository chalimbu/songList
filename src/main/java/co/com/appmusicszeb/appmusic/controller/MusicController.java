package co.com.appmusicszeb.appmusic.controller;

import co.com.appmusicszeb.appmusic.model.Cancion;
import co.com.appmusicszeb.appmusic.model.ListaReproduccion;
import co.com.appmusicszeb.appmusic.services.ICancionService;
import co.com.appmusicszeb.appmusic.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MusicController {

    @Autowired
    ICancionService cancionService;

    @PostMapping(value = "/lists")
    public ListaReproduccion sendViaResponseEntity(@RequestBody ListaReproduccion nuevaLista) {
        Response res=cancionService.save(nuevaLista);
        if(res.getState()){
            throw new BadRequest();
        }else{
            return (ListaReproduccion)res.getMessageBody();
        }
    }


}

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    class BadRequest extends RuntimeException{ }

