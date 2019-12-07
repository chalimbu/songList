package co.com.appmusicszeb.appmusic.controller;

import co.com.appmusicszeb.appmusic.model.Cancion;
import co.com.appmusicszeb.appmusic.model.ListaReproduccion;
import co.com.appmusicszeb.appmusic.services.ICancionService;
import co.com.appmusicszeb.appmusic.services.application.trasformers.ResponseTransformer;
import co.com.appmusicszeb.appmusic.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class MusicController {

    @Autowired
    ICancionService cancionService;

    @PostMapping(value = "/lists")
    public ResponseEntity saveSong(@RequestBody ListaReproduccion nuevaLista) {
        return ResponseTransformer.transformFromResponse(cancionService.save(nuevaLista));
    }

    @GetMapping(value="/lists")
    public ResponseEntity getLists(){
        return ResponseTransformer.transformFromResponse(cancionService.getAll());
    }

    @GetMapping(value="/lists/{name}")
    public ResponseEntity getListDescription(@PathVariable(value="name") String nombre){
        return ResponseTransformer.transformFromResponse(cancionService.getDescription(nombre));
    }

    @PutMapping(value="/lists/{name}")
    public ResponseEntity modifiedList(@PathVariable(value="name") String nombre,@RequestBody ListaReproduccion update){
        return ResponseTransformer.transformFromResponse(cancionService.updateDescription(nombre,update));
    }

    @DeleteMapping(value="/lists/{name}")
    public ResponseEntity deleteList(@PathVariable(value="name") String nombre){
        return ResponseTransformer.transformFromResponse(cancionService.delete(nombre));
    }

}



