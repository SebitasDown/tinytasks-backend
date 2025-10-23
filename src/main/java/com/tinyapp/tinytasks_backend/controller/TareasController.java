package com.tinyapp.tinytasks_backend.controller;

import com.tinyapp.tinytasks_backend.model.Tareas;
import com.tinyapp.tinytasks_backend.service.TareasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareasController {
    private final TareasService tareasService;

    public TareasController(TareasService tareasService) {
        this.tareasService = tareasService;
    }

    @GetMapping
    public ResponseEntity<List<Tareas>> listarTareas(){
        List<Tareas> lista = tareasService.listar();
        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<Tareas> crearTarea(@RequestBody Tareas nuevaTarea){
        Tareas creada = tareasService.agregarTarea(nuevaTarea);
        return ResponseEntity.ok(creada);
    }
}
