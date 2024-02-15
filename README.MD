Proyecto de Gestión de Pilotos con Spring Boot y Spring Webflux

Descripción
Este proyecto consiste en dos partes principales:

API REST con Spring Boot: Una aplicación de servidor que gestiona información sobre pilotos, almacenada en una base de datos MongoDB.
Cliente de Consola con Spring Webflux: Una aplicación de consola que interactúa con la API REST para realizar operaciones CRUD sobre los datos de los pilotos.

Características
API REST: Crea, lee, actualiza y elimina información de pilotos.
Cliente Reactivo: Interactúa de forma reactiva con la API utilizando WebClient de Spring Webflux.
Base de Datos MongoDB: Almacenamiento persistente de datos de pilotos.

Requisitos
Java JDK 17 o superior.
Maven para la gestión de dependencias y construcción del proyecto.
MongoDB instalado y ejecutándose localmente o accesible a través de la red.
Configuración y Ejecución
API REST
Clona el repositorio y navega al directorio del proyecto.
Configura tu cadena de conexión a MongoDB en application.properties.

La API estará disponible en http://localhost:8080/.

Cliente de Consola

Interactúa con la aplicación a través de la consola.
Uso del Cliente de Consola
La aplicación de consola ofrece las siguientes opciones:

Mostrar todos los pilotos.
Mostrar un piloto dado un ID.
Crear un piloto con nuevos datos.
Actualizar un piloto dado un ID concreto.
Borrar un piloto dado un ID.
Selecciona una opción e ingresa los datos requeridos según las instrucciones en la consola.

Tecnologías Utilizadas
Spring Boot
Spring Data MongoDB
Spring Webflux
Maven
Java
Contribuciones
Las contribuciones son bienvenidas.
