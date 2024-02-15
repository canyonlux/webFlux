package com.dam.proyectospring.servicios;

import com.dam.proyectospring.modelos.Piloto;
import com.dam.proyectospring.repositorios.PilotoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PilotoServicioImpl implements PilotoServicio {
    private final PilotoRepositorio pilotoRepositorio;

    @Autowired
    public PilotoServicioImpl(PilotoRepositorio pilotoRepositorio) {
        this.pilotoRepositorio = pilotoRepositorio;
    }

    @Override
    public List<Piloto> findAllPilotos() {
        return pilotoRepositorio.findAll();
    }

    @Override
    public Piloto findPilotoById(String id) {
        Optional<Piloto> piloto = pilotoRepositorio.findById(id);
        return piloto.orElse(null);
    }

    @Override
    public Piloto addPiloto(Piloto piloto) {
        return pilotoRepositorio.save(piloto);
    }

    @Override
    public Piloto updatePiloto(String id, Piloto piloto) {
        if (pilotoRepositorio.existsById(id)) {
            piloto.setId(id);
            return pilotoRepositorio.save(piloto);
        }
        return null;
    }

    @Override
    public boolean deletePiloto(String id) {
        if (pilotoRepositorio.existsById(id)) {
            pilotoRepositorio.deleteById(id);
            return true;
        }
        return false;
    }

}
