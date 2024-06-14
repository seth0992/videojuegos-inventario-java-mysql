# Sistema de Gestión de Inventario de Videojuegos

## Descripción

Este proyecto es un sistema de gestión de inventario de videojuegos desarrollado en Java, utilizando MySQL como base de datos. Permite agregar, listar, buscar, actualizar y eliminar registros de videojuegos en el inventario.

## Funcionalidades

- **Agregar Videojuegos:** Permite ingresar nuevos videojuegos al inventario.
- **Listar Videojuegos:** Muestra una lista de todos los videojuegos disponibles.
- **Buscar Videojuegos:** Permite buscar videojuegos por Título o Plataforma.
- **Actualizar Videojuego:** Permite actualizar la información de un videojuego existente.
- **Eliminar Videojuego:** Permite eliminar un videojuego del inventario.

## Requisitos

- Java JDK 8 o superior
- MySQL 5.7 o superior
- MySQL Connector/J (si se usa Maven, la dependencia se agrega automáticamente)

## Guía de Desarrollo (Paso a Paso)

1. **Crear la Base de Datos:**

    - Se deberá crear la base de datos en MySQL, utilizando el siguiente script:

    ```sql
    -- Crear la base de datos 'inventario_videojuegos'
    
    CREATE DATABASE inventario_videojuegos;

    -- Utilizar la base de datos 'inventario_videojuegos'
    USE inventario_videojuegos;

    -- Crear la tabla 'videojuegos'
    CREATE TABLE videojuegos (
        id INT AUTO_INCREMENT PRIMARY KEY,  --Auto incremental y clave primaria
        titulo VARCHAR(255) NOT NULL,       --VARCHAR con un máximo de 255 caracteres, no puede ser nula
        plataforma VARCHAR(255) NOT NULL,   --VARCHAR con un máximo de 255 caracteres, no puede ser nula
        genero VARCHAR(255) NOT NULL,       --VARCHAR con un máximo de 255 caracteres, no puede ser nula
        precio DECIMAL(10, 2) NOT NULL,     --DECIMAL con un total de 10 dígitos y 2 decimales, no puede ser nula
        stock INT NOT NULL,                 --Entero, no puede ser nula
        imagen LONGBLOB                     --LONGBLOB para almacenar datos binarios grandes, como imágenes
    );

    ```

2. **Creación y Configuración del Proyecto:**

    - Ahora se deberá crear el proyecto utilizando el **IDE Netbeans** y seleccionado la categoría **Java with MAVEN** y la plantilla de proyecto **Java Application** a como se muestra imagen:

    ![Creación de proyecto](./img/proyecto1.png)

    - En la siguiente ventana se colocara el nombre del proyecto, el *group id* puede dejarse a como esta por defecto y la *version* se establecerá en 1.0

    ![Creación de proyecto](./img/proyecto2.png)

    - 
    ```sql
    CREATE DATABASE inventario_videojuegos;
    USE inventario_videojuegos;
    CREATE TABLE videojuegos (
        id INT AUTO_INCREMENT PRIMARY KEY,
        titulo VARCHAR(255) NOT NULL,
        plataforma VARCHAR(255) NOT NULL,
        genero VARCHAR(255) NOT NULL,
        precio DECIMAL(10, 2) NOT NULL,
        stock INT NOT NULL,
        imagen LONGBLOB
    );
    ```

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.

## Contacto

- **Autor:** Jeremy Elizondo
- **Correo:** 
- **GitHub:** [seth0992](https://github.com/seth0992)

