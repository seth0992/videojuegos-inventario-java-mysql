

1. **Crear el proyecto:**

El proyecto se creara en Java With Maven.

2. **Configurar la base de datos:**
    - Crear la base de datos en MySQL:
    ```sql
    CREATE DATABASE inventario_videojuegos;
    USE inventario_videojuegos;
    CREATE TABLE videojuegos (
        id INT AUTO_INCREMENT PRIMARY KEY,
        titulo VARCHAR(255) NOT NULL,
        plataforma VARCHAR(255) NOT NULL,
        genero VARCHAR(255) NOT NULL,
        precio DECIMAL(10, 2) NOT NULL,
        stock INT NOT NULL
    );
    ```

3. **Configurar el archivo de conexión:**
    - Editar el archivo `VideojuegosDAO.java` para actualizar las credenciales de la base de datos:
    ```java
    private static final String URL = "jdbc:mysql://localhost:3306/inventario_videojuegos";
    private static final String USER = "tu_usuario";
    private static final String PASSWORD = "tu_contraseña";
    ```

4. **Compilar y ejecutar el proyecto:**
    - Compilar el proyecto:
    ```sh
    javac -cp .:mysql-connector-java-8.0.28.jar VideojuegosDAO.java
    ```
    - Ejecutar el proyecto:
    ```sh
    java -cp .:mysql-connector-java-8.0.28.jar VideojuegosDAO
    ```

## Uso

- **Agregar Videojuego:**
    ```java
    VideojuegosDAO dao = new VideojuegosDAO();
    dao.agregarVideojuego("The Legend of Zelda", "Nintendo Switch", "Aventura", 59.99, 10);
    ```

- **Listar Videojuegos:**
    ```java
    dao.listarVideojuegos();
    ```

- **Buscar Videojuego:**
    ```java
    dao.buscarVideojuego("titulo", "Zelda");
    ```

- **Actualizar Videojuego:**
    ```java
    dao.actualizarVideojuego(1, "The Legend of Zelda", "Nintendo Switch", "Aventura", 59.99, 8);
    ```

- **Eliminar Videojuego:**
    ```java
    dao.eliminarVideojuego(1);
    ```

## Contribución

1. Haz un fork del proyecto.
2. Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz commit (`git commit -am 'Agrega nueva característica'`).
4. Envía los cambios a tu rama (`git push origin feature/nueva-caracteristica`).
5. Abre un Pull Request.