package com.interfazgrafica.version1.controllers;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.interfazgrafica.version1.services.FirebaseService;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private FirebaseService firebaseService;

    @PostMapping("/save/{name}")
    public String saveData(
            @PathVariable String name, // Nombre que se envía en la URL
            @RequestBody Object data   // Datos a guardar (puede ser un Map, un POJO, etc.)
    ) throws Exception {
        String collectionName = "users"; // Colección configurada internamente
        firebaseService.saveData(collectionName, data); // El ID se genera automáticamente
        return "Data saved successfully for user: " + name;
    }


    @GetMapping("/test-save/{name}")
    public String testSaveData(
            @PathVariable String name, // Nombre que se envía en la URL
            @RequestParam String email, // Email como parámetro de la URL
            @RequestParam int age // Edad como parámetro de la URL
    ) throws Exception {
        String collectionName = "users"; // Colección configurada internamente

        // Crear un mapa para simular el cuerpo de la solicitud
        Map<String, Object> data = new HashMap<>();
        data.put("name", name); // Guardar el nombre en el mapa
        data.put("email", email); // Guardar el email en el mapa
        data.put("age", age); // Guardar la edad en el mapa

        //Nombre, Responsable, Fecha limite-----------------------------------------------
    

        firebaseService.saveData(collectionName, data); // El ID se genera automáticamente
        return "Data saved successfully for user: " + name;
    }

    @GetMapping("/actividad-save/{name}")
    public String actividadSaveData(
            @PathVariable String name, // Nombre que se envía en la URL
            @RequestParam String responsable, // Email como parámetro de la URL
            @RequestParam int date // Edad como parámetro de la URL
    ) throws Exception {
        String collectionName = "actividad"; // Colección configurada internamente

        // Crear un mapa para simular el cuerpo de la solicitud
        Map<String, Object> data = new HashMap<>();
        data.put("name", name); // Guardar el nombre en el mapa
        data.put("responsable", responsable); // Guardar nombre del responsable en el mapa
        data.put("date", date); // Guardar la fecha de entrega en el mapa

        //Nombre, Responsable, Fecha limite-----------------------------------------------
    

        firebaseService.saveData(collectionName, data); // El ID se genera automáticamente
        return "Data saved successfully for user: " + name;
    }
}
//localhost:8080/api/test-save/JohnDoe?email=alejandro%40example.com&age=39
//localhost:8080/api/actividad-save/Prueba?responsable=Oswaldo&date=24032025