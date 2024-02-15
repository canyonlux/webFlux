package com.dam.proyectospring.servicios;

import com.dam.proyectospring.modelos.Piloto;
import java.util.List;

public interface PilotoServicio {
    List<Piloto> findAllPilotos();
    Piloto findPilotoById(String id);
    Piloto addPiloto(Piloto piloto);
    Piloto updatePiloto(String id, Piloto piloto);
    boolean deletePiloto(String id);

}
