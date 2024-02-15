package com.dam.proyectospring.webclient;

import com.dam.proyectospring.modelos.Piloto;
import com.dam.proyectospring.webclient.PilotoClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Scanner;

public class Main {
    static PilotoClient pilotoClient = new PilotoClient("http://localhost:8080");
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("1. Mostrar todos los pilotos");
            System.out.println("2. Mostrar un piloto por ID");
            System.out.println("3. Crear un piloto");
            System.out.println("4. Actualizar un piloto");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    mostrarTodosLosPilotos();
                    break;
                case 2:
                    mostrarPilotoPorId();
                    break;
                case 3:
                    crearPiloto();
                    break;
                case 4:
                    actualizarPiloto();
                    break;
                    case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor elige otra opción.");
            }
        }
    }




    private static void mostrarTodosLosPilotos() {
        Flux<Piloto> pilotos = pilotoClient.getAllPilotos();
        pilotos.subscribe(
                piloto -> System.out.println(piloto),
                error -> System.out.println("Error al recuperar los pilotos: " + error.getMessage())
        );
    }

    private static void mostrarPilotoPorId() {
        System.out.print("Ingresa el ID del piloto: ");
        Long id = scanner.nextLong();
        Mono<Piloto> pilotoMono = pilotoClient.getPiloto(id);
        pilotoMono.subscribe(
                piloto -> System.out.println(piloto),
                error -> System.out.println("Error al recuperar el piloto: " + error.getMessage())
        );
    }

    private static void crearPiloto() {
        Piloto nuevoPiloto = new Piloto();
        // Aquí recogerías los datos del piloto, por ejemplo:
        System.out.print("Nombre del piloto: ");
        String nombre = scanner.next();
        nuevoPiloto.setNombre(nombre);

        // Otros datos del piloto...

        Mono<Piloto> pilotoCreado = pilotoClient.addPiloto(nuevoPiloto);
        pilotoCreado.subscribe(
                piloto -> System.out.println("Piloto creado: " + piloto),
                error -> System.out.println("Error al crear el piloto: " + error.getMessage())
        );
    }


    private static void actualizarPiloto() {
        System.out.print("ID del piloto a actualizar: ");
        Long id = scanner.nextLong();

        Piloto pilotoActualizado = new Piloto();
        // Recoger los nuevos datos del piloto...
        System.out.print("Nuevo nombre del piloto: ");
        pilotoActualizado.setNombre(scanner.next());

        // Otros datos del piloto...

        Mono<Piloto> pilotoActualizadoMono = pilotoClient.updatePiloto(id, pilotoActualizado);
        pilotoActualizadoMono.subscribe(
                piloto -> System.out.println("Piloto actualizado: " + piloto),
                error -> System.out.println("Error al actualizar el piloto: " + error.getMessage())
        );
    }

}

