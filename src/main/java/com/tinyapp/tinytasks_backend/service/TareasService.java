package com.tinyapp.tinytasks_backend.service;

import com.tinyapp.tinytasks_backend.model.Tareas;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class TareasService {
    // Lista de tareas
    private final List<Tareas> tareas = new ArrayList<>();
    // Este se utiliza para generar el id
    private final AtomicLong contador = new AtomicLong(1);

    // Metodo GET (Listar todas las tareas)
    public List<Tareas> listar() {
        if(tareas.isEmpty()){
            System.out.println("No hay tareas registradas");
        }
        return tareas;
    }


}
