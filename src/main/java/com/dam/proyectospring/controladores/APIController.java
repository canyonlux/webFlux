package com.dam.proyectospring.controladores;

import com.dam.proyectospring.modelos.Piloto;
import com.dam.proyectospring.servicios.PilotoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class APIController {
    private final PilotoServicio pilotoServicio;

    @Autowired
    public APIController(PilotoServicio pilotoServicio) {
        this.pilotoServicio = pilotoServicio;
    }

    // GET de todos los pilotos
    @GetMapping (value = "/api/pilotos")
    public ResponseEntity<List<Piloto>> getAllPilots() {
        List<Piloto> pilotos = pilotoServicio.findAllPilotos();
        return new ResponseEntity<>(pilotos, HttpStatus.OK);
    }

    // GET de un piloto por ID
    @GetMapping("/api/piloto/{id}")
    public ResponseEntity<Piloto> getPilot(@PathVariable long id) {
        Piloto piloto = pilotoServicio.findPilotoById(String.valueOf(id));
        if (piloto != null) {
            return new ResponseEntity<>(piloto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST para crear un nuevo piloto
    @PostMapping("/api/pilotos")
    public ResponseEntity<Piloto> addPilot(@RequestBody Piloto piloto) {
        Piloto nuevoPiloto = pilotoServicio.addPiloto(piloto);
        return new ResponseEntity<>(nuevoPiloto, HttpStatus.CREATED);
    }

    // PUT para actualizar un piloto
    @PutMapping("/api/pilotos/{id}")
    public ResponseEntity<Piloto> updatePilot(@PathVariable long id, @RequestBody Piloto piloto) {
        Piloto pilotoActualizado = pilotoServicio.updatePiloto(String.valueOf(id), piloto);
        if (pilotoActualizado != null) {
            return new ResponseEntity<>(pilotoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE para borrar un piloto
    @DeleteMapping("/api/pilotos/{id}")
    public ResponseEntity<Void> deletePilot(@PathVariable long id) {
        boolean eliminado = pilotoServicio.deletePiloto(String.valueOf(id));
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
