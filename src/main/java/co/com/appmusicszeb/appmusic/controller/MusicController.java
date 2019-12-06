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
    public ListaReproduccion saveSong(@RequestBody ListaReproduccion nuevaLista) {
        return cancionService.save(nuevaLista);
    }

    @GetMapping(value="/lists")
    public ArrayList<ListaReproduccion> getList(){
        return cancionService.getAll();
    }


}



