package com.dam.proyectospring.webclient;

import com.dam.proyectospring.modelos.Piloto;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PilotoClient {
    private final WebClient client;

    public PilotoClient(String baseUrl) {
        this.client = WebClient.create(baseUrl);
    }

    public Flux<Piloto> getAllPilotos() {
        return client.get()
                .uri("/api/pilotos")
                .retrieve()
                .bodyToFlux(Piloto.class);
    }

    public Mono<Piloto> getPiloto(Long id) {
        return client.get()
                .uri("/api/piloto/{id}", id)
                .retrieve()
                .bodyToMono(Piloto.class);
    }

    public Mono<Piloto> addPiloto(Piloto piloto) {
        return client.post()
                .uri("/api/pilotos")
                .body(Mono.just(piloto), Piloto.class)
                .retrieve()
                .bodyToMono(Piloto.class);
    }

    public Mono<Piloto> updatePiloto(Long id, Piloto piloto) {
        return client.put()
                .uri("/api/pilotos/{id}", id)
                .body(Mono.just(piloto), Piloto.class)
                .retrieve()
                .bodyToMono(Piloto.class);
    }

}
