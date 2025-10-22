package com.tinyapp.tinytasks_backend.service;

import com.tinyapp.tinytasks_backend.model.Tareas;
import com.tinyapp.tinytasks_backend.repository.TareasRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class TareasService {

    private final TareasRepository tareaRepository;
    public TareasService (TareasRepository tareaRepository){
        this.tareaRepository = tareaRepository;
    }


    // Metodo para agregar
    public Tareas agregarTarea(Tareas tarea){
        // Tarea por defecto como no hecha
        tarea.setDone(false);

        if(tarea.getTitle() == null || tarea.getTitle().isEmpty()){
            throw new IllegalArgumentException("Error, No puede estar vacio el titulo");
        }
        return tareaRepository.agregar(tarea);
    }

    // Metodo GET (Listar todas las tareas)
    public List<Tareas> listar() {
      return tareaRepository.obtenerTodas() ;
    }




}
